package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * @author wuyazhou
 * */
public class RxJavaCreateTest {
    private  static Subscription subscription = null;
    public static void useCreate(Observer observer){
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("杨");
                subscriber.onNext("月");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
    }
    public static void useJust(Observer observer){
        Observable observable = Observable.just("影","眉");
        observable.subscribe(observer);
    }
    public static void useFrom(Observer observer){
        String[] words = {"枫","儿"};
        Observable observable = Observable.from(words);
        observable.subscribe(observer);
    }

    public static void useInterval(){
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);
        Action1 action1 = new Action1<Long>() {
            @Override
            public void call(Long num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
                if (num.intValue() == 5){
                    subscription.unsubscribe();
                }
            }
        };
        subscription = observable.subscribe(action1);
    }

    public static void useRange(){
        Observable observable = Observable.range(0, 5);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useRepeat(){
        Observable observable = Observable.range(0, 4).repeat(2);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }
}
