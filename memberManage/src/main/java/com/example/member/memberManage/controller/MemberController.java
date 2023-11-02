package com.example.member.memberManage.controller;

import com.example.member.memberManage.dto.LoginDto;
import com.example.member.memberManage.dto.MemberDto;
import com.example.member.memberManage.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@ModelAttribute MemberDto memberDto) {
        memberService.signUp(memberDto);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(username);
        loginDto.setPassword(password);

        if (memberService.login(loginDto)) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        memberService.updateMember(id, memberDto);
        return ResponseEntity.ok("회원정보가 업데이트되었습니다.");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("회원탈퇴가 완료되었습니다.");
    }
}
