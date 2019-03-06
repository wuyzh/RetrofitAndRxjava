package com.wuyazhou.learn.retrofitAndRxjava;

import com.wuyazhou.learn.logview.LogShowUtil;
import com.wuyazhou.learn.retrofit.bean.WeatherInfoModel;
import com.wuyazhou.learn.retrofitAndRxjava.api.WeatherService;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author wuyzh
 * */
public class RetrofitAndRxJavaTest {
    /**
     * 通过条件查询
     * */
    public static void getWeatherInfoModelByParam(WeatherService weatherService, String city){
        Observable observable = weatherService.getWeatherInfo(city).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observer observer = new Observer<WeatherInfoModel>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("Retrofit","结束",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("Retrofit","异常",true);
            }

            @Override
            public void onNext(WeatherInfoModel weatherInfoModel) {
                LogShowUtil.addLog("Retrofit","当前线程: "+Thread.currentThread().getName(),true);
                if (weatherInfoModel.code.equals("200")){
                    LogShowUtil.addLog("Retrofit",weatherInfoModel.toString(),true);
                }else {
                    LogShowUtil.addLog("Retrofit", "请求失败: " + weatherInfoModel.message,true);
                }
            }
        };
        observable.subscribe(observer);
    }
}
