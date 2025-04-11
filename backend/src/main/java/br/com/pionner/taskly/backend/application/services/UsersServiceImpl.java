package br.com.pionner.taskly.backend.application.services;

import br.com.pionner.taskly.backend.domain.models.Users;
import br.com.pionner.taskly.backend.domain.models.dtos.SignupUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDto;
import br.com.pionner.taskly.backend.domain.ports.mappers.UsersMapper;
import br.com.pionner.taskly.backend.domain.ports.repositories.UsersRepository;
import br.com.pionner.taskly.backend.domain.ports.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Override
    public UsersDto create(SignupUserDTO signupDto) {
        usersRepository.findByEmail(signupDto.email()).ifPresent(user -> {
            throw new RuntimeException("Email already exists");
        });

        Users user = usersMapper.toEntity(signupDto);

        user = usersRepository.save(user);

        return usersMapper.toDto(user);
    }

    @Override
    public UsersDto update(SignupUserDTO signupDto) {
        return null;
    }

    @Override
    public UsersDto list(String email) {
        return null;
    }

    @Override
    public List<UsersDto> listAll() {
        return List.of();
    }

    @Override
    public void delete(String email) {

    }
}
