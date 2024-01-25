package org.example;

public class Fare {
    private final double distance;
    private final int waitTime;
    private static final double MINIMUM_FARE = 25;
    private static final double FARE_PER_KM = 12;
    private static final double WAITING_FARE_PER_MIN = 2;

    private static final double BASE_FARE = 2;

    private static final double SERVICE_FEE = 1;

    Fare(double distance, int waitTime) {
        if(distance < 0 || waitTime < 0) {
            throw new IllegalArgumentException("The values cannot be negative");
        }

        this.distance = distance;
        this.waitTime = waitTime;
    }

    public double calculate() {

        double totalFare = (this.distance * FARE_PER_KM) + (this.waitTime * WAITING_FARE_PER_MIN) + BASE_FARE;

        if(totalFare > 100) {
            totalFare += (totalFare * SERVICE_FEE)/100;
        }


        return Math.max(MINIMUM_FARE, totalFare);
    }
}
