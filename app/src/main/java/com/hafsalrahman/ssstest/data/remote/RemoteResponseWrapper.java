package com.hafsalrahman.ssstest.data.remote;


import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by hafsal on 11/12/17.
 */
public abstract class RemoteResponseWrapper<T extends BaseResponse> extends DisposableSingleObserver<T> {


    public RemoteResponseWrapper() {
    }

    public abstract ErrorManager getErrorManager();

    public abstract void onDataSuccess(T t);

    public abstract void onDataError(String message);

    @Override
    public void onSuccess(T t) {
        // TODO: 11/12/17 implement handling server errors here
        t.getInfo();//get server response status and messages
        /*if error exists call onDataError and pass error string from server
        * */
        onDataSuccess(t);

    }

    @Override
    public void onError(Throwable e) {
        onDataError(getErrorManager().parseError(e));
    }


}