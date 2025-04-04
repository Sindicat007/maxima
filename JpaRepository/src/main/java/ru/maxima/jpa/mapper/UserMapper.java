package ru.maxima.jpa.mapper;

import org.mapstruct.Mapper;
import ru.maxima.jpa.dto.UserDTO;
import ru.maxima.jpa.entity.UserEntity;

/*
 * Маппер для пользователями
 *
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(UserEntity userEntity);

    UserEntity toEntity(UserDTO userDTO);
}
