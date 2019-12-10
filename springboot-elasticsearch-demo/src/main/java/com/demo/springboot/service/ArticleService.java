package com.demo.springboot.service;

import com.demo.springboot.bean.Article;
import com.demo.springboot.repository.ArticleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    @NonNull private ArticleRepository articleRepository;

    public void save() {
        articleRepository.save(new Article(1, "Leo", "J", "Hello"));
    }
}
