package com.sarunas.test;

import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import com.sarunas.model.Shipment;
import com.sarunas.service.ShippingPrice;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ShippingPriceTest {

    @Test
    public void testCalculateShippingPricePackageSProviderMR() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 1));
        shipment.setPackageSize(PackageSize.S);
        shipment.setProvider(Provider.MR);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-01 S MR 1.50 0.50";
        assertEquals(expectedMessage, printedMessage);
    }

    @Test
    public void testCalculateShippingPricePackageMProviderMR() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 8));
        shipment.setPackageSize(PackageSize.M);
        shipment.setProvider(Provider.MR);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-08 M MR 3.00 -";
        assertEquals(expectedMessage, printedMessage);
    }

    @Test
    public void testCalculateShippingPricePackageLProviderMR() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 7));
        shipment.setPackageSize(PackageSize.L);
        shipment.setProvider(Provider.MR);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-07 L MR 4.00 -";
        assertEquals(expectedMessage, printedMessage);
    }

    @Test
    public void testCalculateShippingPricePackageSProviderLP() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 5));
        shipment.setPackageSize(PackageSize.S);
        shipment.setProvider(Provider.LP);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-05 S LP 1.50 -";
        assertEquals(expectedMessage, printedMessage);
    }

    @Test
    public void testCalculateShippingPricePackageMProviderLP() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 13));
        shipment.setPackageSize(PackageSize.M);
        shipment.setProvider(Provider.LP);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-13 M LP 4.90 -";
        assertEquals(expectedMessage, printedMessage);
    }

    @Test
    public void testCalculateShippingPricePackageLProviderLP() {
        ShippingPrice shippingPrice = new ShippingPrice();
        Shipment shipment = new Shipment();
        shipment.setDate(LocalDate.of(2015, 2, 3));
        shipment.setPackageSize(PackageSize.L);
        shipment.setProvider(Provider.LP);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        shippingPrice.calculateShippingPrice(shipment);
        System.setOut(System.out);
        String printedMessage = outputStream.toString().trim();
        String expectedMessage = "2015-02-03 L LP 6.90 -";
        assertEquals(expectedMessage, printedMessage);
    }
}
