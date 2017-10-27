package com.hafsalrahman.ssstest;

import android.app.Application;

import com.hafsalrahman.ssstest.di.component.AppComponent;
import com.hafsalrahman.ssstest.di.component.DaggerAppComponent;
import com.hafsalrahman.ssstest.di.module.AppModule;
import com.hafsalrahman.ssstest.di.module.DataModule;

/**
 * Created by hafsal on 10/24/17.
 */

public class App extends Application {

    private static AppComponent mAppComponent;

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }

}
