package com.huihui.common.request;

public enum FailedReason {
	/** 服务器返回的错误 */
	SERVER_REPROT_ERROR(0, "获取数据错误"), 
	TIME_OUT(1, "获取数据超时"),
	SERVER_DOWN(2, "连接服务器失败"),
	NO_INTERNET(3, "无网络连接"),
	UNKNOW(4, "请求失败"),
	EMPTY_DATA(5, "数据为空"),
	PARSE_ERROR(6, "解析错误"),
	SQL_ERROR(7, "数据库操作失败");

	
	/** 错误码 */
	private int code;
	/** 错误描述 */
	private String desc;

	private FailedReason(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
    @Override  
    public String toString() {
		return this.desc + "_"+ this.code;
	}
}
