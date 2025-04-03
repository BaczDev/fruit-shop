package com.fruit_shop.service.impl;

import com.fruit_shop.dto.request.category.CategoryRequest;
import com.fruit_shop.dto.response.category.CategoryResponse;
import com.fruit_shop.entity.Category;
import com.fruit_shop.exception.AppException;
import com.fruit_shop.exception.ErrorCode;
import com.fruit_shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements com.fruit_shop.service.CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(CategoryResponse::toCategoryResponse)
                .toList();
    }

    @Override
    public List<CategoryResponse> getCategoryEnable() {
        List<Category> categories = categoryRepository.findAllByEnable();
        return categories.stream()
                .map(CategoryResponse::toCategoryResponse)
                .toList();
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        if(categoryRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.CATEGORY_EXISTED);
        }
        Category newCategory = new Category();
        newCategory.setName(request.getName());
        newCategory.setEnable(false);
        categoryRepository.save(newCategory);
        CategoryResponse response = CategoryResponse.toCategoryResponse(newCategory);
        return response;
    }

    @Override
    public CategoryResponse updateCategory(long id, CategoryRequest request) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        existingCategory.setName(request.getName());
        categoryRepository.save(existingCategory);
        CategoryResponse response = CategoryResponse.toCategoryResponse(existingCategory);
        return response;
    }

    @Override
    public void enableCategory(long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        if(existingCategory.isEnable()){
            existingCategory.setEnable(false);
        }else {
            existingCategory.setEnable(true);
        }
        categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryRepository.deleteById(id);
    }
}
