package com.parcialdoscapas.parcialcapas.repositories;

import com.parcialdoscapas.parcialcapas.entities.Author;
import com.parcialdoscapas.parcialcapas.entities.Book;
import com.parcialdoscapas.parcialcapas.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    public List<Book> findAllByAuthor(Author author);

    public List<Book> findAllByGenre(Gender gender);

    //Buscar todods los libros de un autor por nombre completo
    @Query("SELECT b FROM Book b WHERE b.language = :Language")
    List<Book> findBooksByLanguage(@Param("language") String Language);

    List<Book> findByIsbn(String isbn);


}
