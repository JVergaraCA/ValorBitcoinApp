package com.desafiolatam.pricebtc.models;

/**
 * Created by JuanCarlos on 14-10-17.
 */

public class Indicator {

    private String currency;
    private double value;

    public Indicator() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
