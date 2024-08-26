package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstConroller {
   @GetMapping("/hi")  //클라이언트로부터 url요청을 접수하는 부분  url에 localhost:8282/hi를 입력하면 greetins.mustache페이지를 불러옴
public String niceToMeetYou(Model model) { //model객체 받아오기 Model타입의 model 매개변수 추가
    model.addAttribute("username","수진");  //변수 등록. model 객체가 "수진"값을 "username"에 연결해 웹 브라우저에 보냄
       return"greetings"; //반환할 페이지(불러오기)

}
@GetMapping("/bye")
    public String seeYouNext(Model model){
       model.addAttribute("username", "수진");
       return"goodbye";
}
}
