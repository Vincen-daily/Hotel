package com.example.hotelapp.network;

import com.example.hotelapp.model.CityData;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by xiecy on 2018/01/17.
 */

public interface NetworkService {

    @GET("v1/city")
    Observable<CityData> getCity();
}
