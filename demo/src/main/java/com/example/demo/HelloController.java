package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {
    class Hello {
        private int age;

        public Hello(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    @GetMapping("/hi")
    public String gerHi(Model model) { // Model model: 컨트롤러 클래스안의 메서드가 파라미터로 받을수 있는 객체

        Hello hello = new Hello(age:26);
        List<String> names = Arrays.asList("kim", "Lee", "Hong", "Park");
        model.addAttribute("msg", "hi~~~~");
        model.addAttribute("hello", "Spring World");
        model.addAttribute("uText", "<strong>Hello</strong>");
        model.addAttribute("value", "이름을 입력하세요");
        model.addAttribute("with", "hello");
        model.addAttribute("link", "hi");
        model.addAttribute("img", "keeemhs.png");
        model.addAttribute("userRole", "admin");
        model.addAttribute("isAdmin", false);
        model.addAttribute("names", names);
        model.addAttribute("classHello", hello);

        // ${..}: 변수표현식 ${msg}
        // ${..}: URL 링크 표현식 @{/hi}
        // *{..}: 선택변수 표현식 *{msg} 단, th:object
        // 컨트롤러 클래스에서 private String msg = "hi";
        // model.addAttribute("Msg", new HelloControoler());
        // 템플릿에서 <div th:object=${msg}><h1 th:text=*{msg}></h1></div>
        return "hi";
    }
}
