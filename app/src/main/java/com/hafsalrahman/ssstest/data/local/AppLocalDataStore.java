package com.hafsalrahman.ssstest.data.local;

import com.hafsalrahman.ssstest.data.AppDataStore;
import com.hafsalrahman.ssstest.data.local.models.User;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;

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
    public Single<UsersResponse> getUsers() {
       return dataBaseSource.getUserDao().getUsers();
    }

    public void insertUsers(List<User> users) {
       //implement background process
            dataBaseSource.getUserDao().insertMultipleListRecord(users);
    }
}
