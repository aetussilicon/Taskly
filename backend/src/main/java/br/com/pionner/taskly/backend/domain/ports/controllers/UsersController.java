package br.com.pionner.taskly.backend.domain.ports.controllers;

import br.com.pionner.taskly.backend.domain.models.dtos.SignupUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UsersController {

    @PostMapping("signup")
    ResponseEntity<UsersDto> signup(@RequestBody @Valid SignupUserDTO signupDto);

    @PatchMapping("update")
    ResponseEntity<UsersDto> update(@RequestBody @Valid SignupUserDTO signupDto);

    @GetMapping
    ResponseEntity<UsersDto> list(@RequestParam String email);

    @GetMapping("all")
    ResponseEntity<List<UsersDto>> listAll();

    @DeleteMapping("delete/{userId}")
    ResponseEntity<Void> delete(@PathVariable UUID userId);
}
