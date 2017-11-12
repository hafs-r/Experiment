package com.hafsalrahman.ssstest.features.main;


import com.hafsalrahman.ssstest.R;
import com.hafsalrahman.ssstest.data.AppRepository;
import com.hafsalrahman.ssstest.data.local.LocalResponseWrapper;
import com.hafsalrahman.ssstest.data.local.models.LocalUser;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hafsal on 10/25/17.
 */

public class MainPresenter implements MainContract.Presenter {

    AppRepository mAppRepository;

    MainContract.View mView;

    CompositeDisposable mCompositeDisposible;

    public MainPresenter(MainContract.View mView, AppRepository mAppRepository) {
        this.mView = mView;
        this.mAppRepository = mAppRepository;
        mCompositeDisposible=new CompositeDisposable();
    }

    @Override
    public void loadUsers() {
        mAppRepository.getUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                       mCompositeDisposible.add(disposable);
                    }
                })
                .subscribeWith(new LocalResponseWrapper<List<LocalUser>>() {

                    @Override
                    public void onDataSuccess(List t) {
                        if (t.size() > 0)
                            mView.showUsers(t);
                        else
                            mView.showInfo(R.string.no_users_available);
                    }

                    @Override
                    public void onDataError(String message) {
                        mView.showError(message);
                    }


                });
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposible.dispose();
    }
}
