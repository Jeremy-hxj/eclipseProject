package org.lanqiao.mapper;

import org.lanqiao.entity.Student;

//操作mybatis的接口
public interface StudentMapper {
	/*
	 * 1.方法名和maper.xml文件中标签的id值相同
	 * 2.方法的输入参数和maper.xml文件中标签的parameterType类型一致
	 * 3.方法的返回值和maper.xml文件中标签的resultType类型一致
	 */
	 Student queryStudentById(int id);
	 void addStudent(Student student);
}
