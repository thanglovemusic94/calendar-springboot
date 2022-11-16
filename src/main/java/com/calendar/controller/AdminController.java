package com.calendar.controller;

import com.calendar.model.Day;
import com.calendar.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DayRepository dayRepository;

    @GetMapping
    public String indexAdmin(Model model) {
        List<Day> list = dayRepository.findAll();
        model.addAttribute("day", new Day());

        if (list.size() > 0){
            model.addAttribute("list", list);
        }

        return "index-admin";
    }


    @PostMapping
    public String doAddEmployee(@ModelAttribute("day") Day day, ModelMap modelMap, RedirectAttributes rm) {
        modelMap.addAttribute("day", day);
        boolean checkDateExist = dayRepository.existsByDate(day.getDate());
        if (day != null && checkDateExist == false){
            dayRepository.save(day);
        }else {
            rm.addAttribute("mgs", "dữ liệu ngày " + day.getDate() + "đã tồn tại");
        }
        return "redirect:/admin";
    }
}
