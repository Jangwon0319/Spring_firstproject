package com.example.firstproject.dto;

import com.example.firstproject.entitiy.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;            // id 필드 추가
    private String title;       // 제목을 받을 필드
    private String content;     // 내용을 받을 필드

    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가(우클릭 -> Generate -> Constructor : 자동으로 생성자 추가)
    /*
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
     */
    /*
    // 데이터를 잘 받앗는지 toString() 메서드 추가
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

     */

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
