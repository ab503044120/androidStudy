package com.huihui.common.adapter;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 陈松辉
 * <p/>
 * Date : 2016/4/28
 * Time : 18:04
 */
public abstract class BaseFragmentList<T> extends BaseAdapter {
    public Fragment mFragment;
    public List<T> mDatas;
    /**
     * mainlooper handler
     */
    private Handler handler = new Handler(Looper.getMainLooper());
    /**
     * 主线程id
     */
    private long uiThreadId = Thread.currentThread().getId();

    public BaseFragmentList(Fragment fragment, List<T> mDatas) {
        super();
        this.mFragment = fragment;
        this.mDatas = mDatas;
    }

    public void replaceData(List<T> datas) {
        mDatas = datas;
        refresh();
    }

    /**
     * 保证在主线程刷新数据
     */
    public void refresh() {
        if (Thread.currentThread().getId() == uiThreadId) {
            notifyDataSetChanged();
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

