package com.reekmike.theglobe.model;

public class Country {
    private String countryCode;

    private String countryName;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String toString() {
        return "code: " + countryCode + ", name: " + countryName + "\n";
    }
}
