package com.sarunas.service;

import com.sarunas.model.Shipment;

public interface Discount {

    double calculateDiscount(Shipment shipment);
}
