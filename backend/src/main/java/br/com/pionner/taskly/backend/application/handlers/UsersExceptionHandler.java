package br.com.pionner.taskly.backend.application.handlers;

import br.com.pionner.taskly.backend.domain.exceptions.UserAlreadyExistsInDB;
import br.com.pionner.taskly.backend.domain.exceptions.UserNotFoundException;
import br.com.pionner.taskly.backend.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Not Found");
        errorResponse.setMessage(ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsInDB.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsInDB(UserAlreadyExistsInDB ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError("Conflict");
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
