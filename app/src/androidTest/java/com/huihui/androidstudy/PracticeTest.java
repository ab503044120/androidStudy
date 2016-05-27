package com.huihui.androidstudy;

import android.app.Application;
import android.test.ApplicationTestCase;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by 陈松辉
 * <p/>
 * Date : 2016/5/27
 * Time : 11:12
 */
public class PracticeTest extends ApplicationTestCase<Application> {
    public PracticeTest(Class<Application> applicationClass) {
        super(applicationClass);
    }
    public void testBase(){
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });
        observable.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

            }
        });
    }
}
