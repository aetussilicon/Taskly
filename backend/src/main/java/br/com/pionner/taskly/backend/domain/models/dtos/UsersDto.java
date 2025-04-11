package br.com.pionner.taskly.backend.domain.models.dtos;

import java.sql.Timestamp;
import java.util.UUID;

public record UsersDto(UUID userId, String name, String surname, String email, Timestamp createdAt, Timestamp updatedAt) {
}
