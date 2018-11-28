package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("Beans.xml");

		HelloWorld obj= (HelloWorld)ctx.getBean("helloworld");
		obj.getMsg();
		
		StudentJDBCTemplate studentJdbcTemplate=(StudentJDBCTemplate)ctx.getBean("studentJDBCTemplate");
		
		//studentJdbcTemplate.create(4, "ashesh", "shah");
		//studentJdbcTemplate.create(5, "smita", "bansal");
		List<Student> studs=studentJdbcTemplate.listStudents();
		
		System.out.println("list before upate");
		for(Student s:studs) {
			System.out.println("ID : "+s.getId()+" "+s.getFname()+" "+s.getLname());
		}
		
		//studentJdbcTemplate.delete(4);
		System.out.println("searching for id 3");
		Student s= studentJdbcTemplate.getStudent(3);
		System.out.println("ID : "+s.getId()+" "+s.getFname()+" "+s.getLname());
		
		studentJdbcTemplate.update(5, "maya", "memsab");
		List<Student> list=studentJdbcTemplate.listStudents();
		System.out.println("list after upate");
		for(Student st:list) {
			System.out.println("ID : "+st.getId()+" "+st.getFname()+" "+st.getLname());
		}
			
	}

}
