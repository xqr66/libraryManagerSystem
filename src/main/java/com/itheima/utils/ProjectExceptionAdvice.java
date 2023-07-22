package com.itheima.utils;

import org.apache.el.parser.AstFalse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
    //记录日志
    //通知运维
        //通知开发人员
        ex.printStackTrace();
        return new R(false,"服务器故障，请稍后重试");
    }
}
