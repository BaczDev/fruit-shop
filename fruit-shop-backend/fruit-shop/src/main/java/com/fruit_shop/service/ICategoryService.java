package com.fruit_shop.service;

import com.fruit_shop.dto.request.category.CategoryRequest;
import com.fruit_shop.dto.response.category.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategory();
    List<CategoryResponse> getCategoryEnable();
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(long id, CategoryRequest request);
    void enableCategory(long id);
    void deleteCategory(long id);
}
