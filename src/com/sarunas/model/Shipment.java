package com.sarunas.model;

import java.time.LocalDate;

public class Shipment {

    private LocalDate date;
    private PackageSize packageSize;
    private Provider provider;

    public Shipment() {}

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPackageSize(PackageSize packageSize) {
        this.packageSize = packageSize;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public LocalDate getDate() {
        return date;
    }

    public PackageSize getPackageSize() {
        return packageSize;
    }

    public Provider getProvider() {
        return provider;
    }
}
