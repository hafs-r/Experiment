package com.hafsalrahman.ssstest.data.remote.models;

/**
 * Created by hafsal on 10/25/17.
 */

public class Name {


    public final String title;
    public final String first;
    public final String last;

    public Name(String title, String first, String last) {
        this.title = title;
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return title + " " + first + " " + last;
    }

}
