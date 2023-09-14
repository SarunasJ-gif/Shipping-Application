package com.sarunas.service;

import com.sarunas.util.AllShipmentPrices;
import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import com.sarunas.model.Shipment;

public class SmallPackageDiscount implements Discount {

    @Override
    public double calculateDiscount(Shipment shipment) {
        double packageSizeSProviderMRPrice = AllShipmentPrices.getPricePackageSProviderMr();
        double packageSizeSProviderLPPrice = AllShipmentPrices.getPricePackageSProviderLp();
        double discount = AllShipmentPrices.getSmallPackagesDifference();
            if (shipment.getPackageSize().equals(PackageSize.S)) {
                if (shipment.getProvider().equals(Provider.MR)
                        && packageSizeSProviderMRPrice > packageSizeSProviderLPPrice
                    || shipment.getProvider().equals(Provider.LP)
                        && packageSizeSProviderLPPrice > packageSizeSProviderMRPrice) {
                return discount;
                }
            }
        return 0;
    }
}
