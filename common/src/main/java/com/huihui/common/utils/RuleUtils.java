package com.huihui.common.utils;

import java.util.Collection;

/**
 * 一些判断规则
 * @author YangZhenshan
 * @date 2016-4-16 10:22:17
 */
public class RuleUtils {
	/**
	 * 判断list是不是为null或者size是不是为0
	 * @param list
	 * @return
	 */
	public static boolean isEmptyList(Collection<?> list){
		return list == null || list.isEmpty();
	}
}
