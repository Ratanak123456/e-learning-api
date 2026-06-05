package co.istad.ratanak.elearningapi.features.category.mapper;

import co.istad.ratanak.elearningapi.features.category.domain.Category;
import co.istad.ratanak.elearningapi.features.category.dto.CategoryRequest;
import co.istad.ratanak.elearningapi.features.category.dto.CategoryResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toResponse(Category category);

    Category toEntity(CategoryRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(CategoryRequest request, @MappingTarget Category category);
}