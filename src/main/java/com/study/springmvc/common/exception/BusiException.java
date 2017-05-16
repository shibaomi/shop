package com.study.springmvc.common.exception;

public class BusiException extends RuntimeException{

	private static final long serialVersionUID = -7473598241175793892L;
	/**
	 * 错误代码6位长度,若为999999，表示未定义错误信息
	 */
	private String msg = "";

	public BusiException(String msg) {
		super(msg);
		this.msg = msg;
	}


	public BusiException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public BusiException(Throwable e) {
		super(e);
	}
	
	/**
	 * 格式化异常成统一格式
	 */
	public String toString() {
		String message = getLocalizedMessage();
		return "[" + this.msg + "]-[" + message + "]";
	}

}
