package com.hafsalrahman.ssstest.data.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hafsalrahman.ssstest.data.local.models.User;

import java.util.List;

/**
 * Created by hafsal on 10/24/17.
 */

public class UsersResponse {
    @SerializedName("total")
    @Expose
    public int total;
    @SerializedName("results")
    @Expose
    public List<User> users;

    public int getTotal() {
        return total;
    }

    public List<User> getUsers() {
        return users;
    }
}
