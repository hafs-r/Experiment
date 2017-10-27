package com.hafsalrahman.ssstest.data;

import android.util.Log;

import com.hafsalrahman.ssstest.data.local.AppLocalDataStore;
import com.hafsalrahman.ssstest.data.local.models.User;
import com.hafsalrahman.ssstest.data.remote.AppRemoteDataStore;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;
import com.hafsalrahman.ssstest.utils.NetUtils;
import com.hafsalrahman.ssstest.utils.UserUtil;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by hafsal on 10/24/17.
 */

public class AppRepository implements AppDataStore {


    private AppRemoteDataStore mAppRemoteDataStore;

    private AppLocalDataStore mAppLocalDataStore;

    private NetUtils mNetUtil;


    public AppRepository(AppRemoteDataStore pAppRemoteDataStore, AppLocalDataStore pAppLocalDataStore, NetUtils pNetUtil) {
        this.mAppRemoteDataStore = pAppRemoteDataStore;
        this.mAppLocalDataStore = pAppLocalDataStore;
        this.mNetUtil = pNetUtil;
    }

    @Override
    public Single<List<User>> getUsers() {
        Single<List<User>> response = null;

        if (mNetUtil.isNetworkAvailable()) {
            response = mAppRemoteDataStore.getUsers()
                    .map(new Function<UsersResponse, List<com.hafsalrahman.ssstest.data.local.models.User>>() {
                        @Override
                        public List<com.hafsalrahman.ssstest.data.local.models.User> apply(UsersResponse apiUsers) throws Exception {
                            return UserUtil.convertApiUserListToUserList(apiUsers);
                        };
                    }).doOnSuccess(new Consumer<List<User>>() {
                        @Override
                        public void accept(@NonNull List<User> users)  {
                            try {
                                mAppLocalDataStore.insertUsers(users);
                            }catch (Exception e)
                            {
                                Log.e(e.getMessage(),"");
                            }
                        }
                    });

        } else {
            response = mAppLocalDataStore.getUsers();
        }


        return response;

    }
}

