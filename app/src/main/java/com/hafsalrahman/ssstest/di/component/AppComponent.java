package com.hafsalrahman.ssstest.di.component;


import com.hafsalrahman.ssstest.data.AppRepository;
import com.hafsalrahman.ssstest.di.module.AppModule;
import com.hafsalrahman.ssstest.di.module.DataModule;
import com.hafsalrahman.ssstest.features.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hafsal on 10/24/17.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    void inject(AppRepository appRepository);

    void inject(MainActivity mainActivity);

}