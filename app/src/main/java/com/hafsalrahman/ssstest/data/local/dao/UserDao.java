package com.hafsalrahman.ssstest.data.local.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.hafsalrahman.ssstest.data.local.models.User;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by hafsal on 10/25/17.
 */

public interface UserDao {

    @Query("SELECT * FROM users")
    Single<UsersResponse> getUsers();

    @Insert
    void insertMultipleListRecord(List<User> users);
}
