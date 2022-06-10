package com.hx.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hx.springboot.service.ThymeleafService;
import com.hx.springboot.utils.Tools;

@Controller
public class ThymeleafController {
	
	@Autowired
	private ThymeleafService thymeleafService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("index");
		List<Map<String, Object>> users = thymeleafService.queryList();
		mav.addObject("users", users);
		return mav;
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam(value = "name")String name, 
			@RequestParam(value = "address", required = false)String address,
			@RequestParam(value = "id", required = false)String id) throws Exception {
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("name", name);
		address = Tools.addressCodeToString(address);
		user.put("address", address);
		if(Tools.isEmpty(id)) {
			thymeleafService.saveUser(user);
		} else {
			user.put("id", id);
			thymeleafService.updateUser(user);
		}
		return "redirect:/list";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView update(@PathVariable int id) {
		Map<String, Object> user = thymeleafService.queryUserById(id);
		ModelAndView mav = new ModelAndView("form");
		mav.addObject("user", user);
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		thymeleafService.deleteUser(id);
		return "redirect:/list";
	}
}
