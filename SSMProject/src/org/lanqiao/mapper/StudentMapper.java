package org.lanqiao.mapper;

import org.lanqiao.entity.Student;

//����mybatis�Ľӿ�
public interface StudentMapper {
	/*
	 * 1.��������maper.xml�ļ��б�ǩ��idֵ��ͬ
	 * 2.���������������maper.xml�ļ��б�ǩ��parameterType����һ��
	 * 3.�����ķ���ֵ��maper.xml�ļ��б�ǩ��resultType����һ��
	 */
	 Student queryStudentById(int id);
	 void addStudent(Student student);
}
