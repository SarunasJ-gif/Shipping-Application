package com.sarunas.model;

import java.util.Objects;

public class ShippingParameters {

    private PackageSize packageSize;
    private Provider provider;

    public ShippingParameters(PackageSize packageSize, Provider provider) {
        this.packageSize = packageSize;
        this.provider = provider;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingParameters that = (ShippingParameters) o;
        return packageSize == that.packageSize && provider == that.provider;
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageSize, provider);
    }
}
