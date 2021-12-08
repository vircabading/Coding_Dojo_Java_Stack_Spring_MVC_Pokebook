package com.vcabading.pokebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/////////////////////////////////////////////////////
//	HOME CONTROLLER
/////////////////////////////////////////////////////

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
}
