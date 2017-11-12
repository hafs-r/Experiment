package com.hafsalrahman.ssstest.data.remote;

import android.accounts.NetworkErrorException;
import android.app.Application;

import com.hafsalrahman.ssstest.R;

/**
 * Created by hafsal on 11/12/17.
 */

public class ErrorManager {

    private Application mApplication;

    public ErrorManager(Application mApplication) {
        this.mApplication=mApplication;
    }

    public String parseError(Throwable throwable)
    {
        //all errors can be handled here
        String message=mApplication.getString(R.string.network_error);
        if(throwable instanceof NetworkErrorException)
        {

        }
        return message;
    }

}

