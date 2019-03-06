package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
/**
 * @author wuyzh
 * */
public class RxJavaFilterTest {
    public static void useFilter(){
        Observable observable = Observable.just(1,2,3,4);
        observable = observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 2;
            }
        });
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useElementAt(){
        Observable observable = Observable.just(1,2,3,4);
        observable = observable.elementAt(2);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useDistinct(){
        Observable observable = Observable.just(1,2,2,3,3,4);
        observable = observable.distinct();
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useSkip(){
        Observable observable = Observable.just(1,2,2,3,3,4);
        observable = observable.skip(3);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useTake(){
        Observable observable = Observable.just(1,2,2,3,3,4);
        observable = observable.take(3);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useIgnoreElements(){
        Observable observable = Observable.just(1,2,2,3,3,4);
        observable = observable.ignoreElements();
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useThrottleFirst(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++){
                    subscriber.onNext(i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        });

        Observer observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束",true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };

        observable = observable.throttleFirst(200, TimeUnit.MILLISECONDS);
        observable.subscribe(observer);
    }

    public static void useThrottleTimeOut(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; i++){
                    subscriber.onNext(i);
                    int sleep = 100;
                    if (i%3 == 0){
                        sleep = 300;
                    }
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        });

        Observer observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束",true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        };

        observable = observable.throttleWithTimeout(250, TimeUnit.MILLISECONDS);
        observable.subscribe(observer);
    }
}
