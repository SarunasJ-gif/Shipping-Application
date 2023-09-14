package com.sarunas.model;

import java.time.LocalDate;

public class ShipmentInfo {

    private final LocalDate date;
    private final PackageSize packageSize;
    private final Provider provider;
    private final String price;
    private final String discount;

    public ShipmentInfo(LocalDate date, PackageSize packageSize, Provider provider, String price, String discount) {
        this.date = date;
        this.packageSize = packageSize;
        this.provider = provider;
        this.price = price;
        this.discount = discount;
    }


    public static ShipmentInfoBuilder builder() {
        return new ShipmentInfoBuilder();
    }

    public static class ShipmentInfoBuilder {

        private LocalDate date;
        private PackageSize packageSize;
        private Provider provider;
        private String price;
        private String discount;

        public ShipmentInfoBuilder() {}

        public ShipmentInfoBuilder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ShipmentInfoBuilder packageSize(PackageSize packageSize) {
            this.packageSize = packageSize;
            return this;
        }

        public ShipmentInfoBuilder provider(Provider provider) {
            this.provider = provider;
            return this;
        }

        public ShipmentInfoBuilder price(String price) {
            this.price = price;
            return this;
        }

        public ShipmentInfoBuilder discount(String discount) {
            this.discount = discount;
            return this;
        }

        public ShipmentInfo build() {
            return new ShipmentInfo(date, packageSize, provider, price, discount);
        }
    }

    @Override
    public String toString() {
        return  date +
                " " + packageSize +
                " " + provider +
                " " + price +
                " " + discount;
    }
}
