package com.parcialdoscapas.parcialcapas.entities.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterDto {

    @NotBlank
    @NotNull
    private String name;
}
