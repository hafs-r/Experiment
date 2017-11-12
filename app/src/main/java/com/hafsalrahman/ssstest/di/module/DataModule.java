package com.hafsalrahman.ssstest.di.module;

/**
 * Created by hafsal on 10/24/17.
 */

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hafsalrahman.ssstest.BuildConfig;
import com.hafsalrahman.ssstest.data.AppRepository;
import com.hafsalrahman.ssstest.data.local.AppLocalDataStore;
import com.hafsalrahman.ssstest.data.local.DataBaseSource;
import com.hafsalrahman.ssstest.data.remote.AppRemoteDataStore;
import com.hafsalrahman.ssstest.data.remote.ErrorManager;
import com.hafsalrahman.ssstest.utils.NetUtils;

import java.security.cert.CertificateException;

import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;


@Module
public class DataModule {


    public DataModule() {
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    ErrorManager provideErrorManager(Application application) {
        return new ErrorManager(application);
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    NetUtils proviveInternetUtil(Application application) {
        return new NetUtils(application);
    }


    @Provides
    @Singleton
    DataBaseSource providesDataSource(Application application) {
        return Room.databaseBuilder(application.getApplicationContext(), DataBaseSource.class, BuildConfig.DB_NAME).build();
    }

    //local db wrapper
    @Provides
    @Singleton
    AppLocalDataStore provideLocalDataStore(DataBaseSource dbSource) {
        return new AppLocalDataStore(dbSource);
    }

    //remote api wrapper
    @Provides
    @Singleton
    AppRemoteDataStore provideRemoteDataStore(Retrofit retrofit) {
        return new AppRemoteDataStore(retrofit);
    }

    //data api wrapper
    @Provides
    @Singleton
    AppRepository provideDataStore(AppRemoteDataStore appRemoteDataStore, AppLocalDataStore appLocalDataStore, NetUtils pNetUtil) {

        return new AppRepository(appRemoteDataStore, appLocalDataStore, pNetUtil);
    }

}