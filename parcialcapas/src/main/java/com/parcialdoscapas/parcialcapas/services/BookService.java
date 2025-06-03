package com.parcialdoscapas.parcialcapas.services;

import com.parcialdoscapas.parcialcapas.entities.Author;
import com.parcialdoscapas.parcialcapas.entities.Book;
import com.parcialdoscapas.parcialcapas.entities.Gender;
import com.parcialdoscapas.parcialcapas.entities.dto.AuthorBooksDto;
import com.parcialdoscapas.parcialcapas.entities.dto.CreateBookDto;
import com.parcialdoscapas.parcialcapas.entities.dto.GenderBooksDto;
import com.parcialdoscapas.parcialcapas.entities.dto.RegisterDto;
import com.parcialdoscapas.parcialcapas.repositories.BookRepository;
import com.parcialdoscapas.parcialcapas.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.parcialdoscapas.parcialcapas.repositories.AuthorRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenderRepository genderRepository;

    public void createBook(CreateBookDto request) {
        Optional<Author> optionalAuthor = authorRepository.findById(request.getAuthorId());
        if (optionalAuthor.isEmpty()){
            throw new RuntimeException("User not found");
        }
        Book book = new Book();
        book.setAuthor(optionalAuthor.get());
        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setPages(request.getPages());
        book.setLanguage(request.getLanguage());
        bookRepository.save(book);
    }

    public List<AuthorBooksDto> getAuthorBooks(UUID userId){
        List<AuthorBooksDto> response = new ArrayList<>();
        Optional<Author> optionalUser = authorRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        List<Book> authorBook = bookRepository.findAllByAuthor(optionalUser.get());
        authorBook.forEach(book -> {
            response.add(new AuthorBooksDto(book.getId(), book.getTitle(), book.getPublicationYear()));
        });

        return response;
    }

    public List<GenderBooksDto> getGenreBooks(UUID genreId){
        List<GenderBooksDto> response = new ArrayList<>();
        Optional<Gender> optionalGender = genderRepository.findById(genreId);
        if (optionalGender.isEmpty()){
            throw new RuntimeException("User not found");
        }
        List<Book> authorBook = bookRepository.findAllByGenre(optionalGender.get());
        authorBook.forEach(book -> {
            response.add(new GenderBooksDto(book.getId(), book.getTitle()));
        });

        return response;
    }



}
