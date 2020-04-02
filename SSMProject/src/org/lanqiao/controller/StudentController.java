package org.lanqiao.controller;

import java.util.Map;

import org.lanqiao.entity.Student;
import org.lanqiao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//纳入ioc容器
@RequestMapping("controller")
public class StudentController {
	
	@Autowired//不加这个就不会注入，又是用注解，必须要注入
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
