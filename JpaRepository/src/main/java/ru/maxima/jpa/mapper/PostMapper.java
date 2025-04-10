package ru.maxima.jpa.mapper;

import org.mapstruct.Mapper;
import ru.maxima.jpa.dto.PostDTO;
import ru.maxima.jpa.entity.PostEntity;

/*
 * Маппер для постов
 *
 */
@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toDto(PostEntity postEntity);

    PostEntity toEntity(PostDTO postDTO);

}
