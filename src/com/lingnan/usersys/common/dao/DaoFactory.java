package com.lingnan.usersys.common.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

/**
 * dao的工厂类
 * @author Administrator
 *
 */
public class DaoFactory {
	
	/**
	 * 生产DAO的工厂类
	 * @param type 需要生产对象的类的类型
	 * @param connection 数据库连接
	 * @return 返回一个符合条件的DAO对象
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDao> T getDao(Class<T> type, Connection connection) {
		BaseDao dao = null;
		try {
		     dao = (BaseDao)Class.forName(type.getName())
		    		 .getDeclaredConstructor(Connection.class).newInstance(connection);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return (T) dao;
	}
	
}
