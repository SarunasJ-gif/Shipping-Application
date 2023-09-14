package com.sarunas.util;

import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import com.sarunas.model.Shipment;
import com.sarunas.model.ShippingParameters;

import java.util.HashMap;
import java.util.Map;

public class AllShipmentPrices {

    private final static double PRICE_PACKAGE_S_PROVIDER_MR = 2.00;
    private final static double PRICE_PACKAGE_M_PROVIDER_MR = 3.00;
    private final static double PRICE_PACKAGE_L_PROVIDER_MR = 4.00;
    private final static double PRICE_PACKAGE_S_PROVIDER_LP = 1.50;
    private final static double PRICE_PACKAGE_M_PROVIDER_LP = 4.90;
    private final static double PRICE_PACKAGE_L_PROVIDER_LP = 6.90;

    public static double getShippingPrice(Shipment shipment) {
        Map<ShippingParameters, Double> shippingPrice = new HashMap<>();
        shippingPrice.put(new ShippingParameters(PackageSize.S, Provider.MR), PRICE_PACKAGE_S_PROVIDER_MR);
        shippingPrice.put(new ShippingParameters(PackageSize.M, Provider.MR), PRICE_PACKAGE_M_PROVIDER_MR);
        shippingPrice.put(new ShippingParameters(PackageSize.L, Provider.MR), PRICE_PACKAGE_L_PROVIDER_MR);
        shippingPrice.put(new ShippingParameters(PackageSize.S, Provider.LP), PRICE_PACKAGE_S_PROVIDER_LP);
        shippingPrice.put(new ShippingParameters(PackageSize.M, Provider.LP), PRICE_PACKAGE_M_PROVIDER_LP);
        shippingPrice.put(new ShippingParameters(PackageSize.L, Provider.LP), PRICE_PACKAGE_L_PROVIDER_LP);
        ShippingParameters key = new ShippingParameters(shipment.getPackageSize(), shipment.getProvider());
        return shippingPrice.get(key);
    }

    public static double getPricePackageSProviderMr() {
        return PRICE_PACKAGE_S_PROVIDER_MR;
    }

    public static double getPricePackageSProviderLp() {
        return PRICE_PACKAGE_S_PROVIDER_LP;
    }

    public static double getPricePackageMProviderMr() {
        return PRICE_PACKAGE_M_PROVIDER_MR;
    }

    public static double getPricePackageLProviderMr() {
        return PRICE_PACKAGE_L_PROVIDER_MR;
    }

    public static double getPricePackageMProviderLp() {
        return PRICE_PACKAGE_M_PROVIDER_LP;
    }

    public static double getPricePackageLProviderLp() {
        return PRICE_PACKAGE_L_PROVIDER_LP;
    }

    public static double getSmallPackagesDifference() {
        return Math.abs(PRICE_PACKAGE_S_PROVIDER_MR - PRICE_PACKAGE_S_PROVIDER_LP);
    }
}
