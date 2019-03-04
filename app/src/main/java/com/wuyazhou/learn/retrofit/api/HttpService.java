package com.wuyazhou.learn.retrofit.api;

import com.google.gson.JsonObject;
import com.wuyazhou.learn.retrofit.bean.WeatherInfoModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface HttpService {
    /**
     * 获取数据结构
     * @return Result<JsonObject>
     */
    @GET("weatherApi?city=临沂")
    Call<JsonObject> getWeatherInfo();

    /**
     * 动态指定查询条件
     * @Query("字段")
     * */
    @GET("weatherApi")
    Call<WeatherInfoModel> getWeatherInfo(@Query("city") String city);

    /**
     * 动态指定查询条件
     * @Query("字段")
     * */
    @GET("weatherApi")
    Call<WeatherInfoModel> getWeatherInfo(@QueryMap Map<String,String> params);

    /**
     * 动态指定查询条件和请求path
     * {path}
     * @Query("字段")
     * */
    @GET("{path}")
    Call<WeatherInfoModel> getWeatherInfo(@Path ("path") String path, @Query("city") String city);

    /**
     * 获取数据结构
     * @return Result<WeatherInfoModel>
     */
    @FormUrlEncoded
    @POST("weatherApi")
    Call<WeatherInfoModel> postWeatherInfo(@Field("city") String city);

    /**
     * 获取数据结构
     * @return Result<WeatherInfoModel>
     */
    @POST("weatherApi")
    Call<WeatherInfoModel> postWeatherInfo(@Body CityBody body);

    public class CityBody{
        public String city;
        public CityBody(String city){
            this.city = city;
        }
    }
}
