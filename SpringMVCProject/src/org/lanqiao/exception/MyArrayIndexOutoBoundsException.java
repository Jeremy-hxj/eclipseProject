package org.lanqiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="数组越界！")//也可以value=“403”
public class MyArrayIndexOutoBoundsException extends Exception{//自定义异常
}
