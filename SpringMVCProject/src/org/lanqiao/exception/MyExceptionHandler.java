package org.lanqiao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice//��������ͱ��һ���쳣�������ˣ�����IOC���������˼�ɨ���������ֻҪ��Щ�����������쳣���ܱ��Ⲷ���Զ���Ĵ���
public class MyExceptionHandler {
	@ExceptionHandler({ArithmeticException.class,ArrayIndexOutOfBoundsException.class})//�൱��һ��cactch
	public ModelAndView handlerException(Exception e) {//������Խ��ܶ���쳣���﷨�����ܵڶ������������Բ�����map
		ModelAndView mv = new ModelAndView("error");
		System.out.println(e +"============��@ControllerAdvice�е��쳣���������Դ����������е��쳣");
		mv.addObject("e", e) ;
		return  mv;	
	}
}
