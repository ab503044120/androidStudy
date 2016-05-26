package com.huihui.common.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Fragment基类
 *
 * @author YangZhenshan
 * @date 2016-5-7 17:53:12
 */
public abstract class BaseFragment extends Fragment implements UIConvention {
    public final String TAG = this.getClass().getSimpleName();
    /**
     * 公共进度加载条
     */
//    protected LoadingDialog mLoadingDialog;

    /**
     * 是否已经加载视图
     */
    protected boolean isViewPrepared;
    /**
     * 是否已经加载数据
     */
    protected boolean isDataLoaded;
    /**
     * hanlder
     */
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    /**
     * 主线程id
     */
    public long UiThreadId = Thread.currentThread().getId();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        mLoadingDialog = new LoadingDialog(getActivity());
        return View.inflate(getActivity(), getLayoutResId(), null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        isViewPrepared = true;
        initVariable();
        initView();
        initData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isViewPrepared) {
            return;
        }
        if (isVisibleToUser) {
            if (!isDataLoaded) {
                onLazyLoad();
                isDataLoaded = true;
                return;
            }
            onFragmentResume();
        }
    }

    /**
     * fargment resume方法
     */
    protected void onFragmentResume() {

    }

    @CallSuper
    @Override
    public void onDestroy() {
//        ButterKnife.unbind(this);
        super.onDestroy();
    }

    /**
     * 显示加载dialog
     */
    public void showLoadingDialog() {
        if (Thread.currentThread().getId() != UiThreadId) {
//            mLoadingDialog.show();
            return;
        }
        mHandler.post(new Runnable() {

            @Override
            public void run() {
//                mLoadingDialog.show();
            }
        });
    }

    /**
     * 隐藏加载dialog
     */
    public void hindLoadingDialog() {
        if (Thread.currentThread().getId() != UiThreadId) {
//            mLoadingDialog.dismiss();
            return;
        }
        mHandler.post(new Runnable() {

            @Override
            public void run() {
//                mLoadingDialog.dismiss();
            }
        });
    }

    protected abstract void onLazyLoad();

    @Override
    public void initData() {

    }

    public void finish() {

    }
}
