package jmp.spring.mvc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import jmp.spring.exception.FileException;

@ControllerAdvice(basePackages = { "jmp.spring.mvc.controller" })
public class ExceptionInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ FileException.class })
    public ModelAndView FileException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    public ModelAndView Exception(Exception ex) {
        logger.error(ex.getMessage(), ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        return modelAndView;
    }
}