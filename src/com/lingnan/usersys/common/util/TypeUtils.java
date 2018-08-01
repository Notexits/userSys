package com.lingnan.usersys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 检查与转换数据类型工具类
 * @author Administrator
 *
 */
public class TypeUtils {
	
	/**
	 * 将日期类型转换为字符串
	 * @param date 输入想要转换的日期类型
	 * @return str 返回转换后的字符串
	 */
	public static String dateToString(Date date) {
		String str = null;
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		str = simple.format(date);
		return str; 
	}
	
	/**
	 * 将字符串转换为日期类型
	 * @param str 传入想要转换的字符串
	 * @return date 返回转换后的字符串
	 */
	public static Date stringToDate(String str) {
		Date date = null;
		try {
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			date = simple.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 检查输入的日期是否符合条件
	 * @param str 输入的日期
	 * @return flag 返回true或者false
	 */
	public static boolean checkDate(String str) {
		boolean flag = false;	
		String regular = "[0-9]+[-][0-9]{2}[-][0-9]{2}";
		if(str.matches(regular)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 检查邮箱是否符合条件（xxx@xx.xx.xxx）
	 * @param str 需要检验的邮箱
	 * @return flag 是否是正确的邮箱格式
	 */
	public static boolean checkEmail(String str) {
		boolean flag = false;
		String regular = "[a-z0-9\\u4e00-\\u9fa5A-Z]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9_-]+)+";
		if(str.matches(regular)) {
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 检查邮箱是否符合条件（xxx@xx.xx.xxx）
	 * @param str 需要检验的手机号
	 * @return flag 是否是正确的手机号格式
	 */
	public static boolean checkPhone(String str) {
		boolean flag = false;
		String regular = "^1[0-9]{10}$";
		if(str.matches(regular)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 输入选项并且检查是否正确
	 * @return select 返回正确选项
	 */
	public static int getSelect() {
		boolean flag = false;
		int select = 0;
		Scanner in = new Scanner(System.in);	
		while(flag) {
			try {	
				flag = false;	//如果输入成功，不需要在重新输入（即不需要进入循环）
				select = Integer.parseInt(in.nextLine());
			}
			catch(Exception e) {	
				System.out.print("输入的选项有错请重新选择:");
				flag = true ;	//这里的true表示输入的选项有错，需要重新输入（即需要再次进入循环）
				continue;
			}
		}
		return select;
	}
}
