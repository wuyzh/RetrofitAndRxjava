package com.wuyazhou.learn.retrofitAndRxjava.api;

import com.wuyazhou.learn.retrofit.bean.WeatherInfoModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface WeatherService {
    /**
     * 动态指定查询条件
     * @Query("字段")
     * */
    @GET("weatherApi")
    Observable<WeatherInfoModel> getWeatherInfo(@Query("city") String city);
}
