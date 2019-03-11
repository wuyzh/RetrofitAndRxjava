package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * @author wuyzh
 * */
public class RxJavaBooleanTest {
    public static void useAll(){
        Observable observable = Observable.just(1,2,3,4);
        observable = observable.all(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer num) {
                LogShowUtil.addLog("RxJava","Call: "+num.intValue(),true);
                return num<3;
            }
        });
        Observer observer= new Observer<Boolean>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束 ",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常",true);
            }

            @Override
            public void onNext(Boolean num) {
                LogShowUtil.addLog("RxJava","结果: "+num,true);
            }
        };
        observable.subscribe(observer);
    }

    public static void useContains(){
        Observable observable = Observable.just(1,2,3,4);
        observable = observable.contains(2);
        Observer observer= new Observer<Boolean>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束 ",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常",true);
            }

            @Override
            public void onNext(Boolean num) {
                LogShowUtil.addLog("RxJava","结果: "+num,true);
            }
        };
        observable.subscribe(observer);
    }

    public static void useIsEmpty(){
        Observable observable = Observable.just(1,2,3,4);
        observable = observable.isEmpty();
        Observer observer= new Observer<Boolean>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束 ",true);
            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常",true);
            }

            @Override
            public void onNext(Boolean num) {
                LogShowUtil.addLog("RxJava","结果: "+num,true);
            }
        };
        observable.subscribe(observer);
    }
}
