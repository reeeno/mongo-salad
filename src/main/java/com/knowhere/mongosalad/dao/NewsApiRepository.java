package com.knowhere.mongosalad.dao;

import com.knowhere.mongosalad.model.NewsApi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsApiRepository extends MongoRepository<NewsApi, String> {
}
