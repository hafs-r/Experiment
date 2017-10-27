package com.hafsalrahman.ssstest.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.hafsalrahman.ssstest.data.local.dao.UserDao;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

/**
 * Created by hafsal on 10/25/17.
 */

@Database(entities = {LocalUser.class}, version = 1, exportSchema = false)
public abstract class DataBaseSource extends RoomDatabase {
    public abstract UserDao getUserDao();

}
