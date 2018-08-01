package com.lingnan.usersys.common.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

/**
 * dao的工厂类
 * @author Administrator
 *
 */
public class DaoFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends BaseDao> T getDao(Class<T> type, Connection connection) {
		BaseDao dao = null;
		try {
		     dao = (BaseDao)Class.forName(type.getName())
		    		 .getDeclaredConstructor(Connection.class).newInstance(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (T) dao;
	}
	
}
