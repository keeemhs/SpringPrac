package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    // 1) domain 만들고
    // 2) dto 만들고
    // 3) mapper 만들고
    // 4) service 만들고
    // 5) controller 만들고
    // UserService를 호출하고 그에 대한 결과를 받아와서
    // template으로 전달해주는 역할

    @Autowired
    UserService userService;
    @GetMapping("/")
    public String getUser(Model model) {
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }
    @GetMapping("/user")
    public String insertUser(@RequestParam String name, @RequestParam String nickname) {
        userService.insertUser(name, nickname);
        return "user";
    }
}
