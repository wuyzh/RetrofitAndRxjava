package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author wuyzh
 * */
public class RxJavaConvertTest {
    public static void useToList(){
        Observable observable = Observable.just(3,1,2);
        observable = observable.toList();
        Action1 action1 = new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> list) {
                for (Integer num:list){
                    LogShowUtil.addLog("RxJava","结果: "+num,true);
                }
            }
        };
        observable.subscribe(action1);
    }

    public static void useToSortList(){
        Observable observable = Observable.just(3,1,2);
        observable = observable.toSortedList();
        Action1 action1 = new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> list) {
                for (Integer num:list){
                    LogShowUtil.addLog("RxJava","结果: "+num,true);
                }
            }
        };
        observable.subscribe(action1);
    }

    public static void useToMap(){
        RxJavaMapTest.SwordMan s1 = new RxJavaMapTest.SwordMan("韦一笑","A");
        RxJavaMapTest.SwordMan s2 = new RxJavaMapTest.SwordMan("张三丰","SS");
        RxJavaMapTest.SwordMan s3 = new RxJavaMapTest.SwordMan("周芷若","S");
        Observable observable = Observable.just(s1,s2,s3);
        observable = observable.toMap(new Func1<RxJavaMapTest.SwordMan,String>() {
            @Override
            public String call(RxJavaMapTest.SwordMan swordMan) {
                return swordMan.mLevel;
            }
        });
        Action1 action1 = new Action1<Map<String,RxJavaMapTest.SwordMan>>() {
            @Override
            public void call(Map<String,RxJavaMapTest.SwordMan> manMap) {

                LogShowUtil.addLog("RxJava","SS: "+manMap.get("SS").mName,true);
            }
        };
        observable.subscribe(action1);
    }
}
