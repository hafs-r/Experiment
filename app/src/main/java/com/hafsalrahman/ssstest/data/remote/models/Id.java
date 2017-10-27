package com.hafsalrahman.ssstest.data.remote.models;

/**
 * Created by hafsal on 10/25/17.
 */

public class Id {
    public final String name;
    public final String value;


    public Id(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + "_" + value;
    }
}

