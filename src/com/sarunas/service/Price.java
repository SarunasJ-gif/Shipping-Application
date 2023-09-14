package com.sarunas.service;

import com.sarunas.model.Shipment;

public interface Price {

    void calculateShippingPrice(Shipment shipment);
}
