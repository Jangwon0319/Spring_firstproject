package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entitiy.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j            // 로그를 찍을 수 있게 어노테이션 추가
@RestController     // REST 컨트롤러 선언

public class ArticleApiController {

    @Autowired          // 게시글 리파지터리 주입
    private ArticleService articleService;      // 서비스 객체 주입


    // GET(조회)
    // 모든 게시글 조회하기
    @GetMapping("/api/articles")
    public List<Article> index() {
        // return articleRepository.findAll();
        return articleService.index();
    }
    // 단일 게시글 조회하기
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {                     // URL의 id를 매개변수로 받아 오기
       // return articleRepository.findById(id).orElse(null);
        return articleService.show(id);
    }


    // POST (데이터 생성 요청)
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){            // dto 매개변수로 받아 오기
//        Article article = dto.toEntity();                           // dto를 DB에 활용할 수 있도록 엔티티로 변환
//        return articleRepository.save(article);                     // DB에 저장 후 반환

        Article created = articleService.create(dto);
        return (created != null) ?      // 생성하면 정상, 실패하면 오류 정답
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    // PATCH(데이터 수정 요청)
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){     // 2번까지는 반환형이 Article
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    // DELETE(데이터 삭제 요청)
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
    // 여러 게시글 생성 요청 함수
    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }


}
