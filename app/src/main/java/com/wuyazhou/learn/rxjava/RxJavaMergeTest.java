package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * @author wuyzh
 * */
public class RxJavaMergeTest {
    public static void useStartWith(){
        Observable observable = Observable.just(1,2,3);
        observable = observable.startWith(4,5);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        } ;
        observable.subscribe(action1);
    }
    /**
     * 可能会让合并的Observable发射的数据交错
     * */
    public static void useMerge(){
        Observable ob1 = Observable.just(1,2,3).subscribeOn(Schedulers.io());
        Observable ob2 = Observable.just(4,5,6);
        Observable observable = Observable.merge(ob1,ob2);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        } ;
        observable.subscribe(action1);
    }

    public static void useConcat(){
        Observable ob1 = Observable.just(1,2,3).subscribeOn(Schedulers.io());
        Observable ob2 = Observable.just(4,5,6);
        Observable observable = Observable.concat(ob1,ob2);
        Action1 action1 = new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                LogShowUtil.addLog("RxJava","结果: "+integer.intValue(),true);
            }
        } ;
        observable.subscribe(action1);
    }

    public static void useZip(){
        Observable ob1 = Observable.just("x","y","z").subscribeOn(Schedulers.io());
        Observable ob2 = Observable.just(4,5,6);
        Observable observable = Observable.zip(ob1, ob2, new Func2<String,Integer,String>() {
            @Override
            public String call(String string, Integer integer) {
                return string+" "+integer;
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        } ;
        observable.subscribe(action1);
    }

    public static void useCombineLastest(){
        Observable ob1 = Observable.just("x","y","z");
        Observable ob2 = Observable.just(4,5,6);
        Observable observable = Observable.combineLatest(ob1, ob2, new Func2<String,Integer,String>() {
            @Override
            public String call(String string, Integer integer) {
                return string+" "+integer;
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        } ;
        observable.subscribe(action1);
    }
}
