package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @author wuyzh
 * */
public class RxJavaAssistTest {
    public static void useDelay(){
        Observable observable = Observable.just(1, 2, 3);
        observable = observable.delay(5, TimeUnit.SECONDS);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useDo(){
        Observable observable = Observable.just(1, 2, 3);
        observable = observable.doOnNext(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","开始执行: "+integer.intValue(),true);
            }
        });

        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    /**
     * 运行在哪个线程上
     * */
    public static void useSubscribeOn(){
        LogShowUtil.addLog("RxJava","当前线程: "+Thread.currentThread().getName(),true);
        Observable observable = Observable.just(1, 2, 3);
        observable = observable.subscribeOn(Schedulers.newThread());

        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","接受线程: "+Thread.currentThread().getName(),true);
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useObserveOn(){
        LogShowUtil.addLog("RxJava","当前线程: "+Thread.currentThread().getName(),true);
        Observable Aobservable = Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                LogShowUtil.addLog("RxJava","发送线程: "+Thread.currentThread().getName(),true);
                subscriber.onNext("杨");
                subscriber.onCompleted();
            }
        });
        Observable Bobservable = Aobservable.subscribeOn(Schedulers.newThread());
        Observable Cobservable = Bobservable.observeOn(AndroidSchedulers.mainThread());

        Observer observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogShowUtil.addLog("RxJava","结束",true);
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(String string) {
                LogShowUtil.addLog("RxJava","接受线程: "+Thread.currentThread().getName(),true);
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
        Cobservable.subscribe(observer);
    }

    public static void useTimeOut(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0; i<10;i++){
                    try {
                        Thread.sleep(i*100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread());

        observable = observable.timeout(200,TimeUnit.MILLISECONDS);

        /*Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }

        };*/
        Observer observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogShowUtil.addLog("RxJava","异常: "+e.toString(),true);
            }

            @Override
            public void onNext(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }
        };
        observable.subscribe(observer);
    }
    public static void useTimeOut2(){
        Observable observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i=0; i<10;i++){
                    try {
                        Thread.sleep(i*100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread());

        observable = observable.timeout(200,TimeUnit.MILLISECONDS,Observable.just(10,11));

        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer num) {
                LogShowUtil.addLog("RxJava","结果: "+num.intValue(),true);
            }

        };

        observable.subscribe(action1);
    }
}
