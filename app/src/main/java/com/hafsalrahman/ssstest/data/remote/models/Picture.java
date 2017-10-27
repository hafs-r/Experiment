package com.hafsalrahman.ssstest.data.remote.models;

/**
 * Created by hafsal on 10/25/17.
 */

public class Picture {


    public final String large;
    public final String medium;
    public final String thumbnail;

    public Picture(String large, String medium, String thumbnail) {
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return thumbnail;
    }
}
