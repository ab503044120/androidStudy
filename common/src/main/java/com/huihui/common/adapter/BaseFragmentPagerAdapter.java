package com.huihui.common.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mDatas;
    private Context mcContext;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> mDatas, Context mcContext) {
        super(fm);
        this.mDatas = mDatas;
        this.mcContext = mcContext;
    }
    @Override
    public Fragment getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mDatas.size();
    }
}
