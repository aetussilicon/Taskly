package br.com.pionner.taskly.backend.domain.ports.services;

import br.com.pionner.taskly.backend.domain.models.dtos.SignupUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDto;

import java.util.List;

public interface UsersService {

    UsersDto create(SignupUserDTO signupDto);
    UsersDto update(SignupUserDTO signupDto);
    UsersDto list(String email);
    List<UsersDto> listAll();
    void delete(String email);
}
