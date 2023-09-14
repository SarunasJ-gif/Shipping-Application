package com.sarunas;

import com.sarunas.controller.ShipmentController;

public class Main {

    public static void main(String[] args) {
        String file = "input.txt";
        ShipmentController shipment = new ShipmentController(file);
        shipment.run();
    }
}

