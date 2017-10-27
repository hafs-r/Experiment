package com.hafsalrahman.ssstest.data.remote;

import com.hafsalrahman.ssstest.data.AppDataStore;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by hafsal on 10/24/17.
 */

public class AppRemoteDataStore implements AppDataStore {


    private Retrofit retrofit;


    public AppRemoteDataStore(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Single<UsersResponse> getUsers() {
        return retrofit.create(UserService.class).getUserList();
    }
}
