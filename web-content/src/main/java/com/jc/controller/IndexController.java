package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping("/")
    public String home(Model model) {
		String name = "John Smith";
        model.addAttribute("name", name);
        return "index";
    }
}
