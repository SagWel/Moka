package com.moka.moka_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
        @NotBlank(message = "L'email est obligatoire") @Email(message = "Format d'email invalide") String email,

        @NotBlank(message = "Le mot de passe est obligatoire") @Size(min = 8, message = "Le mot de passe doit faire au moins 8 caractères") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!._-]).*$", message = "Le mot de passe doit contenir au moins une majuscule, une minuscule, un chiffre et un caractère spécial") String password,

        @NotBlank(message = "Le nom d'utilisateur est obligatoire") String username) {

}
