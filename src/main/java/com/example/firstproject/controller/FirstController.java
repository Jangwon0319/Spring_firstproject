package com.example.firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;                            // Model 클래스 패키지 자동 임포트
import org.springframework.web.bind.annotation.GetMapping;      // URL 연결 요청(@GetMapping())과 동시에 자동으로 임포트

@Controller         // 컨트롤러임을 선언

public class FirstController {
    
    // 메서드 작성
    @GetMapping("/hi")          // 
    public String niceToMeetYou(Model model) {      // model 객체 받아 오기
        // model.addAttribute("변수명", 변숫값) 메서드 : 변숫값을 "변수명"이라는 이름으로 추가
        // model 객체가 "홍팍" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username", "hongpark");
        return "greetings";         // greetings.mustache 파일 반환
    }

    // 메서드 작성
    @GetMapping("/bye")
    public String seeYouNext(Model model){          // model 객체 받아 오기
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
