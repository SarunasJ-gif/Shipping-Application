package com.sarunas.controller;

import com.sarunas.errors.ErrorHandling;
import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import com.sarunas.model.Shipment;
import com.sarunas.service.ShippingPrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class ShipmentController {

    private String file;

    public ShipmentController(String file) {
        this.file = file;
    }

    public void run() {
        ShippingPrice shippingPrice = new ShippingPrice();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Shipment shipment = new Shipment();
                ErrorHandling errorHandling = new ErrorHandling();
                String[] shipping = line.split(" ");
                if (!errorHandling.isCorrectInput(shipping)) {
                    errorHandling.printError(shipping);
                } else {
                    shipment.setDate(LocalDate.parse(shipping[0]));
                    shipment.setPackageSize(PackageSize.valueOf(shipping[1]));
                    shipment.setProvider(Provider.valueOf(shipping[2]));
                    shippingPrice.calculateShippingPrice(shipment);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
