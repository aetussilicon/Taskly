package br.com.pionner.taskly.backend.domain.models.dtos;

public record CreateUpdateUserDTO(String email, String password, String name, String surname) {
}
