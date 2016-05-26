package com.huihui.common.request;

/**
 * Created by YangZhenshan on 2016/5/5.
 */
public interface RequestCallBack<T> {
    void onSuccess(T result);
    void onError(FailedReason reason, String errorInfo);
    void onFinish();
}
