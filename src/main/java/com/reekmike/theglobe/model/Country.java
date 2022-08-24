package com.reekmike.theglobe.model;

public class Country {
    private String countryCode;
    private String countryName;

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String toString() {
        return "country code: " + countryCode + ", country name: " + countryName + "\n";
    }
}
