package br.com.pionner.taskly.backend.application.controllers;

import br.com.pionner.taskly.backend.domain.models.dtos.SignupUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDto;
import br.com.pionner.taskly.backend.domain.ports.controllers.UsersController;
import br.com.pionner.taskly.backend.domain.ports.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersController {

    private final UsersService usersService;

    @Override
    public ResponseEntity<UsersDto> signup(SignupUserDTO signupDto) {
        return new ResponseEntity<>(usersService.create(signupDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UsersDto> update(SignupUserDTO signupDto) {
        return null;
    }

    @Override
    public ResponseEntity<UsersDto> list(String email) {
        return null;
    }

    @Override
    public ResponseEntity<List<UsersDto>> listAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        return null;
    }
}
