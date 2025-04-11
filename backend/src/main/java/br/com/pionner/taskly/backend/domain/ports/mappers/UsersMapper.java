package br.com.pionner.taskly.backend.domain.ports.mappers;

import br.com.pionner.taskly.backend.domain.models.Users;
import br.com.pionner.taskly.backend.domain.models.dtos.SignupUserDTO;
import br.com.pionner.taskly.backend.domain.models.dtos.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {UUID.class})
public interface UsersMapper {

    @Mapping(target = "userId", expression = "java(UUID.randomUUID())")
    Users toEntity(SignupUserDTO signupDto);
    UsersDto toDto(Users user);
    List<UsersDto> toDto(List<Users> users);

}
