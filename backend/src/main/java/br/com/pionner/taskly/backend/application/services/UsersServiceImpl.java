package br.com.pionner.taskly.backend.application.services;

import br.com.pionner.taskly.backend.domain.exceptions.UserAlreadyExistsInDB;
import br.com.pionner.taskly.backend.domain.exceptions.UserNotFoundException;
import br.com.pionner.taskly.backend.domain.models.Users;
import br.com.pionner.taskly.backend.domain.models.dtos.CreateUpdateUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDTO;
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
    public UsersDTO create(CreateUpdateUserDTO signupDto) {
        usersRepository.findByEmail(signupDto.email()).ifPresent(user -> {
            throw new UserAlreadyExistsInDB("Email already exists");
        });

        Users user = usersMapper.toEntity(signupDto);

        user = usersRepository.save(user);

        return usersMapper.toDto(user);
    }

    @Override
    public UsersDTO update(CreateUpdateUserDTO updateDTO, String email) {
        Users toUpdate = usersRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        toUpdate = usersMapper.partialUpdate(toUpdate, updateDTO);
        toUpdate = usersRepository.save(toUpdate);

        return usersMapper.toDto(toUpdate);
    }

    @Override
    public UsersDTO list(String email) {
        return (usersMapper.toDto(
                usersRepository.findByEmail(email).orElseThrow(UserNotFoundException::new)
        ));
    }

    @Override
    public List<UsersDTO> listAll() {
        return usersMapper.toDto(usersRepository.findAll());
    }

    @Override
    public void delete(String email) {
        Users user = usersRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);

        usersRepository.delete(user);
        log.info("User {} deleted", email);
    }
}
