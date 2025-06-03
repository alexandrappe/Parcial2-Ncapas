package com.parcialdoscapas.parcialcapas.controllers;

import com.parcialdoscapas.parcialcapas.entities.Book;
import com.parcialdoscapas.parcialcapas.entities.dto.CreateBookDto;
import com.parcialdoscapas.parcialcapas.repositories.BookRepository;
import com.parcialdoscapas.parcialcapas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody CreateBookDto request){
        bookService.createBook(request);
        return ResponseEntity.noContent().build();
    }

    //Buscar libro por titulo (ejemplo: /books/search/by-title?title=IT)
    @GetMapping("/language")
    public ResponseEntity<Void> getByTitle(@RequestParam String title) {
        List<Book> books = bookRepository.findBooksByLanguage(title);
        if (books.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}

