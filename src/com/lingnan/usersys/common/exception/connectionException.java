package com.lingnan.usersys.common.exception;

/**
 * 获取数据库连接时异常
 * @author 钦
 */
public class connectionException  extends RuntimeException {
	
	
	/**
	 * 默认构造方法
	 */
	public connectionException() {
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
	public connectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param message 描述异常信息
	 * @param cause 异常原因
	 */
	public connectionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param message 描述异常信息
	 */
	public connectionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * @param cause 异常原因
	 */
	public connectionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
