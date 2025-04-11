package br.com.pionner.taskly.backend.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    String error;
    String message;
}
