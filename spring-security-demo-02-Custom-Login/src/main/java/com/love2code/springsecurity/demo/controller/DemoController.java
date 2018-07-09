package com.love2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return"home";
	}
	
//Add request mapping for /leaders
	@GetMapping("/leaders")
	public String ShowLeaders() {
		return"leaders";
	}
//Add request mapping for /systems
	@GetMapping("/systems")
	public String ShowSystems() {
		return"systems";
	}
	
	@GetMapping("/access-denied")
	public String ShowAccessdenied() {
		return"access-denied";
	}
	
}
