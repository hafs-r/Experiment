package com.hafsalrahman.ssstest.data.local;


import com.hafsalrahman.ssstest.data.remote.BaseResponse;
import com.hafsalrahman.ssstest.data.remote.ErrorManager;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by hafsal on 11/12/17.
 */
public abstract class LocalResponseWrapper<T extends List> extends DisposableSingleObserver<T> {


    public LocalResponseWrapper() {
    }

    public abstract void onDataSuccess(List t);

    public abstract void onDataError(String message);

    @Override
    public void onSuccess(T t) {

        onDataSuccess(t);

    }

    @Override
    public void onError(Throwable e) {
        onDataError(e.getMessage());
    }


}