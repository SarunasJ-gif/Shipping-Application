package com.sarunas.service;

import com.sarunas.util.AllShipmentPrices;
import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import com.sarunas.model.Shipment;

public class LargePackageDiscount implements Discount {

    private static int lastMonth;
    private static int count = 1;

    @Override
    public double calculateDiscount(Shipment shipment) {
        double discount = AllShipmentPrices.getPricePackageLProviderLp();
        int month = shipment.getDate().getMonthValue();
        if (hasDiscount(shipment)) {
            if (month == lastMonth) {
                count++;
            } else {
                count = 1;
            }
            if (count == 3) {
                return discount;
            }
            lastMonth = month;
        }
        return 0;
    }

    private boolean hasDiscount(Shipment shipment) {
        return shipment.getPackageSize().equals(PackageSize.L)
                && shipment.getProvider().equals(Provider.LP);
    }
}
