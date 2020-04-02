package org.lanqiao.service.impl;

import org.lanqiao.entity.Student;
import org.lanqiao.mapper.StudentMapper;
import org.lanqiao.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentMapper studentMapper; 
	
	
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public Student queryStudentById(int id) {
		return studentMapper.queryStudentById(id);
	}

	@Override
	public void addStudent(Student student) {
		studentMapper.addStudent(student);
	}

}
