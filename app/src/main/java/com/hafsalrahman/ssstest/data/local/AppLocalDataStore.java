package com.hafsalrahman.ssstest.data.local;

import com.hafsalrahman.ssstest.data.AppDataStore;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by hafsal on 10/25/17.
 */

public class AppLocalDataStore implements AppDataStore {

    private DataBaseSource dataBaseSource;


    public AppLocalDataStore(DataBaseSource dataBaseSource) {
        this.dataBaseSource = dataBaseSource;
    }

    @Override
    public Single<List<LocalUser>> getUsers() {
        return dataBaseSource.getUserDao().getUsers();
    }

    public void insertUsers(List<LocalUser> localUsers) {
        //implement background process
        dataBaseSource.getUserDao().insertMultipleListRecord(localUsers);
    }

    public void deleteAll() {
        //implement background process
        dataBaseSource.getUserDao().deleteAll();
    }
}
