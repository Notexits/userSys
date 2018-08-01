package com.lingnan.usersys.common.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.lingnan.usersys.common.util.TypeUtils;

class TypeUtilsTest {

	@Test
	void testDateToString() {
		Date date = new Date(1997, 02, 15);
		System.out.println(TypeUtils.dateToString(date));
	}

	@Test
	void testStringToDate() {
		String str = "1997-02-15";
		System.out.println(TypeUtils.stringToDate(str));
	}

	@Test
	void testCheckDate() {
		System.out.println("111111是否符合日期格式："+TypeUtils.checkDate("11111"));
		System.out.println("888-555-55是否符合日期格式："+TypeUtils.checkDate("888-555-55"));
		System.out.println("888-55-5555是否符合日期格式："+TypeUtils.checkDate("888-55-5555"));
		System.out.println("888-55-55是否符合日期格式："+TypeUtils.checkDate("888-55-55"));
		System.out.println("8888-55-55是否符合日期格式："+TypeUtils.checkDate("8888-55-55"));
	}

	@Test
	void testCheckEmail() {
		System.out.println("1111是否符合邮件格式"+TypeUtils.checkEmail("11111"));
		System.out.println("1111@是否符合邮件格式"+TypeUtils.checkEmail("11111@"));
		System.out.println("1111@111是否符合邮件格式"+TypeUtils.checkEmail("11111@111"));
		System.out.println("1111@111.是否符合邮件格式"+TypeUtils.checkEmail("11111@111."));
		System.out.println("1111aaa钦@111.com是否符合邮件格式"+TypeUtils.checkEmail("11111@111.com"));
		System.out.println("1111@111.com.cn是否符合邮件格式"+TypeUtils.checkEmail("11111@111.com.cn"));
	}

}
