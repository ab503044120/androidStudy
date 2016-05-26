package com.huihui.common.component;

import android.support.annotation.LayoutRes;

/**
 * 界面处理流程的约定接口
 * 
 * @author YangZhenshan
 *
 */
public interface UIConvention {
	/**
	 * 获取父布局layout
	 * 
	 * @return layoutResId
	 */
	@LayoutRes
	int getLayoutResId();

	/**
	 * 初始化变量
	 */
	void initVariable();

	/**
	 * 初始化UI界面
	 */
	void initView();

	/**
	 * 初始化数据
	 */
	void initData();

}
