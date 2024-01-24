package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FareTest {

    // check positive distance
    @Test
    void testIfDistance00IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(0, 10);
        });
    }
    @Test
    void testIfPositiveDistance100IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(100, 10);
        });
    }

    @Test
    void testIfPositiveDistance123IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(123, 10);
        });
    }

    // check negative distance
    @Test
    void testIfNegativeDistance100IsInValid() {
        assertThrows(IllegalArgumentException.class, () -> new Fare(-100, 10));
    }

    @Test
    void testIfNegativeDistance123IsInValid() {
        assertThrows(IllegalArgumentException.class, () -> new Fare(-123, 10));
    }

    // check positive wait time
    @Test
    void testIfWaitTime00IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(10, 0);
        });
    }
    @Test
    void testIfPositiveWaitTime100IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(100, 100);
        });
    }

    @Test
    void testIfPositiveWaitTime13IsValid() {
        assertDoesNotThrow(()-> {
            new Fare(123, 13);
        });
    }

    // check negative wait time
    @Test
    void testIfNegativeWaitTime100IsInValid() {
        assertThrows(IllegalArgumentException.class, ()-> new Fare(100, -100));
    }

    @Test
    void testIfNegativeWaitTime13IsInValid() {
        assertThrows(IllegalArgumentException.class, ()->new Fare(123, -13));
    }

    // test minimum fair
    @Test
    void testIfMinimumFareIs25() {
        Fare fare = new Fare(0, 0);
        assertEquals(fare.calculate(), 25);
    }

    @Test
    void testIfMinimumFareIf25For2Km0WaitTime() {
        Fare fare = new Fare(2, 0);
        assertEquals(26, fare.calculate());
    }

    @Test
    void testFor30Km20MinFareIs400() {
        Fare fare = new Fare(30, 20);
        assertEquals(406.02, fare.calculate(), 0.1);
    }

    @Test
    void testTotalFareFor0Rides() {
        List<Fare> fareList = new ArrayList<>();

        double calculateTotalFair = Fare.calculateForAll(fareList);

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

        double calculateTotalFair = Fare.calculateForAll(fareList);

        assertEquals(260, calculateTotalFair);
    }

    @Test
    void testTotalServiceFeePaid() {
        List<Fare> fareList = new ArrayList<>(Arrays.asList(
                new Fare(12, 2),
                new Fare(21, 12),
                new Fare(12, 3)
        ));

        double totalServiceFee = Fare.calculateTotalServiceFee(fareList);

        assertEquals(5.7, totalServiceFee, 0.1);
    }
}