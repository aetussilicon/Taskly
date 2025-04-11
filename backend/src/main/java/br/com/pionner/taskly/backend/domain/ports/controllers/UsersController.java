package br.com.pionner.taskly.backend.domain.ports.controllers;

import br.com.pionner.taskly.backend.domain.models.dtos.CreateUpdateUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface UsersController {

    @PostMapping("signup")
    ResponseEntity<UsersDTO> signup(@RequestBody @Valid CreateUpdateUserDTO signupDto);

    @PatchMapping("update/{email}")
    ResponseEntity<UsersDTO> update(@RequestBody @Valid CreateUpdateUserDTO updateDTO, @PathVariable String email);

    @GetMapping
    ResponseEntity<UsersDTO> list(@RequestParam String email);

    @GetMapping("all")
    ResponseEntity<List<UsersDTO>> listAll();

    @DeleteMapping("delete/{email}")
    HttpStatus delete(@PathVariable String email);
}
