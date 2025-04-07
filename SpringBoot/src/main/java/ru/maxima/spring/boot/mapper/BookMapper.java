package ru.maxima.spring.boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.maxima.spring.boot.dto.BookDto;
import ru.maxima.spring.boot.entity.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(BookEntity bookEntity);

    @Mapping(target = "id", ignore = true)
    BookEntity toBookEntity(BookDto bookDto);
}
