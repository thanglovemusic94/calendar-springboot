package com.calendar.controller;

import com.calendar.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.calendar.model.Day;

import java.util.Optional;

@Controller
public class HomeController {
	@Autowired
	private DayRepository dayRepository;

	@GetMapping(value = { "/"})
	  public String addEmployee(Model model) {

	    return "index";
	  }
	

}
