package com.calendar.controller;

import com.calendar.model.Day;
import com.calendar.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
            rm.addFlashAttribute("mgs", "dữ liệu ngày " + day.getDate() + " đã tồn tại");
        }
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes rm) {
        Day day = dayRepository.findById(id).orElseThrow(() -> new RuntimeException("data not exit"));
        dayRepository.delete(day);
        rm.addFlashAttribute("mgs2", "dữ liệu ngày " + day.getDate() + " đã được xóa");
        return "redirect:/admin";
    }
}
