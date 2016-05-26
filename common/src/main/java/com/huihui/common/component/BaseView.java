package com.huihui.common.component;

/**
 * Created by YangZhenshan on 2016/5/5.
 */
public interface BaseView {
    /**
     * 显示进度弹窗
     */
    void showLoadingDialog();
    /**
     * 隐藏进度弹窗
     */
    void hindLoadingDialog();

    /**
     * 关闭页面
     */
    void finish();
}
