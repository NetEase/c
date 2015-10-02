package com.netease.cloud.c.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class AppsExceptionResolver implements HandlerExceptionResolver, Ordered {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ModelMap model = new ModelMap();
		return forwardError(ex, model);
	}

	private ModelAndView forwardError(Exception ex, ModelMap model) {
		model.put("msg", ex.getMessage());
		model.put("code", 400);
		model.put("result", "");
		return new ModelAndView("springError", model);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
