package com.gec.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brice
 * @title: ErrorException
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1414:39
 */
public class ErrorException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        String msg = "出现异常,请重试,或者联系管理员";
        String message = e.getMessage();
        if(e instanceof MyExecption){
            message=((MyExecption) e).getMsg();
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", msg);
        mav.addObject("message", message);

        mav.setViewName("error");
        return mav;
    }
}
