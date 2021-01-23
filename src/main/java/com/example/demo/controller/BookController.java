package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BookRepository;

import static com.example.demo.model.Book.*;

import com.example.demo.model.Book;
import com.example.demo.service.SequenceGeneratorService;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/saveBook")
	public Book save(@RequestBody Book book) {
		// generate sequence
		book.setId(service.getSequenceNumber(SEQUENCE_NAME));
		return repository.save(book);
	}

	@GetMapping("/books")
	public List<Book> getBooks() {
		return repository.findAll();
	}
}
