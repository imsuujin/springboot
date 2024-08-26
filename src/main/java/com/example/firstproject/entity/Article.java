package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor  //생성자
@ToString
@Entity    //엔티티선언
@NoArgsConstructor  //기본 생성자 추가
@Getter  //saved.getId()가져오려고
public class Article  {
    @Id //엔티티 대푯값 지정
    @GeneratedValue  //자동생성 기능추가(숫자가 자동으로 매겨짐)
    private Long id;
    @Column //title필드 선언, 데이터베이스 테이블의 title 열과 연결
    private String title;
    @Column //title필드 선언, 데이터베이스 테이블의 content 열과 연결
    private String content;

    //Article생성자 추가
//    public Article(Long id, String title, String content) {
//        this.id = id;
//        this.title = title;
//        this.content = content;
//    }
//
//
//
//    //toString()메서드 추가
//    @Override
//    public String toString() {
//        return "Article{"+
//                "id="+id +
//                ", title='"+title+'\''+
//                ", content='"+content +'\''+
//                '}';
//    }

}
