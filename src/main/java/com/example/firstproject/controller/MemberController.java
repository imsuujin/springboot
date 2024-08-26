package com.example.firstproject.controller;
import com.example.firstproject.dto.MemberForm;


import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@ToString
@Slf4j
@Controller
public class MemberController {
    @Autowired

    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String NewMemberForm() {

        return "members/new";
    }

 @PostMapping("/join")
    public String CreateMember(MemberForm form) {
     log.info(form.toString());
    Member member =form.ToEntity();
    Member saved = memberRepository.save(member);
     return "redirect:/members/"+saved.getId();

 }
 //단일데이터 조회
 //데이터 목록 조회

 @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
     Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("member",memberEntity);
        return "members/show";


 }
 @GetMapping("/members")
    public String index(Model model){

     Iterable<Member> memberEntityList = memberRepository.findAll();
     model.addAttribute("memberList",memberEntityList);
        return "members/index";
 }
}

