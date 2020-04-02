package org.lanqiao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice//加了这个就变成一个异常处理类了，纳入IOC容器别忘了加扫描包，这样只要那些方法发生了异常就能被这捕获（自定义的处理）
public class MyExceptionHandler {
	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})//相当于一个cactch
	public ModelAndView handlerException(Exception e) {//基类可以接受多个异常，语法不接受第二个参数，所以不能用map
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e +"============该@ControllerAdvice中的异常方法，可以处理所有类中的异常");
		mv.addObject("e", e) ;
		return  mv;	
	}
}
