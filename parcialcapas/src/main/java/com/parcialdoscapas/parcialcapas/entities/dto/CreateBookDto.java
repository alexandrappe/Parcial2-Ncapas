package com.parcialdoscapas.parcialcapas.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDto {

    @NotNull
    private UUID authorId;

    @NotBlank
    @NotNull
    private String title;

    @NotBlank
    @NotNull
    private String isbn;

    @NotBlank
    @NotNull
    private Integer publicationYear;

    @NotBlank
    @NotNull
    private Integer pages;

    private String language;
}
