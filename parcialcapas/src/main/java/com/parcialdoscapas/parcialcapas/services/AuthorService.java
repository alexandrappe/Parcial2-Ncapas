package com.parcialdoscapas.parcialcapas.services;

import com.parcialdoscapas.parcialcapas.entities.Author;
import com.parcialdoscapas.parcialcapas.entities.dto.RegisterDto;
import com.parcialdoscapas.parcialcapas.repositories.AuthorRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void createUser(RegisterDto userInfo) {
        Author author = new Author();
        author.setName(userInfo.getName());
        authorRepository.save(author);
    }

}
