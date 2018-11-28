package com.test;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	
	public void setDataSource(DataSource ds);
	
	public void create(Integer id,String fname, String lname);
	
	public Student getStudent(Integer id);
	
	public List<Student> listStudents();
	
	public void delete(Integer id);
	
	 public void update(Integer id, String fname, String lname);
	

}
