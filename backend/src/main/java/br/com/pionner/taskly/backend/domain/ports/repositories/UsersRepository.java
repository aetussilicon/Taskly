package br.com.pionner.taskly.backend.domain.ports.repositories;

import br.com.pionner.taskly.backend.domain.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);
}
