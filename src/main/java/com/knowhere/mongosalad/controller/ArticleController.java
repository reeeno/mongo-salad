package com.knowhere.mongosalad.controller;

import com.knowhere.mongosalad.dao.ArticleRepository;
import com.knowhere.mongosalad.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Article> add(@RequestBody List<Article> articles) {
        List<Article> response = new ArrayList<>();
        articles.forEach((article) -> response.add(articleRepository.save(article)));
        return response;
    }

}
