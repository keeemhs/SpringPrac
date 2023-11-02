package com.example.member.memberManage.service;

import com.example.member.memberManage.dto.LoginDto;
import com.example.member.memberManage.dto.MemberDto;
import com.example.member.memberManage.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public void signUp(MemberDto memberDto) {
        memberMapper.insertMember(memberDto);
    }

    public boolean login(LoginDto loginDto) {
        MemberDto memberDto = memberMapper.findMemberByUsernameAndPassword(loginDto);
        return memberDto != null;
    }

    public void updateMember(Long id, MemberDto memberDto) {
        memberDto.setId(id);
        memberMapper.updateMember(memberDto);
    }

    public void deleteMember(Long id) {
        memberMapper.deleteMember(id);
    }
}
