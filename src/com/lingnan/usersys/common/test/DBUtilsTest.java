package com.lingnan.usersys.common.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.lingnan.usersys.common.util.DBUtils;

class DBUtilsTest {

	@Test
	void testGetConnction() {
		Connection conn = DBUtils.getConnection();
		System.out.println(conn);
	}

}
