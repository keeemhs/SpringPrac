package com.example.member.memberManage.mapper;

import com.example.member.memberManage.dto.LoginDto;
import com.example.member.memberManage.dto.MemberDto;
import com.example.member.memberManage.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDto memberDto);
    MemberDto findMemberByUsernameAndPassword(LoginDto loginDto);
    void updateMember(MemberDto memberDto);
    void deleteMember(Long id);
}
