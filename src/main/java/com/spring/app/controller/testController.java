package com.spring.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {
	@RequestMapping(value="/home")
	public String main() {
		return "my_test";
	}
	@RequestMapping(value="/home2")
	public String my_test2() {
		return "my_test2";
	}
}
