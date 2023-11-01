package com.example.Example.controller;

import com.example.Example.dto.UserDTO;
import com.example.Example.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// @RestController
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
    // 검색 검색어는 필수 + 해시태그, 상세설정 선택
    // ?search=가
    // ?search=가&hashtag=집
    public String getResponse2(@RequestParam(value="name", required = false) String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }
    @GetMapping("/get/response3/{ㅇㅇㅇㅇㅇ}/{ㄴㄴㄴ}")
    public String getResponse3(@PathVariable String ㅇㅇㅇㅇㅇ, @PathVariable("ㄴㄴㄴ") String ㅅㅅㅅ, Model model){
        model.addAttribute("name", ㅇㅇㅇㅇㅇ);
        model.addAttribute("age", ㅅㅅㅅ);
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
    public String postResponse1(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
    }

    @PostMapping("/post/response2")
    public String postResponse2(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
    }
    @PostMapping("/post/response3")
    @ResponseBody
    // @ResponseBody : response 데이터를 전달한다. // res.send
    public String postResponse3(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name", name);
        //@RequestBody : 전달받은 body 데이터를 json 형태의 객체로 만들어준다.
        return "response";
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoResponse1(@ModelAttribute UserDTO userDTO){
        // DTO 앞에 어노테이션을 붙이지 않았으면 -> @ModelAttrbute 가 자동으로 실행된다.
        // 아무것도 넣지 않던 = @ModelAttribute 동일
        // @ModelAttribute : html 폼 데이터를 컨트롤러로 전달할 때 객체에 매핑해주는 친구
        // 매핑 -> 같은 이름끼리 set 함수를 실행한다.
        // -> 프론트에서 {name, age} -> setName, setAge를 실행한다.
        String msg = userDTO.getName() + " " + userDTO.getAge();
        return msg;
    }
    @GetMapping("/dto/response11")
    @ResponseBody
    public String dtoResponse11(@RequestBody UserDTO userDTO) {
        // Get 방식으로 전달하고 @RequestBody로 받으면 오류
        // @RequestBody : 요청의 본문에 있는 데이터(body)
        String msg = userDTO.getName() + " " + userDTO.getAge();
        return msg;
    }
    // 일반 폼전송 - DTO
    // 1) 아무것도 적지 않고 DTO로 바로 받으면 -> O
    // 2) @ModelAttribute DTO 로 받으면 -> o
    // 3) @RequestBody DTO 로 받으면 -> 오류

    // @RequestBody는 요청의 본문에 있는 데이터(body)를 받아서 객체에 매핑 단, 전달받은 요청의 데이터 형식이
    // json 또는 xml 일 때만 실행이 가능
    // 일반 폼 전송 -> www-x-form-urlencoded

    @GetMapping("/vo/response1")
    @ResponseBody
    public String voResponse1(@ModelAttribute UserVO userVO){
        // @ModelAttribute 를 이용하면 객체의 set 함수를 이용해 값을 넣어준다.
        String msg = userVO.getName() + " " + userVO.getAge();
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voResponse2(UserVO userVO) {
        String msg = userVO.getName() + " " + userVO.getAge();
        return msg;
    }
}
