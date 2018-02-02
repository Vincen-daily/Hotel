package com.example.hotelapp.di;

import android.support.v4.widget.CircularProgressDrawable;

import com.example.hotelapp.network.NetworkService;
import com.example.hotelapp.network.Service;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by xiecy on 2018/01/17.
 */
@Module
public class AppModule {

    public static final String BASEURL = "http://private-b8cf44-androidcleancode.apiary-mock.com/";
    public static final int CACHETIME = 432000;

    File cacheFile;

    public AppModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    @Singleton
    @Provides
    public Service providesService(NetworkService networkService){
        return new Service(networkService);
    }

    @Singleton
    @Provides
    public NetworkService providesNetworkService(Retrofit retrofit){
        return  retrofit.create(NetworkService.class);
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(){
        Cache cache=null;
        try {
            cache=new Cache(cacheFile,10*1024*1024);
        }catch (Exception e){
            e.printStackTrace();
        }
        OkHttpClient okHttpClient=new OkHttpClient.Builder().cache(cache).build();
        return new Retrofit.Builder().baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }



}
