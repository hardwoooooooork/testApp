package com.jeaeok.myproject.testApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
		@GetMapping("/")        
		public String home(Model model){        
			model.addAttribute("message", "hello world");       
			return "index";         
		}


}
