# Spring Boot 게시판 프로젝트

이 프로젝트는 Spring Boot를 이용한 간단한 게시판 애플리케이션입니다. 사용자는 게시글을 작성, 조회, 수정, 삭제할 수 있습니다. 학습 목적으로 작성된 프로젝트로, Spring Boot의 주요 기능을 익히는 데 중점을 두었습니다.

## 주요 기능 (Key Features)
- **CRUD 기능**: 게시글 작성(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능 구현
- **MySQL 연동**: MySQL 데이터베이스를 활용한 데이터 저장 및 관리
- **Thymeleaf 템플릿 엔진**: HTML 페이지를 동적으로 렌더링
- **Spring Security** (선택사항): 사용자 인증 및 권한 부여 기능

## 프로젝트 구조 (Project Structure)

src/
├── main/
│   ├── java/                # 주요 비즈니스 로직
│   └── resources/           
│       ├── templates/       # Mustache 템플릿 파일
│      
└── test/                    # 테스트 코드


## 기술 스택 (Tech Stack)
- **Back-end**: Spring Boot, MySQL
- **Front-end**: Mustache, HTML, CSS
- **Build Tool**: Gradle (Groovy)
- **Version Control**: Git & GitHub

## 학습 내용 (Learning Points)
- **Spring Boot**를 사용하여 간단한 웹 애플리케이션을 구축하는 방법
- **RESTful API** 설계 및 구현
- **Spring Data JPA**를 통한 데이터베이스 연동
- **테스트 코드 작성** 및 **TDD**(Test-Driven Development) 방식으로 개발
