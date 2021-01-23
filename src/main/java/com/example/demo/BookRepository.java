package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Book;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
