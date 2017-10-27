package com.hafsalrahman.ssstest.data.remote.models;

/**
 * Created by hafsal on 10/25/17.
 */

public class Login {

    public final String username;
    public final String password;
    public final String salt;
    public final String md5;
    public final String sha1;
    public final String sha256;

    public Login(String username, String password, String salt, String md5, String sha1, String sha256) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    @Override
    public String toString() {
        return username + ",\\n" + password + ",\\n " + salt + ",\\n " + md5;
    }
}
