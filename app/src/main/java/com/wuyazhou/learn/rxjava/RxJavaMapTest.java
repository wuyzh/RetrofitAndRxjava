package com.wuyazhou.learn.rxjava;

import com.wuyazhou.learn.logview.LogShowUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * @author wuyazhou
 * */
public class RxJavaMapTest {
    private  static Subscription subscription = null;
    public static void useMap(){
        Observable observable = Observable.just("吴","zhou");
        observable = observable.map(new Func1<String,String>() {
            @Override
            public String call(String string) {
                return string+"YaZhou";
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useFlatMap(){
        Observable observable = Observable.just("亚洲","康","洪楠");
        observable = observable.flatMap(new Func1<String,Observable>() {
            @Override
            public Observable call(String string) {
                return Observable.just("吴"+string);
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useConcatMap(){
        Observable observable = Observable.just("亚洲","康","洪楠");
        observable = observable.concatMap(new Func1<String,Observable>() {
            @Override
            public Observable call(String string) {
                return Observable.just("吴"+string);
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useFlatMapIterable(){
        Observable observable = Observable.just("亚洲","康","洪楠");
        observable = observable.flatMapIterable(new Func1<String,Iterable<String>>() {
            @Override
            public Iterable<String> call(String string) {
                List<String> list = new ArrayList<String>();
                list.add("吴"+string);
                return list;
            }
        });
        Action1 action1 = new Action1<String>() {
            @Override
            public void call(String string) {
                LogShowUtil.addLog("RxJava","结果: "+string,true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useBuffer(){
        Observable observable = Observable.just("赵","钱","孙","李","周","吴","郑","王");
        observable = observable.buffer(3);
        Action1 action1 = new Action1<List<String>>() {
            @Override
            public void call(List<String> list) {
                for (String string:list){
                    LogShowUtil.addLog("RxJava","结果: "+string,true);
                }
                LogShowUtil.addLog("RxJava","----------------",true);
            }
        };
        observable.subscribe(action1);
    }

    public static void useGroupBy(){
        SwordMan s1 = new SwordMan("韦一笑","A");
        SwordMan s2 = new SwordMan("张三丰","SS");
        SwordMan s3 = new SwordMan("周芷若","S");
        SwordMan s4 = new SwordMan("宋远桥","S");
        SwordMan s5 = new SwordMan("殷梨亭","A");
        SwordMan s6 = new SwordMan("张无忌","SS");
        SwordMan s7 = new SwordMan("宋青书","A");
        SwordMan s8 = new SwordMan("灭绝师太","S");
        Observable<GroupedObservable<String,SwordMan>> groupObservable = Observable.just(s1,s2,s3,s4,s5,s6,s7,s8).
                groupBy(new Func1<SwordMan,String>() {
                    @Override
                    public String call(SwordMan swordMan) {
                        return swordMan.mLevel;
                    }
                });

        Action1 action1 = new Action1<SwordMan>() {
            @Override
            public void call(SwordMan swordMan) {
                LogShowUtil.addLog("RxJava",swordMan.mName+"--"+swordMan.mLevel,true);
            }
        };
        Observable.concat(groupObservable).subscribe(action1);
    }

    static class SwordMan{
        public String mName;
        public String mLevel;
        public SwordMan(String name, String level){
            mName = name;
            mLevel = level;
        }
    }

}
