package com.zzz.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("/page")
public class PageController {
	@RequestMapping("/Registerbananer")
	public String touristPage(ModelMap map) {
		return "../basic-custom";
	}
	@RequestMapping("/banner")
	public String touristBanner(ModelMap map) {
		return "tourist/banner";
	}
	@RequestMapping("/resume")
	public String touristResume(ModelMap map) {
		return "tourist/resumes";
	}
	@RequestMapping("/index")
	public String touristIndex(ModelMap map) {
		return "tourist/index";
	}
}
