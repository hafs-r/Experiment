package com.hafsalrahman.ssstest.data;

import com.hafsalrahman.ssstest.App;
import com.hafsalrahman.ssstest.data.local.AppLocalDataStore;
import com.hafsalrahman.ssstest.data.remote.AppRemoteDataStore;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;
import com.hafsalrahman.ssstest.utils.NetUtils;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hafsal on 10/24/17.
 */

public class AppRepository implements AppDataStore {


    @Inject
    public AppRemoteDataStore mAppRemoteDataStore;

    @Inject
    public AppLocalDataStore mAppLocalDataStore;

    @Inject
    public NetUtils mNetUtil;


    public AppRepository() {
        App.getAppComponent().inject(this);
    }

    @Override
    public Single<UsersResponse> getUsers() {

        Single<UsersResponse> singleResponse = null;
        if (mNetUtil.isNetworkAvailable()) {//check network availability and change data source

            singleResponse = mAppRemoteDataStore.getUsers();
            singleResponse.subscribeOn(Schedulers.io());
            singleResponse.subscribe(new Consumer<UsersResponse>() {
                @Override
                public void accept(@NonNull UsersResponse usersResponse) throws Exception {
                    mAppLocalDataStore.insertUsers(usersResponse.getUsers());
                }
            });

        } else {
            singleResponse = mAppLocalDataStore.getUsers();
        }

        return singleResponse;

    }
}

