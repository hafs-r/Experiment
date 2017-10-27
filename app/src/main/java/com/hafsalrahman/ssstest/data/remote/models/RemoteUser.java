package com.hafsalrahman.ssstest.data.remote.models;


/**
 * Created by hafsal on 10/24/17.
 */

public class RemoteUser {

    public final String gender;

    public final Name name;

    public final Location location;

    public final String email;
    public final Login login;
    public final String dob;
    public final String registered;
    public final String phone;
    public final String cell;
    public final Id id;
    public final Picture picture;
    public final String nat;

    public RemoteUser(String gender, Name name, Location location, String email, Login login, String dob, String registered, String phone, String cell, Id id, Picture picture, String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
        this.nat = nat;
    }


    @Override
    public String toString() {
        return name + " " + id.toString();
    }
}







