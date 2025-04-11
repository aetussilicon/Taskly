package br.com.pionner.taskly.backend.domain.exceptions;

public class UserAlreadyExistsInDB extends RuntimeException {
    public UserAlreadyExistsInDB(String message) {
        super(message);
    }
}
