package com.example.hotelapp.network;

import com.example.hotelapp.model.CityData;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiecy on 2018/01/17.
 */

public class Service {
    private final NetworkService networkService;


    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCity(final GetCityCallback callback){
        return networkService.getCity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityData>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFailure();
                    }

                    @Override
                    public void onNext(CityData cityData) {
                        callback.onSuccess(cityData);
                    }
                });
    }

    public interface GetCityCallback{
        void onSuccess(CityData cityData);
        void onFailure();
    }
}
