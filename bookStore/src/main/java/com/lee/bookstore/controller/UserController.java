package com.lee.bookstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lee.bookstore.service.BookService;
import com.lee.bookstore.service.UserService;

@Controller
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/join");
		return mov;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView joinPost(@RequestParam Map<String, Object> map) {
		ModelAndView mov = new ModelAndView();
		LOGGER.info(map.toString());
		Boolean isJoinSuccess = userService.join(map);
		if (isJoinSuccess)
			mov.setViewName("redirect:/login");
		else
			mov.setViewName("redirect:/join");
		return mov;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("/user/login");
		return mov;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		Map<String, Object> user = this.userService.login(map);
		if (user != null) {
			mav.setViewName("redirect:/main");
		} else
			mav.setViewName("redirect:/login");
		return mav;
	}
}
