package br.com.pionner.taskly.backend.application.controllers;

import br.com.pionner.taskly.backend.domain.models.dtos.CreateUpdateUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDTO;
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
    public ResponseEntity<UsersDTO> signup(CreateUpdateUserDTO signupDto) {
        return new ResponseEntity<>(usersService.create(signupDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UsersDTO> update(CreateUpdateUserDTO signupDto, String email) {
        return new ResponseEntity<>(usersService.update(signupDto, email), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UsersDTO> list(String email) {
        return new ResponseEntity<>(usersService.list(email), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UsersDTO>> listAll() {
        return new ResponseEntity<>(usersService.listAll(), HttpStatus.OK);
    }

    @Override
    public HttpStatus delete(String email) {
        usersService.delete(email);
        return HttpStatus.OK;
    }
}
