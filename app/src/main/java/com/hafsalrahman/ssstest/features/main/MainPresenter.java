package com.hafsalrahman.ssstest.features.main;


import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.data.AppRepository;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hafsal on 10/25/17.
 */

public class MainPresenter implements MainContract.Presenter {

    AppRepository mAppRepository;

    MainContract.View mView;

    public MainPresenter(MainContract.View mView, AppRepository mAppRepository) {
        this.mView = mView;
        this.mAppRepository = mAppRepository;
    }

    @Override
    public void loadUsers() {
        mAppRepository.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<LocalUser>>() {
                    @Override
                    public void onSuccess(List<LocalUser> localUsers) {
                        if (localUsers.size() > 0)
                            mView.showUsers(localUsers);
                        else
                            mView.showInfo(R.string.no_users_available);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                });
    }

    @Override
    public void unsubscribe() {
    }
}
