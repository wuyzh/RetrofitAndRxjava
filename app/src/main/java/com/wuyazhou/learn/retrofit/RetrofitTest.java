package com.wuyazhou.learn.retrofit;

import com.google.gson.JsonObject;
import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.retrofit.api.HttpService;
import com.wuyazhou.learn.retrofit.bean.WeatherInfoModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author wuyzh
 * */
public class RetrofitTest {
    /**
     * 获取原始的JsonObject数据结构
     * */
    public static void getJsonObject(HttpService httpService){
        Call<JsonObject> call = httpService.getWeatherInfo();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                LogShowUtil.addLog("Retrofit", response.body().toString(),true);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    /**
     * 通过条件查询
     * */
    public static void getWeatherInfoModelByParam(HttpService httpService,String city){
        Call<WeatherInfoModel> call = httpService.getWeatherInfo(city);
        call.enqueue(new Callback<WeatherInfoModel>() {
            @Override
            public void onResponse(Call<WeatherInfoModel> call, Response<WeatherInfoModel> response) {
                if (response.body().code.equals("200")){
                    LogShowUtil.addLog("Retrofit",response.body().toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + response.body().message,true);
                }
            }
            @Override
            public void onFailure(Call<WeatherInfoModel> call, Throwable t) {

            }
        });
    }
    /**
     * 通过条件组查询
     * */
    public static void getWeatherInfoModelByParams(HttpService httpService, Map<String,String> params){
        Call<WeatherInfoModel> call = httpService.getWeatherInfo(params);
        call.enqueue(new Callback<WeatherInfoModel>() {
            @Override
            public void onResponse(Call<WeatherInfoModel> call, Response<WeatherInfoModel> response) {
                if (response.body().code.equals("200")){
                    LogShowUtil.addLog("Retrofit",response.body().toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + response.body().message,true);
                }
            }
            @Override
            public void onFailure(Call<WeatherInfoModel> call, Throwable t) {

            }
        });
    }

    /**
     * 通过Path和Query查询
     * */
    public static void getWeatherInfoModelByPathAndParam(HttpService httpService, String path, String city){
        Call<WeatherInfoModel> call = httpService.getWeatherInfo(path,city);
        call.enqueue(new Callback<WeatherInfoModel>() {
            @Override
            public void onResponse(Call<WeatherInfoModel> call, Response<WeatherInfoModel> response) {
                if (response.body().code.equals("200")){
                    LogShowUtil.addLog("Retrofit",response.body().toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + response.body().message,true);
                }
            }
            @Override
            public void onFailure(Call<WeatherInfoModel> call, Throwable t) {

            }
        });
    }

    /**
     * 通过post查询
     * */
    public static void getWeatherInfoModelByPostField(HttpService httpService,String city){
        Call<WeatherInfoModel> call = httpService.postWeatherInfo(city);
        call.enqueue(new Callback<WeatherInfoModel>() {
            @Override
            public void onResponse(Call<WeatherInfoModel> call, Response<WeatherInfoModel> response) {
                if (response.body().code.equals("200")){
                    LogShowUtil.addLog("Retrofit",response.body().toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + response.body().message,true);
                }
            }
            @Override
            public void onFailure(Call<WeatherInfoModel> call, Throwable t) {

            }
        });
    }

    /**
     * 通过post查询
     * */
    public static void getWeatherInfoModelByPostBody(HttpService httpService, HttpService.CityBody city){
        Call<WeatherInfoModel> call = httpService.postWeatherInfo(city);
        call.enqueue(new Callback<WeatherInfoModel>() {
            @Override
            public void onResponse(Call<WeatherInfoModel> call, Response<WeatherInfoModel> response) {
                if (response.body().code.equals("200")){
                    LogShowUtil.addLog("Retrofit",response.body().toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + response.body().message,true);
                }
            }
            @Override
            public void onFailure(Call<WeatherInfoModel> call, Throwable t) {

            }
        });
    }
}
