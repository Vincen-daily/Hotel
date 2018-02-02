package com.example.hotelapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.hotelapp.di.AppComponent;
import com.example.hotelapp.di.AppModule;
import com.example.hotelapp.di.DaggerAppComponent;

import java.io.File;

/**
 * Created by xiecy on 2018/01/17.
 */

public class BaseApp extends AppCompatActivity{

    AppComponent appComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile=new File(getCacheDir(),"responses");
       appComponent=DaggerAppComponent.builder().appModule(new AppModule(cacheFile)).build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
