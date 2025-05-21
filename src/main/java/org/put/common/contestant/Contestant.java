package org.put.common.contestant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Abstract base class for all contestants.
 */
public abstract class Contestant {
    private String name;
    private String sportType;
    private String country;

    private static final Set<String> COUNTRIES;
    static {
        Set<String> temp = new HashSet<>();
        Collections.addAll(temp, "Poland", "Germany", "France", "Italy", "Spain", "USA", "UK", "Canada", "Australia", "Japan");
        COUNTRIES = Collections.unmodifiableSet(temp);
    }

    public Contestant(String name, String sportType, String country) {
        this.name = name;
        this.sportType = sportType;
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws IllegalArgumentException {
        if (!COUNTRIES.contains(country)) {
            throw new IllegalArgumentException("Invalid country: " + country);
        }
        this.country = country;
    }
}