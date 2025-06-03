package com.parcialdoscapas.parcialcapas.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class AuthorBooksDto {

    private UUID id;
    private String title;
    private Integer year;
}
