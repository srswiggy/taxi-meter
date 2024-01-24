package org.example;

import java.util.List;

public class Fare {
    private final double distance;
    private final int waitTime;
    private static final double MINIMUM_FARE = 25;
    private static final double FARE_PER_KM = 12;
    private static final double WAITING_FARE_PER_MIN = 2;

    private static final double BASE_FARE = 2;

    private static final double SERVICE_FEE = 1;

    Fare(double distance, int waitTime) {
        validateInputs(distance, waitTime); // Encapsulated validation
        this.distance = distance;
        this.waitTime = waitTime;
    }

    private void validateInputs(double distance, int waitTime) {
        if (distance < 0 || waitTime < 0) {
            throw new IllegalArgumentException("The values cannot be negative");
        }
    }

    private double totalFare() {
        return (this.distance * FARE_PER_KM) + (this.waitTime * WAITING_FARE_PER_MIN) + BASE_FARE;
    }

    private double calculateServiceFee(double totalFare) {
        return (totalFare * SERVICE_FEE)/100;
    }

    public double calculate() {

        double totalFare = totalFare();

        if(totalFare > 100) {
            totalFare += calculateServiceFee(totalFare);
        }


        return Math.max(MINIMUM_FARE, totalFare);
    }

    public static double calculateForAll(List<Fare> fareList) {
        double fareSum = 0.0;
        for(Fare fare: fareList) {
            fareSum += fare.calculate();
        }

        return fareSum;
    }

    public static double calculateTotalServiceFee(List<Fare> fareList) {
        double totalServiceFee = 0.0;
        for(Fare fare: fareList) {
            totalServiceFee += fare.calculateServiceFee(fare.totalFare());
        }

        return totalServiceFee;
    }
}
