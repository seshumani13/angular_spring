package com.hcltss.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hcltss.pojo.Student;

public interface StudentDAO {
	
	public void setDataSource(DataSource ds);
	public int create(Student student);
	public Student getStudent(Integer id);
	public List<Student> listStudents();
	public void delete(Integer id);
	public int update(Student student);
	
}
