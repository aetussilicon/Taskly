package br.com.pionner.taskly.backend.domain.ports.services;

import br.com.pionner.taskly.backend.domain.models.dtos.CreateUpdateUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDTO;

import java.util.List;

public interface UsersService {

    UsersDTO create(CreateUpdateUserDTO signupDto);
    UsersDTO update(CreateUpdateUserDTO updateDTO, String email);
    UsersDTO list(String email);
    List<UsersDTO> listAll();
    void delete(String email);
}
