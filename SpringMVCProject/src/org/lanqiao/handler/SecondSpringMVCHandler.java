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
	public String testExceptionHandler() {//�����쳣������@ExceptionHandler����
		System.out.println(1/0);
		return "success";
	}
	@RequestMapping("testExceptionHandler2")
	public String testExceptionHandler2() {//�����쳣������@ExceptionHandler����
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
			return "redirect:testResponseStatus";//����������ͬһ�����еķ������Ͳ��Ჹ��ǰ��׺
		}
		return "success";
	}
	@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="����Խ�磡")//Ҳ����value=��403��
	@RequestMapping("testResponseStatus")
	public String testResponseStatus() {
		System.out.println("testResponseStatus");
		return "success";
	}
	
	
	/*@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})//�൱��һ��cactch
	public ModelAndView handlerArithmeticException(Exception e) {//������Խ��ܶ���쳣���﷨�����ܵڶ������������Բ�����map
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e +"============");
		mv.addObject("e", e) ;
		return  mv;	
	}*/
}
