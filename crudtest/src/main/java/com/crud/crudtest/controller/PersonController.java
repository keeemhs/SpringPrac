package com.crud.crudtest.controller;


import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    //회원가입
    @GetMapping("/register")
    public  String getRegister() {
        return "register";
    }
    @PostMapping("/register")
    @ResponseBody
    public boolean postRegister(@RequestBody PersonDTO personDTO) {

        personService.insertPerson(personDTO);
        return  true;
    }

    //로그인
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public PersonDTO postLogin( @RequestBody PersonDTO personDTO) {
       return personService.getPerson(personDTO);

    }

    //회원정보 조회
    @GetMapping("/data/{id}")
    public String getPersonData(@PathVariable("id") long id, Model model) {
        PersonDTO person = personService.getPersonData(id);
        model.addAttribute("person", person);
        return "data";
    }

    //회원정보 수정
    @PostMapping("/update")
    @ResponseBody
    public boolean postUpdate(@RequestBody PersonDTO personDTO) {
        personService.updatePerson(personDTO);
        return true;
    }

    //회원정보 삭제
    @PostMapping("/delete")
    @ResponseBody
    public  boolean postDelete(@RequestBody PersonDTO personDTO) {
        personService.deletePerson(personDTO);
        return true;
    }

}
