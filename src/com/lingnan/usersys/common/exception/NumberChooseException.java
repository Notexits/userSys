package com.lingnan.usersys.common.exception;

public class NumberChooseException extends RuntimeException{

	/**
	 * 默认构造方法
	 */
	public NumberChooseException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 构造方法
	 * @param message 描述异常信息
	 * @param cause 异常原因
	 * @param enableSuppression 是否启用或禁用抑制功能
	 * @param writableStackTrace 栈跟踪是否可写
	 */
	public NumberChooseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param message 描述异常信息
	 * @param cause 异常原因
	 */
	public NumberChooseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param message 描述异常信息
	 */
	public NumberChooseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param cause 异常原因
	 */
	public NumberChooseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
