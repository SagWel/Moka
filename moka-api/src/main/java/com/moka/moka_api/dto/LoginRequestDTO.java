package com.moka.moka_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
                @NotBlank(message = "email obligatoire") @Email(message = "Format d'email invalide") String email,

                @NotBlank(message = "mot de passe obligatoire") String password) {

}
