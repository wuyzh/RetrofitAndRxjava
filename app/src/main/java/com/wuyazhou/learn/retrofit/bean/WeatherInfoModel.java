package com.wuyazhou.learn.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author wuyazhou
 * @function 解析网络请求数据
 * */
public class WeatherInfoModel {
    public String code;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public WeatherInfo weatherInfo;

    public class WeatherInfo{
        @SerializedName("yesterday")
        public DayWeatherInfo yesterdayWeatherInfo;
        public String city;
        public String aqi;
        @SerializedName("forecast")
        public List<DayWeatherInfo> forecastWeatherInfo;
        @SerializedName("ganmao")
        public String hint;
        public String wendu;
    }

    public class DayWeatherInfo{
        public String date;
        public String high;
        public String fx;
        public String low;
        public String fl;
        public String type;
    }

    @Override
    public String toString(){
        return "城市: " + weatherInfo.city+", 天气:"+weatherInfo.forecastWeatherInfo.get(0).type+", "+ weatherInfo.forecastWeatherInfo.get(0).high+", "
                + weatherInfo.forecastWeatherInfo.get(0).low+", 提醒:"+weatherInfo.hint;
    }
}
