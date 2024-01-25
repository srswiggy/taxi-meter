package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FaresTest {

    @Test
    void testTotalFareFor0Rides() {
        List<Fare> fareList = new ArrayList<>();

        double calculateTotalFair = new Fares(fareList).calculate();

        assertEquals(0, calculateTotalFair);
    }

    @Test
    void testTotalFareFor2Km10Rides() {
        List<Fare> fareList = new ArrayList<>(Arrays.asList(
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0),
                new Fare(2, 0)
        ));

        double calculateTotalFair = new Fares(fareList).calculate();

        assertEquals(260, calculateTotalFair);
    }

    @Test
    void testTotalServiceFeePaid() {
        List<Fare> fareList = new ArrayList<>(Arrays.asList(
                new Fare(12, 2),
                new Fare(21, 12),
                new Fare(12, 3)
        ));

        double totalServiceFee = new Fares(fareList).calculateServiceFee();

        assertEquals(5.7, totalServiceFee, 0.1);
    }
}