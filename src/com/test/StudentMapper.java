package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Student s=new Student();
		s.setId(rs.getInt("id"));
		s.setFname(rs.getString("fname"));
		s.setLname(rs.getString("lname"));
		
		return s;
	}

}
