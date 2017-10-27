package com.hafsalrahman.ssstest.data.local.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * Created by hafsal on 10/25/17.
 */

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id_info")
    @NonNull
    public String idInfo;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "gender")
    public String gender;

    @ColumnInfo(name = "thumbnail")
    public String thumbnail;

    public User(String idInfo, String title, String firstName, String lastName, String gender, String thumbnail) {

        this.idInfo = idInfo;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.thumbnail = thumbnail;


    }

    @Override
    public boolean equals(Object obj) {
        return this.idInfo.equals(((User) obj).idInfo);

    }
}

