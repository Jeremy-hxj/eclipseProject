package org.lanqiao.controller;

import java.util.Map;

import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//����ioc����
@RequestMapping("controller")
public class StudentController {
	
	@Autowired//��������Ͳ���ע�룬������ע�⣬����Ҫע��
	private StudentService ss;//
	
//	public void setSs(StudentService ss) {
//		this.ss = ss;
//	}

	@RequestMapping("studentController/{id}")
	public String queryStudentById(@PathVariable("id") Integer id,Map<String, Object> map) {
		Student student = ss.queryStudentById(id);
		map.put("student", student);
		return "result";
	}
}
