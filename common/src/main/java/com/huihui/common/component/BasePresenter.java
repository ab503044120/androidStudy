package com.huihui.common.component;

public abstract class BasePresenter<T> {
    protected T view;

    public BasePresenter(T view) {
        this.view = view;
    }
    public abstract void start();


}