package org.lanqiao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN,reason="����Խ�磡")//Ҳ����value=��403��
public class MyArrayIndexOutoBoundsException extends Exception{//�Զ����쳣
}
