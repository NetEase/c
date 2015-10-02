package com.netease.cloud.c.web.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.netease.cloud.c.service.WordService;

@Controller
public class IndexController {

	public static long TIME = 60000;

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private WordService wordService;

	@RequestMapping(value = "/mvc", method = RequestMethod.GET)
	public ModelAndView add(Long pid, Long time, ModelMap model) {
		Map<String, String> env = System.getenv();
		for (String k : env.keySet()) {
			log.info(k + " " + env.get(k));
		}
		System.out.println("=========================");
		Properties p = System.getProperties();
		for (Object k : p.keySet()) {
			log.info(k + " " + p.get(k));
		}
		if (time != null)
			TIME = time;
		String db = wordService.getDb();
		String conf = System.getenv().get("conf");
		if (conf == null)
			conf = System.getenv().get("CONF");
		model.put("db", db);
		model.put("env", conf);
		model.put("result", conf);
		return new ModelAndView("bind", model);
	}

	@RequestMapping(value = "/")
	public ModelAndView index(Long pid, Long time, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return add(pid, time, model);
	}

}
