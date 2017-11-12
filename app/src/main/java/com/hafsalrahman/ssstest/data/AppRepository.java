package com.hafsalrahman.ssstest.data;

import com.hafsalrahman.ssstest.data.local.AppLocalDataStore;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;
import com.hafsalrahman.ssstest.data.remote.AppRemoteDataStore;
import com.hafsalrahman.ssstest.data.remote.ErrorManager;
import com.hafsalrahman.ssstest.data.remote.RemoteResponseWrapper;
import com.hafsalrahman.ssstest.data.remote.UsersResponse;
import com.hafsalrahman.ssstest.utils.NetUtils;
import com.hafsalrahman.ssstest.utils.UserUtil;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;

/**
 * Created by hafsal on 10/24/17.
 */

public class AppRepository implements AppDataStore {


    public ErrorManager mErrorManager;
    private AppRemoteDataStore mAppRemoteDataStore;
    private AppLocalDataStore mAppLocalDataStore;
    private NetUtils mNetUtil;


    public AppRepository(AppRemoteDataStore pAppRemoteDataStore, AppLocalDataStore pAppLocalDataStore, NetUtils pNetUtil) {
        this.mAppRemoteDataStore = pAppRemoteDataStore;
        this.mAppLocalDataStore = pAppLocalDataStore;
        this.mNetUtil = pNetUtil;
    }

    @Override
    public Single<List<LocalUser>> getUsers() {
        Single<List<LocalUser>> response = null;

        if (mNetUtil.isNetworkAvailable()) {

            response = new Single<List<LocalUser>>() {
                @Override
                protected void subscribeActual(final SingleObserver<? super List<LocalUser>> observer) {
                    mAppRemoteDataStore.getUsers().subscribe(new RemoteResponseWrapper<UsersResponse>() {
                        @Override
                        public ErrorManager getErrorManager() {
                            return mErrorManager;
                        }

                        @Override
                        public void onDataSuccess(UsersResponse usersResponse) {

                            mAppLocalDataStore.insertUsers(UserUtil.convertApiUserListToUserList(usersResponse));
                            observer.onSuccess(UserUtil.convertApiUserListToUserList(usersResponse));
                        }

                        @Override
                        public void onDataError(String message) {
                            observer.onError(new Throwable(message));
                        }
                    });

                }
            };
        } else {
            response = mAppLocalDataStore.getUsers();
        }


        return response;

    }
}

