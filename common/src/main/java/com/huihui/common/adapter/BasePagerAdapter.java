package com.huihui.common.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by leiquan on 2016/3/21.
 */
public class BasePagerAdapter<T> extends PagerAdapter {

    protected List<T> mDatas;

    protected Context mContext;

    public BasePagerAdapter(List<T> mDatas) {
        this.mDatas = mDatas;
    }
    public BasePagerAdapter(Context mContext, List<T> mDatas) {
        this.mDatas = mDatas;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }
}
