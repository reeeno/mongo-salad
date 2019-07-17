package com.knowhere.mongosalad.dao;

import com.knowhere.mongosalad.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
}
