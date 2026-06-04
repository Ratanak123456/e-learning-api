package co.istad.ratanak.elearningapi.features.category;

import co.istad.ratanak.elearningapi.features.category.dto.CategoryRequest;
import co.istad.ratanak.elearningapi.features.category.dto.CategoryResponse;
import co.istad.ratanak.elearningapi.features.category.mapper.CategoryMapper;
import co.istad.ratanak.elearningapi.global.exception.ResourceAlreadyExistsException;
import co.istad.ratanak.elearningapi.global.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplement implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return categoryRepository.findAll(pageRequest)
                .map(categoryMapper::toResponse);
    }

    @Override
    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        if (categoryRepository.existsByName(request.name())) {
            throw new ResourceAlreadyExistsException("Category", request.name());
        }
        Category category = categoryMapper.toEntity(request);
        category.setIsDeleted(false);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategoryById(Integer id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        categoryMapper.updateEntityFromRequest(request, category);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
        // Soft delete
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }
}