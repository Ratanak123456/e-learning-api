package co.istad.ratanak.elearningapi.features.category.service;

import co.istad.ratanak.elearningapi.features.category.dto.CategoryRequest;
import co.istad.ratanak.elearningapi.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryResponse> getAllCategories(int page, int size);
    CategoryResponse getCategoryById(Integer id);
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategoryById(Integer id, CategoryRequest request);
    void deleteCategoryById(Integer id);
}