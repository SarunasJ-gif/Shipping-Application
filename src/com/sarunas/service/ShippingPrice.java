package com.sarunas.service;

import com.sarunas.model.*;
import com.sarunas.util.AllShipmentPrices;

import java.util.Arrays;

public class ShippingPrice implements Price {

    private static final double MAX_DISCOUNT_PER_MONTH = 10;
    private static int lastMonth;
    private static double allDiscountsPerMonth;
    private final Discount[] discounts = {
            new SmallPackageDiscount(), new LargePackageDiscount()
    };

    @Override
    public void calculateShippingPrice(Shipment shipment) {
        int month = shipment.getDate().getMonthValue();
        double discount = Arrays.stream(discounts).mapToDouble(d -> d.calculateDiscount(shipment)).sum();
        if (month != lastMonth) allDiscountsPerMonth = 0;
        if ((discount + allDiscountsPerMonth) > MAX_DISCOUNT_PER_MONTH) {
            discount = MAX_DISCOUNT_PER_MONTH - allDiscountsPerMonth;
        }
        allDiscountsPerMonth = (month == lastMonth) ? allDiscountsPerMonth + discount : discount;
        lastMonth = month;
        double price = AllShipmentPrices.getShippingPrice(shipment) - discount;
        printPriceAndDiscount(discount, price, shipment);
    }

    private void printPriceAndDiscount(double discount, double price, Shipment shipment) {
        String discountToPrint = (discount == 0.00) ? "-" : formatDoubleValue(discount);
        String priceToPrint = formatDoubleValue(price);
        ShipmentInfo shipmentInfo = ShipmentInfo.builder()
                .date(shipment.getDate())
                .packageSize(shipment.getPackageSize())
                .provider(shipment.getProvider())
                .price(priceToPrint)
                .discount(discountToPrint)
                .build();
        System.out.println(shipmentInfo.toString());
    }

    private String formatDoubleValue(double value) {
        return String.format("%.2f", value);
    }
}
