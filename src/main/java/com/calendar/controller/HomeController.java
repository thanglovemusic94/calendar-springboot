package com.calendar.controller;

import com.calendar.model.Day;
import com.calendar.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private DayRepository dayRepository;

	@GetMapping(value = { "/"})
	  public String addEmployee(Model model) {
		List<Day> list = dayRepository.findAll();
		if (list.size() > 0){
			model.addAttribute("list", list);
		}
	    return "index";
	  }
	

}
