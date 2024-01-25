package org.example;

import java.util.List;

public class Fares {
    public final List<Fare> fareList;

    Fares(List<Fare> fares) {
        this.fareList = fares;
    }

    public double calculate() {
        double fareSum = 0.0;
        for(Fare fare: fareList) {
            fareSum += fare.calculate();
        }

        return fareSum;
    }

    public double calculateServiceFee() {
        double totalServiceFee = 0.0;
        for(Fare fare: fareList) {
            totalServiceFee += fare.calculateServiceFee();
        }

        return totalServiceFee;
    }
}
