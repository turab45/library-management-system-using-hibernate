package dao;

import java.util.List;

import models.Student;

public interface StudentDao {
	public Integer addStudent(Student student);
	public Integer updateStudent(Student student);
	public Integer deleteStudent(Student student);
	public Integer getStudentIdByName(String name);
	public Student getStudentById(Integer id);
	public List<Student> getAllStudent();
	public Integer getIdByRollNo(String rollNo);
	

}
