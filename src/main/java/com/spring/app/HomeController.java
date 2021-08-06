package com.spring.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@LogExecutionTime
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/my_test3")
	public String my_test3() {
		return "my_test3";
	}
	@RequestMapping(value="/first")
	public String first(Model model) {
		model.addAttribute("today", new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date()));
		
		return "index";
	}
	@RequestMapping(value="/second")
	public ModelAndView second() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("now", new SimpleDateFormat("a hh시 mm분 ss").format(new Date()));
		mav.setViewName("index");
		
		return mav;
	}
	@RequestMapping("/join")
	public String join() {
		return "/member/join";
	}
	// 1. HttpServletRequest를 이용하여 form의 데이터 가져오기
	@RequestMapping("/joinRequestServlet")
	@LogExecutionTime
	public String join(HttpServletRequest request, Model model) {
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		model.addAttribute("method", "HttpServletRequest");
		
		System.out.println("joinRequestServlet");
		
		return "/member/info";
	}
	// 2. @RequestParam을 이용하여 form의 데이터 가져오기
	@RequestMapping("/joinRequestParam")
	@LogExecutionTime
	public String join(Model model, String name, @RequestParam("gender") String g, String email) {
		model.addAttribute("name", name);
		model.addAttribute("gender", g);
		model.addAttribute("email", email);
		model.addAttribute("method", "@RequestParam");
		
		System.out.println("joinRequestParam");
		
		return "/member/info";
	}
	// 3. 데이터 객체를 이용하여 form의 데이터 가져오기
	@RequestMapping("/joinDataObject")
	public String join(MemberVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("method", "데이터 객체");
		
		System.out.println("joinDataObject");
		
		return "/member/info";
	}
	// 4. @PathVariable을 이용하 form의 데이터 가져오기
	@RequestMapping("/joinPathVariable/{name}/{gender}/{email}")
	public String join(@PathVariable String name, Model model, @PathVariable String gender, @PathVariable String email) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("method", "@PathVariable");
		
		System.out.println("joinPathVariable");
		
		return "/member/info";
	}
}























