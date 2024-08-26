package com.example.firstproject.controller;

import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Slf4j //로깅기능
@Controller   //컨트롤러 선언
public class ArticleController {
    @Autowired //스프링부트가 미리 생성해놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;  //articleRepository객체 선언

    @GetMapping("/articles/new") //url 요청 접수
    public String newArticleForm() { //메서드 생성 및 반환값 작성
        return "articles/new";
    }

    @PostMapping("/articles/create")
    //입력페이지에서 데이터를 전송하면 createArticle에서 폼 데이터를 받는다 포스트 방식으로 /articles/create라는 URL요청을 받아 폼을 처리
    public String createArticle(ArticleForm form) { //폼데이터를 dto로 받기

        //   System.out.println(form.toString()); //dto에 폼 데이터가 잘 담겼는지 확인
        log.info(form.toString());

        //DTO를 엔티티로 변환
        Article article = form.toEntity();  //toEntity(): DTO인 form객체를 엔티티 객체로 변환하는 역할, Article 타입의 article
        //   System.out.println(article.toString()); //DTO가 엔티티로 잘 변환되는지 확인 추력
        log.info(article.toString());

        //리파지터리로 엔티티를 데이터베이스에 저장
        Article saved = articleRepository.save(article); //article엔티티를 저장해 saved객체에 반환
        //    System.out.println(saved.toString()); //article이 DB에 잘 저장되는지 확인 출력

        log.info("---------------------------------");
        log.info(saved.toString());

        return "redirect:/articles/"+saved.getId();  //입력페이지 후 상세페이지 이동 새글 아이디가 n번이면 n페이지이동:saved.getId() saved객체의 id값 가져옴
       //엔티티페이지에 게터 어노테이션 추가
    }

    @GetMapping("/articles/{id}")  //단일데이터 조회
    public String show(@PathVariable Long id, Model model) {  //PathVariable 매개변수 받아오기-URL의 id를 가져올수있다
        log.info("id="+id);//id잘받았는지 확인
        //id를 조회해 데이터 가져오기-findById()특정 엔티티의 값을 기준으로 데이터를 찾아 Opional타입으로 변환, orElse: id값으로 데이터를 찾을 때 해당 아이디가 없으면 null반환
        Article articleEntity = articleRepository.findById(id).orElse(null); //찾는 데이터를 Article 타입의 articleEntity변수에 저장
        //모델에 데이터 등록하기 아이디를 조회한 데이터를 모델에 article이라는 이름으로 저장
        model.addAttribute("article", articleEntity); //모델객체가 articleEntity값을 이용해 article에 연결해 웹브라우저에 보냄
        //뷰 페이지 반환하기
        return "articles/show";

    }
    @GetMapping("/articles")
    public String index(Model model) {
        //DB에서 모든데이터 가져오기 -단일 목록이랑 다른점:리스트로 가져옴
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //가져온 데이터 묶음을 모델에 등록
        model.addAttribute("articleList", articleEntityList);
        //사용자에게 보여줄 뷰 페이지 설정

        return"articles/index";

    }
}


