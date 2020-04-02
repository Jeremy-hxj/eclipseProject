package org.lanqiao.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;

import org.lanqiao.entity.Address;
import org.lanqiao.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//@SessionAttributes(value="student,student2")
@SessionAttributes(types= {Student.class,Address.class})//���е�����������͵Ķ��ŵ�session�У�session�õõ���ôrequest��ȻҲ���õõ�
@Controller//����ע�⣬�Ͳ�����ͨ���ˣ�����һ������������
@RequestMapping("handler")
public class SpringMVCHandler {
	@RequestMapping(value="welcome",method=RequestMethod.POST,params= {"name=zs","age!=23"})
	public String welcome() {
		return "success";//����ͼ����������ǰ׺�ͺ�׺��/views/success.jsp
	}
	
	@RequestMapping(value="welcome2",headers= {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8","Accept-Encoding=gzip, deflate"})
	public String  welcome2() {
		return "success" ;//  views/success.jsp��Ĭ��ʹ���� ����ת���� ��ת��ʽ
	}
	@RequestMapping(value="welcome3/*/test")//*�������ַ���һ��Ŀ¼��������ַ�����/shbjhbj/��������/shbj/hbj/
	public String  welcome3() {
		return "success" ;//  views/success.jsp��Ĭ��ʹ���� ����ת���� ��ת��ʽ
	}
	@RequestMapping(value="welcome4/**/test")//**������Ŀ¼
	public String  welcome4() {
		return "success" ;//  views/success.jsp��Ĭ��ʹ���� ����ת���� ��ת��ʽ
	}
	@RequestMapping(value="welcome5/a?b/test")//**������Ŀ¼
	public String  welcome5() {
		return "success" ;//  views/success.jsp��Ĭ��ʹ���� ����ת���� ��ת��ʽ
	}
	@RequestMapping(value="testPost/{id}",method=RequestMethod.POST)
	public String testPost(@PathVariable("id") Integer id) {
		System.out.println("post:����"+id);
		return "success";
	}
	@RequestMapping(value="testDelete/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id") Integer id) {
		System.out.println("delete:ɾ"+id);
		return "success";
	}
	@RequestMapping(value="testPut/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable("id") Integer id) {
		System.out.println("put:��"+id);
		return "success";
	}
	@RequestMapping(value="testGet/{id}",method=RequestMethod.GET)
	public String testGet(@PathVariable("id") Integer id) {
		System.out.println("get:��"+id);
		return "success";
	}
	@RequestMapping(value="testParam")//required=false,ָĬ�ϲ���Ҫ������ԣ�û�з�������Ӱ�죬������Ҳ�ܽ��ܣ���ָ����Ĭ�ϣ���û�������������Ĭ��Ϊ�����
	public String testParam(@RequestParam("uname") String name,@RequestParam(value="uage",required=false,defaultValue="23") Integer age) {
//		�ȼ���String name=request.getParameter("uname");
		System.out.println("������"+name);
		System.out.println("���䣺"+age);
		return "success";
	}
	@RequestMapping(value="testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String language) {
		System.out.println(language);
		return "success";
	}
	@RequestMapping(value="testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String cookie) {
		System.out.println(cookie);
		return "success";
	}
	@RequestMapping(value="testObjectProperties")//student���� ���� �� form���е�����Nameֵһ�£�֧�ּ������ԣ�
	public String testObjectProperties(Student student) {
		System.out.println(student);
		return "success";
	}
	@RequestMapping(value="testServletAPI")
	public String testServletAPI(HttpServletRequest  request,HttpServletResponse response) {
//		request.getParameter("uname") ;
		System.out.println(request);
		return "success" ;
	}
	@RequestMapping(value="testModelAndView")//student���� ���� �� form���е�����Nameֵһ�£�֧�ּ������ԣ�
	public ModelAndView testModelAndView() {//ModelAndView:��������������ͼ
		//ModelAndView:Model -M     View-V
		ModelAndView mv = new ModelAndView("success");//view: Ҳ�ᾭ��InternalResourceViewResolver�õ� view/success.jsp
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		mv.addObject("student", student);//�൱��request.setAttribute("student", student);
		return mv;
	}
	@RequestMapping(value="testModelMap")
	public String testModelMap(ModelMap mm) {//success
		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");		
		mm.put("student2", student);//request��
		//forward  redirect
		//return "success";  //view
//		return "forward:/views/success.jsp";//Ҫ��ָ������ת��ʽ���ͱ���дȫ�˵�ַ
		return "redirect:/views/success.jsp";//�ض���ʽ������ַ
	}
	
	@RequestMapping(value="testMap")
	public String testMap(Map<String,Object> m) {
		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		m.put("student3", student);//request��
		
		return "success";
	}
	
	@RequestMapping(value="testModel")
	public String testModel(Model model) {		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		model.addAttribute("student4",student);//request��
		System.out.println("��������tomcat");
		return "success";
	}

	@ModelAttribute//���κ�һ������ǰ��������ִ��@ModelAttribute���εķ���
	//@ModelAttribute  ������ ����ĸ�������ǰ ����ִ�е�����ǻ���һ��˼�룺һ�������� ֻ��һ������
	public void queryStudentById(Map<String,Object> map) {
		Student student = new Student();
		student.setId(31);
		student.setName("zs");
		student.setAge(23);
//		map.put("student", student);//Լ����map��key���Ƿ�������������ĸСд
		map.put("stu",student);//���������Բ�һ������Ҫ��һ�㴦��
	}
	
	@RequestMapping("testModelAttribute")
	public String testModelAttribute(/*Student student*/ @ModelAttribute("stu")Student student) {
		student.setName("hxj");
		System.out.println(student.getId()+","+student.getName()+","+student.getAge());
		return "success";
	}
	@RequestMapping("testConverter")//ǰ�˴����ַ�������ʽΪ1-zs-25
	public String testConverter(@RequestParam("studentInfo") Student student) {//����ҳ��ı�ǩ�ֶ�ֻҪ��������Ե��ֶ���ͬ�����Զ�ʶ������û�оͿ�������ǿ�а�
		System.out.println(student.getId()+","+student.getName()+","+student.getAge());
		return "success";
	}
	/*@RequestMapping("testDateTimeFormat")
	public String testDateTimeFormat(@Valid Student student,BindingResult result) {
		System.out.println(student.getId()+","+student.getName()+","+student.getTime());
		if(result.getErrorCount()>0) {//Ҳ�൱�ڽ��쳣������
			for(FieldError error: result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
		}
		return "success";
	}*/
	
	@ResponseBody//����SpringMVC����ʱ�ķ��� ����һ�� Viewҳ�棬����һ�� ajax���õķ���ֵ��Json���飩
	@RequestMapping("testJson")
	public List<Student> testJson() {
		//Controller-Service-dao
		//StudentService studentService = new StudentServiceImp();
//		List<Student> students =  studentService.qeuryAllStudent();
		//ģ�����service�Ĳ�ѯ����
		
		Student stu1 = new Student(1,"zs",23);
		Student stu2 = new Student(2,"ls",24);
		Student stu3 = new Student(3,"ww",25);
		List<Student> students = new ArrayList<>();
		students.add(stu1) ;
		students.add(stu2) ;
		students.add(stu3) ;
		
		return students;
	}
	//�ļ��ϴ�������
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IOException {//ǰ�˴�����desc�ֶηŽ�string���͵�desc
		System.out.println("�ļ�������Ϣ��"+desc);
		//jsp���ϴ����ļ���file
		InputStream input=file.getInputStream();//IO
		String filename = file.getOriginalFilename();//�õ��ļ��ϴ�ʱ������
		OutputStream out= new FileOutputStream("e:\\"+filename);
		
		byte[] bs=new byte[1024];
		int len=-1;
		while((len=input.read(bs))!=-1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		System.out.println("�ϴ��ɹ�");
		return "success";
	}
	
	@RequestMapping("testException")
	public String testException() {
		System.out.println(1/0);
		return "success";
	}
	@RequestMapping("testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver() {
		System.out.println(1/0);
		return "success";
	}
	
	
}
