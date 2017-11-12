package com.hafsalrahman.ssstest.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by hafsal on 10/25/17.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    Single<List<LocalUser>> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMultipleListRecord(List<LocalUser> localUsers);

    @Query("DELETE FROM users")
    void deleteAll();
}
