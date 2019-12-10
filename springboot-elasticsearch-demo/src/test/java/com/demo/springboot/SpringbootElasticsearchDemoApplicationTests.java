package com.demo.springboot;

import com.demo.springboot.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootElasticsearchDemoApplicationTests {

//    @Autowired
//    JestClient jestClient;

    @Autowired
    ArticleService articleService;

    @Test
    void save() {
        articleService.save();
//        val article = new Article(1, "Good News", "Leo", "Hello World");
//        val index = new Index.Builder(article)
//                .index("demo")
//                .type("news")
//                .build();
//        try {
//            val result = jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void search() {
//        new Search.Builder()
    }

}
