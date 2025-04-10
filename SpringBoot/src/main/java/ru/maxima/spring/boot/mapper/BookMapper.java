package ru.maxima.spring.boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.maxima.spring.boot.dto.BookDto;
import ru.maxima.spring.boot.entity.BookEntity;

/*
 * Маппер для преобразования объектов между двумя различными моделями данных.
 *
 * @author Sindicat
 */
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(BookEntity bookEntity);

    @Mapping(target = "id", ignore = true)
    BookEntity toBookEntity(BookDto bookDto);
}
