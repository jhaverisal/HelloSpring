package com.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		dataSource=ds;
		this.jdbcTemplateObject=new JdbcTemplate(ds);

	}

	@Override
	public void create(Integer id, String fname, String lname) {
		String query="insert into Students(id,fname,lname) values(?,?,?)";
		jdbcTemplateObject.update(query,id,fname,lname);
		System.out.println("Created Record Name = " + fname + " "+lname );
	      return;

	}

	@Override
	public Student getStudent(Integer id) {
		String query="select * from Students where id=?";
		
		Student s=jdbcTemplateObject.queryForObject(query, new Object[] {id}, new StudentMapper());
		return s;
	}

	@Override
	public List<Student> listStudents() {
		String sql="select * from Students";
		List<Student> studs= jdbcTemplateObject.query(sql, new StudentMapper());
		return studs;
	}

	@Override
	public void delete(Integer id) {
		
		String sql="delete from students where id=?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("deleted record with id :"+id);
		return;
		
	}

	@Override
	public void update(Integer id, String fname, String lname) {
		String sql="update students set fname=?, lname=? where id=?";
		
		jdbcTemplateObject.update(sql,fname,lname,id);
		
		System.out.println("Student updated for id :"+ id);
		
		return;

	}

}
