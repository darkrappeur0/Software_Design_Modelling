package org.put.contest.contestant;

public abstract class Contestant {
    private String name;
    private String sportType;
    private String country;
    private static final String[] countries = {
            "Poland", "Germany", "France", "Italy", "Spain", "USA", "UK", "Canada", "Australia", "Japan"
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String SportType() {
        return sportType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws IllegalArgumentException {
        boolean isValid = false;
        for (String validCountry : countries) {
            if (validCountry.equalsIgnoreCase(country)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid country: " + country);
        }

        this.country = country;
    }

}