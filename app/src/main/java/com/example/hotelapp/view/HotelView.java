package com.example.hotelapp.view;

import com.example.hotelapp.model.CityData;

/**
 * Created by xiecy on 2018/01/17.
 */

public interface HotelView {

    void showProgress();

    void removeProgress();

    void showgetDataSuccess(CityData cityData);
}
