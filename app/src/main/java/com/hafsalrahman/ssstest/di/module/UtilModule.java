package com.hafsalrahman.ssstest.di.module;
import android.app.Application;
import com.hafsalrahman.ssstest.utils.NetUtils;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by hafsal on 10/25/17.
 */

@Module
public class UtilModule {

    @Provides
    @Singleton
    NetUtils proviveInternetUtil(Application application) {
        return new NetUtils(application);
    }

}
