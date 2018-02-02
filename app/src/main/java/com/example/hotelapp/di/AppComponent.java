package com.example.hotelapp.di;

import com.example.hotelapp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by xiecy on 2018/01/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
