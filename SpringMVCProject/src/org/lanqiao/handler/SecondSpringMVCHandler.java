package org.lanqiao.handler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("second")
public class SecondSpringMVCHandler {
	@RequestMapping("testExceptionHandler")
	public String testExceptionHandler() {//出了异常，交给@ExceptionHandler处理
		System.out.println(1/0);
		return "success";
	}
	@RequestMapping("testExceptionHandler2")
	public String testExceptionHandler2() {//出了异常，交给@ExceptionHandler处理
		int num[]=new int[2];
		System.out.println(num[2]);
		return "success";
	}
	@RequestMapping("testMyException")
	public String testMyException(@RequestParam("i") Integer i) {
		if(i==3) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return "success";
	}
	
	
	@RequestMapping("testMyException2")
	public String testMyException2(@RequestParam("i") Integer i) {
		if(i==3) {
			System.out.println("testMyException2");
			return "redirect:testResponseStatus";//这样跳到在同一个类中的方法，就不会补充前后缀
		}
		return "success";
	}
	@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="数组越界！")//也可以value=“403”
	@RequestMapping("testResponseStatus")
	public String testResponseStatus() {
		System.out.println("testResponseStatus");
		return "success";
	}
	
	
	/*@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})//相当于一个cactch
	public ModelAndView handlerArithmeticException(Exception e) {//基类可以接受多个异常，语法不接受第二个参数，所以不能用map
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e +"============");
		mv.addObject("e", e) ;
		return  mv;	
	}*/
}
