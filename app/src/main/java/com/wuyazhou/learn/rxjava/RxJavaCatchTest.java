package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author wuyzh
 * */
public class RxJavaCatchTest {
    public static void useCatch(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0;i<10;i++){
                    if (i>2){
                        subscriber.onError(new Throwable("test"));
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });

        observable = observable.onErrorReturn(new Func1<Throwable,Integer>() {
            @Override
            public Integer call(Throwable o) {
                return 13;
            }
        });

        Observer observer= new Observer<Integer>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束 ",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常",true);
            }

            @Override
            public void onNext(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };

        observable.subscribe(observer);
    }

    public static void useRetry(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0;i<10;i++){
                    if (i>2){
                        subscriber.onError(new Throwable("test"));
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });

        observable = observable.retry(2);

        Observer observer= new Observer<Integer>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束 ",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常",true);
            }

            @Override
            public void onNext(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };

        observable.subscribe(observer);
    }
}
