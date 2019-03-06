package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author wuyzh
 * */
public class RxJavaConditionTest {
    public static void useAmb(){
        Observable observable1 = Observable.just(1,2,3).delay(2, TimeUnit.SECONDS);
        Observable observable2 = Observable.just(4,5,6);
        Observable observable = Observable.amb(observable1,observable2);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num,true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useDefaultIfEmpty(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onCompleted();
            }
        });
        observable = observable.defaultIfEmpty(7);

        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num,true);
            }
        };
        observable.subscribe(action1);
    }
}
