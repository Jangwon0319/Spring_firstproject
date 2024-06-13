package com.example.firstproject.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity     // 엔티티 선언
public class Article {
    @Id                     // 엔티티의 대푯값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)        // 자동 생성 기능(숫자가 자동으로 매겨짐) + DB가 id 자동 생성
    private Long id;           
    @Column                 // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column                 // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    public Long getID() {
        return id;
    }

    // 수정할 내용이 있는 경우에만 동작, 갱신할 값이 있다면 this.{} 으로 값 갱신
    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }

    // 기본 생성자 : Article(){}

    /*
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
     */

    /*
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

     */
}
