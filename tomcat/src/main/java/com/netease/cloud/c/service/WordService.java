package com.netease.cloud.c.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.netease.cloud.c.web.controllers.IndexController;

@Service
public class WordService {

	private static final Logger log = LoggerFactory.getLogger(WordService.class);

	@PostConstruct
	public void init() {

		final String name = "Hello";

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					String d = name + new Date();
					System.out.println(d);
					log.error(d);
					try {
						Thread.sleep(IndexController.TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}).start();
	}

	private String db;

	public void flush() {
		System.out.println("flush");
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}
}
