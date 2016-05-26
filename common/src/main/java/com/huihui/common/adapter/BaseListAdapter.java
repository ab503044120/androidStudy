package com.huihui.common.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ListViewAdapter的基类
 * 
 * @author 陈松辉
 *
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

	public Context mContext;
	public List<T> mDatas;
	/**
	 * mainlooper handler
	 */
	private Handler handler = new Handler(Looper.getMainLooper());
	/**
	 * 主线程id
	 */
	private long uiThreadId = Thread.currentThread().getId();

	public BaseListAdapter(Context mContext, List<T> mDatas) {
		super();
		this.mContext = mContext;
		this.mDatas = mDatas;
	}

	public void ReplaceData(List<T> datas) {
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
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
}
