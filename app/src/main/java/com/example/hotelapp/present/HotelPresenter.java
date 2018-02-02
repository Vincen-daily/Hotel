package com.example.hotelapp.present;

import com.example.hotelapp.model.CityData;
import com.example.hotelapp.network.Service;
import com.example.hotelapp.view.HotelView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by xiecy on 2018/01/17.
 */

public class HotelPresenter {

    private Service service;
    private HotelView hotelView;
    private CompositeSubscription compositeSubscription;

    public HotelPresenter(Service service, HotelView hotelView) {
        this.service = service;
        this.hotelView = hotelView;
        compositeSubscription=new CompositeSubscription();
    }

    public void getCity(){
        hotelView.showProgress();
        Subscription subscription=service.getCity(new Service.GetCityCallback() {
            @Override
            public void onSuccess(CityData cityData) {
                hotelView.removeProgress();
                hotelView.showgetDataSuccess(cityData);
            }

            @Override
            public void onFailure() {
                hotelView.removeProgress();


            }
        });
        compositeSubscription.add(subscription);
    }
}
