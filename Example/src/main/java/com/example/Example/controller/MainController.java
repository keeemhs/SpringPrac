package com.example.Example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "request";
    }
    @GetMapping("/get/response1")
    // ?key=value
    // /get/response1?name=abc
    // 기본값으로 required=true를 갖기 때문에 ?name= 을 필수로 보내줘야 한다.
    public String getResponse1(@RequestParam(value="name") String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }
    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value="name", required = false) String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }
    @GetMapping("/get/response3/{name}/{age}")
    public String getResponse3(@PathVariable String name, @PathVariable("age") String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }
    @GetMapping({"/get/response4/{name}","/get/response4/{name}/{age}"})
    // @PathVariable 도 @RequestParam과 동일하게 required 의 기본값이 true
    public String getResponse4(@PathVariable String name, @PathVariable(required = false) String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "response";
    }
    @PostMapping("/post/response1")
    public String postResponse1(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/response3")
    @ResponseBody
    public String postResponse3(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "response";
    }
    @PostMapping("/post/moreInfo")
    public String postMoreInfo(@RequestParam String name, @RequestParam String gender, @RequestParam String year, @RequestParam String month, @RequestParam String day, @RequestParam List<String> interests, Model model) {
        String dob = year + "년 " + month + "월 " + day + "일";
        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("dob", dob);
        model.addAttribute("interests", interests);

        return "response";
    }

    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(UserDTO userDTO) {
        String msg = userDTO.getName() + " " + userDTO.getAge();
        return msg;
    }


}
