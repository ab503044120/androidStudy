package com.huihui.common.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringUtils {
	/**
	 * 将object转换成int值，异常直接返回0
	 * 
	 * @param str
	 * @return
	 */
	public static int parseInt(Object str) {
		int i;
		try {
			i = Integer.parseInt(String.valueOf(str));
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	/**
	 * 将object转换成double值，异常直接返回0
	 * 
	 * @param str
	 * @return
	 */
	public static double parseDouble(Object str) {
		double i;
		try {
			i = Double.parseDouble(String.valueOf(str));
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	/**
	 * 为url传中文值时需要用到此编码
	 * 
	 * @param str
	 * @return
	 */
	public static String URLEncoder(String str) {
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取自定义的数字字体
	 */
	public static Typeface getMyNumberTypeface(Context context) {
		return Typeface.createFromAsset(context.getAssets(), "font/myNumberFont.ttf");
	}

	/**
	 * 获取版本名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getVersionName(Context context) {
		try {
			String pkName = context.getPackageName();
			String versionName = context.getPackageManager().getPackageInfo(pkName, 0).versionName;
			return versionName;
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * 截取url中的的用户名和密码
	 * 
	 * @param url
	 * @return
	 */
	public static String subUrlPwd(String url) {
		if (TextUtils.isEmpty(url)) {
			return url;
		}
		int index = url.indexOf("k1=");
		if (index < 0) {
			return url;
		}
		return url.substring(0, index - 1);
	}

	/**
	 * 是否为空字符串
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String... s) {
		for (String item : s ) {
			if(item == null || item.length() == 0){
				return true;
			}
		}
		return false;
	}
}
