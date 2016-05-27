package com.huihui.androidstudy;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.huihui.common.utils.ALog;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testbase(){
        Observable.OnSubscribe<String> onSubscriber1 = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onCompleted();
            }
        };
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                ALog.e("completed");
            }

            @Override
            public void onError(Throwable e) {
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    ALog.e(stackTraceElement.toString());
                }
          }

            @Override
            public void onNext(String s) {
                ALog.e("next->"+s);
            }
        };

        Observable.create(onSubscriber1)
                .subscribe(subscriber1);
    }

    Integer i=10;
    public void testDefer(){
        Observable<Integer> justObservable = Observable.just(i);
        i=12;
        Observable<Integer> deferObservable = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(i);
            }
        });
        i=15;

        justObservable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                ALog.e("just result:" + o.toString());
            }
        });

        deferObservable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                ALog.e("defer result:" + o.toString());
            }
        });
    }
}