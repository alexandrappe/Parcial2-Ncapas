package com.parcialdoscapas.parcialcapas.controllers;

import com.parcialdoscapas.parcialcapas.entities.Author;
import com.parcialdoscapas.parcialcapas.entities.dto.AuthorBooksDto;
import com.parcialdoscapas.parcialcapas.entities.dto.RegisterDto;
import com.parcialdoscapas.parcialcapas.services.AuthorService;
import com.parcialdoscapas.parcialcapas.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    private Pattern UUID_REGEX =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    @PostMapping("/register")
    public ResponseEntity<Void> createAuthor(@RequestBody @Valid RegisterDto info){
        try {
            authorService.createUser(info);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    
}
