package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController {

    @GetMapping("/Activity1")
    public String checkAge(@RequestParam int age, Model model) {
        if (age < 20) {
            model.addAttribute("message", "미성년자입니다.");
        } else {
            model.addAttribute("message", "성인입니다.");
        }
        return "activity1";
    }
}
