package br.com.pionner.taskly.backend.domain.ports.controllers;

import br.com.pionner.taskly.backend.domain.models.dtos.CreateUpdateUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UsersController {

    @PostMapping("signup")
    ResponseEntity<UsersDTO> signup(@RequestBody @Valid CreateUpdateUserDTO signupDto);

    @PatchMapping("update")
    ResponseEntity<UsersDTO> update(@RequestBody @Valid CreateUpdateUserDTO signupDto);

    @GetMapping
    ResponseEntity<UsersDTO> list(@RequestParam String email);

    @GetMapping("all")
    ResponseEntity<List<UsersDTO>> listAll();

    @DeleteMapping("delete/{userId}")
    ResponseEntity<Void> delete(@PathVariable UUID userId);
}
