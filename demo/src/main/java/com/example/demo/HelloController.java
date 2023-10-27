package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hi")
    public String gerHi(Model model) { // Model model: 컨트롤러 클래스안의 메서드가 파라미터로 받을수 있는 객체
        model.addAttribute("msg", "hi~~~~");

        // ${..}: 변수표현식 ${msg}
        // ${..}: URL 링크 표현식 @{/hi}
        // *{..}: 선택변수 표현식 *{msg} 단, th:
        return "hi";
    }

}
