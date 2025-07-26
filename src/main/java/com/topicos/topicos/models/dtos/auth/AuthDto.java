package com.topicos.topicos.models.dtos.auth;

import jakarta.validation.constraints.NotBlank;


public record AuthDto(
                 String email,
                @NotBlank String password) {

}
