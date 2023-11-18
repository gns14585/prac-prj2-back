package com.example.pracprj2back.controller;

import com.example.pracprj2back.domain.Member;
import com.example.pracprj2back.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService service;

    @PostMapping("signup")
    public void signup(@RequestBody Member member) {
        service.add(member);
    }

    @GetMapping(value = "check", params = "id")
    public void checkId(String id) {

    }
}
