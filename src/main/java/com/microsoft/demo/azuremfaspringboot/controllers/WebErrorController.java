package com.microsoft.demo.azuremfaspringboot.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ComponentScan(basePackages = "com.microsoft.demo.azuremfaspringboot.controllers")
@RequestMapping(value = "/error")
@Controller
public class WebErrorController implements ErrorController {

	private static final Logger logger = Logger.getLogger(WebErrorController.class.getName());

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleNotFound(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("errors", "page does not exists");
		mav.setViewName("error");
		return mav;
	}

	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ModelAndView handleUnauthorized(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("errors", "you are not authorized to view this page");
		mav.setViewName("error");
		return mav;
	}

	
	@Override
	public String getErrorPath() {
		logger.info("routing to error page");
		return "error";
	}

}
