package com.example.pracprj2back.service;

import com.example.pracprj2back.domain.Member;
import com.example.pracprj2back.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;

    public boolean add(Member member) {
        return mapper.insert(member) == 1;
    }

    public String getId(String id) {
        return mapper.selectId(id);
    }

    public String getEmail(String email) {
        return mapper.selectEmail(email);
    }

    public boolean validate(Member member) {
        if (member == null) {
            return false;
        }
        if (member.getId() == null || member.getId().isBlank()) {
            return false;
        }
        if (member.getNickName() == null || member.getNickName().isBlank()) {
            return false;
        }
        if (member.getEmail() == null || member.getEmail().isBlank()) {
            return false;
        }
        if (member.getPassword() == null || member.getPassword().isBlank()) {
            return false;
        }
        return true;
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member getMember(String id) {
        return mapper.selectById(id);
    }

    public boolean deleteMember(String id) {
        return mapper.deleteById(id) == 1;
    }

    public boolean update(Member member) {
        return mapper.update(member) == 1;
    }

    public String getNickName(String nickName) {
        return mapper.selectNickName(nickName);
    }
}
