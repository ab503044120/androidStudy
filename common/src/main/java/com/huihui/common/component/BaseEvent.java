package com.huihui.common.component;

/**
 * Created by 陈松辉
 * <p>
 * Date : 2016/5/17
 * Time : 19:54
 */
public abstract class BaseEvent<T> {
    private T event;

    public BaseEvent() {
    }

    public BaseEvent(T event) {
        this.event = event;
    }

    public T getEvent() {
        return event;
    }

    public void setEvent(T event) {
        this.event = event;
    }
}