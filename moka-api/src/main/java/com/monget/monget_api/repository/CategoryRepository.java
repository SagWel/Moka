package com.moka.moka_api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
