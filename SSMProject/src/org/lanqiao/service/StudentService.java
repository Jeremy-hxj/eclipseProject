package org.lanqiao.service;

import org.lanqiao.entity.Student;

public interface StudentService {
	Student queryStudentById(int id);
	void addStudent(Student student);
}
