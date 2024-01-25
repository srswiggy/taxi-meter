package org.example;

import org.junit.jupiter.api.Test;

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
        assertThrows(IllegalArgumentException.class, ()-> {
            new Fare(-100, 10);
        });
    }

    @Test
    void testIfNegativeDistance123IsInValid() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new Fare(-123, 10);
        });
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
        assertThrows(IllegalArgumentException.class, ()-> {
            new Fare(100, -100);
        });
    }

    @Test
    void testIfNegativeWaitTime13IsInValid() {
        assertThrows(IllegalArgumentException.class, ()-> {
            new Fare(123, -13);
        });
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
}