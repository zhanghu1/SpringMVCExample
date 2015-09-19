package com.xiaomi.springmvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * @author 		zhanghu1
 * @date   		2015年8月12日
 * @fileName	StudentMapper.java
 * @packageName	com.xiaomi.springmvc.model
 * @projectName SpringMVCExample
 * @Company		Xiaomi
 */

/**
 * 这个类被称为装载类，是数据库操作中的经典实现
 * */
public class StudentMapper implements RowMapper<StudentInfo> {

	public StudentInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		StudentInfo student = new StudentInfo();
		
		student.setID(rs.getString("ID"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		student.setFM(rs.getString("FM"));
		
		return student;
	}

}

