package com.huihui.common.request;

/**
 * 基础的实体类
 * @author YangZhenshan
 *
 */
public class BaseResponse{


	/**
	 * 服务器返回状态码
	 *  1是成功，其他由服务器定义
	 */
	public int status;
	
	/**
	 * 服务器返回消息
	 */
	public String msg;

}
