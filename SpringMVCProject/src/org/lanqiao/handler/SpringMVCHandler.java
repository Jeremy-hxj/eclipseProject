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
@SessionAttributes(types= {Student.class,Address.class})//所有的类是这个类型的都放到session中，session拿得到那么request自然也能拿得到
@Controller//加了注解，就不是普通类了，而是一个控制器类了
@RequestMapping("handler")
public class SpringMVCHandler {
	@RequestMapping(value="welcome",method=RequestMethod.POST,params= {"name=zs","age!=23"})
	public String welcome() {
		return "success";//被视图解析器加上前缀和后缀，/views/success.jsp
	}
	
	@RequestMapping(value="welcome2",headers= {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8","Accept-Encoding=gzip, deflate"})
	public String  welcome2() {
		return "success" ;//  views/success.jsp，默认使用了 请求转发的 跳转方式
	}
	@RequestMapping(value="welcome3/*/test")//*是任意字符，一个目录里的任意字符，如/shbjhbj/，不能是/shbj/hbj/
	public String  welcome3() {
		return "success" ;//  views/success.jsp，默认使用了 请求转发的 跳转方式
	}
	@RequestMapping(value="welcome4/**/test")//**是任意目录
	public String  welcome4() {
		return "success" ;//  views/success.jsp，默认使用了 请求转发的 跳转方式
	}
	@RequestMapping(value="welcome5/a?b/test")//**是任意目录
	public String  welcome5() {
		return "success" ;//  views/success.jsp，默认使用了 请求转发的 跳转方式
	}
	@RequestMapping(value="testPost/{id}",method=RequestMethod.POST)
	public String testPost(@PathVariable("id") Integer id) {
		System.out.println("post:增加"+id);
		return "success";
	}
	@RequestMapping(value="testDelete/{id}",method=RequestMethod.DELETE)
	public String testDelete(@PathVariable("id") Integer id) {
		System.out.println("delete:删"+id);
		return "success";
	}
	@RequestMapping(value="testPut/{id}",method=RequestMethod.PUT)
	public String testPut(@PathVariable("id") Integer id) {
		System.out.println("put:改"+id);
		return "success";
	}
	@RequestMapping(value="testGet/{id}",method=RequestMethod.GET)
	public String testGet(@PathVariable("id") Integer id) {
		System.out.println("get:查"+id);
		return "success";
	}
	@RequestMapping(value="testParam")//required=false,指默认不需要这个属性，没有发过来不影响，发过来也能接受，若指定了默认，在没发过来的情况下默认为这个数
	public String testParam(@RequestParam("uname") String name,@RequestParam(value="uage",required=false,defaultValue="23") Integer age) {
//		等价于String name=request.getParameter("uname");
		System.out.println("姓名："+name);
		System.out.println("年龄："+age);
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
	@RequestMapping(value="testObjectProperties")//student属性 必须 和 form表单中的属性Name值一致（支持级联属性）
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
	@RequestMapping(value="testModelAndView")//student属性 必须 和 form表单中的属性Name值一致（支持级联属性）
	public ModelAndView testModelAndView() {//ModelAndView:即有数据又有视图
		//ModelAndView:Model -M     View-V
		ModelAndView mv = new ModelAndView("success");//view: 也会经过InternalResourceViewResolver得到 view/success.jsp
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		mv.addObject("student", student);//相当于request.setAttribute("student", student);
		return mv;
	}
	@RequestMapping(value="testModelMap")
	public String testModelMap(ModelMap mm) {//success
		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");		
		mm.put("student2", student);//request域
		//forward  redirect
		//return "success";  //view
//		return "forward:/views/success.jsp";//要是指定了跳转方式，就必须写全了地址
		return "redirect:/views/success.jsp";//重定向方式，会变地址
	}
	
	@RequestMapping(value="testMap")
	public String testMap(Map<String,Object> m) {
		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		m.put("student3", student);//request域
		
		return "success";
	}
	
	@RequestMapping(value="testModel")
	public String testModel(Model model) {		
		Student student = new Student() ;
		student.setId(2);
		student.setName("zs");
		model.addAttribute("student4",student);//request域
		System.out.println("无需重启tomcat");
		return "success";
	}

	@ModelAttribute//在任何一次请求前，都会先执行@ModelAttribute修饰的方法
	//@ModelAttribute  在请求 该类的各个方法前 均被执行的设计是基于一个思想：一个控制器 只做一个功能
	public void queryStudentById(Map<String,Object> map) {
		Student student = new Student();
		student.setId(31);
		student.setName("zs");
		student.setAge(23);
//		map.put("student", student);//约定：map的key就是方法参数的首字母小写
		map.put("stu",student);//属性名可以不一样，但要做一点处理
	}
	
	@RequestMapping("testModelAttribute")
	public String testModelAttribute(/*Student student*/ @ModelAttribute("stu")Student student) {
		student.setName("hxj");
		System.out.println(student.getId()+","+student.getName()+","+student.getAge());
		return "success";
	}
	@RequestMapping("testConverter")//前端传个字符串，格式为1-zs-25
	public String testConverter(@RequestParam("studentInfo") Student student) {//本来页面的标签字段只要和类的属性的字段相同就能自动识别，现在没有就可以这样强行绑定
		System.out.println(student.getId()+","+student.getName()+","+student.getAge());
		return "success";
	}
	/*@RequestMapping("testDateTimeFormat")
	public String testDateTimeFormat(@Valid Student student,BindingResult result) {
		System.out.println(student.getId()+","+student.getName()+","+student.getTime());
		if(result.getErrorCount()>0) {//也相当于将异常捕获了
			for(FieldError error: result.getFieldErrors()) {
				System.out.println(error.getDefaultMessage());
			}
		}
		return "success";
	}*/
	
	@ResponseBody//告诉SpringMVC，此时的返回 不是一个 View页面，而是一个 ajax调用的返回值（Json数组）
	@RequestMapping("testJson")
	public List<Student> testJson() {
		//Controller-Service-dao
		//StudentService studentService = new StudentServiceImp();
//		List<Student> students =  studentService.qeuryAllStudent();
		//模拟调用service的查询操作
		
		Student stu1 = new Student(1,"zs",23);
		Student stu2 = new Student(2,"ls",24);
		Student stu3 = new Student(3,"ww",25);
		List<Student> students = new ArrayList<>();
		students.add(stu1) ;
		students.add(stu2) ;
		students.add(stu3) ;
		
		return students;
	}
	//文件上传处理方法
	@RequestMapping("testUpload")
	public String testUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IOException {//前端传来的desc字段放进string类型的desc
		System.out.println("文件描述信息："+desc);
		//jsp中上传的文件：file
		InputStream input=file.getInputStream();//IO
		String filename = file.getOriginalFilename();//拿到文件上传时的名字
		OutputStream out= new FileOutputStream("e:\\"+filename);
		
		byte[] bs=new byte[1024];
		int len=-1;
		while((len=input.read(bs))!=-1) {
			out.write(bs, 0, len);
		}
		out.close();
		input.close();
		System.out.println("上传成功");
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
