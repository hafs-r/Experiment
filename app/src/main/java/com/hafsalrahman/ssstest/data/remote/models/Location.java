package com.hafsalrahman.ssstest.data.remote.models;

/**
 * Created by hafsal on 10/25/17.
 */

public class Location {

    public final String street;
    public final String city;
    public final String state;
    public final String postcode;

    public Location(String street, String city, String state, String postcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return street + ",\\n" + city + ",\\n " + state + ",\\n " + postcode;
    }
}
