package com.hcltss.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hcltss.mapper.StudentMapper;
import com.hcltss.pojo.Student;

public class StudentDAOImpl implements StudentDAO{
	 private DataSource dataSource;
	 JdbcTemplate template;	 
	   
	  public void setTemplate(JdbcTemplate template) {  
	       this.template = template;  
	  }  

	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.template = new JdbcTemplate(dataSource);
	   }
	   public int create(Student stu) {
	     
	      String sql="insert into Student(id,name,age) values("+stu.getId()+",'"+stu.getName()+"',"+stu.getAge()+")"; 
	      System.out.println("Created Record Name = " + stu.getId() + " Name = " + stu.getName()+" Age = "+stu.getAge());
	      return template.update(sql);  

	   }
	   public Student getStudent(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Student student = template.queryForObject(SQL, 
	         new Object[]{id}, new StudentMapper());
	      
	      return student;
	   }
	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = template.query(SQL, new StudentMapper());
	      return students;
	   }
	   public void delete(Integer id) {
		   System.out.println("Delete method");
	      String SQL = "delete from Student where id = ?";
	      template.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }
	   public int update(Student stu){
	        
	      String sql="update Student set name='"+stu.getName()+"', age="+stu.getAge()+" where id="+stu.getId()+"";
	      System.out.println("Updated Record with ID = " +stu.getId());
	      return template.update(sql);  

	   }

}
