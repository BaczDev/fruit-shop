package com.fruit_shop.controller;

import com.fruit_shop.dto.request.category.CategoryRequest;
import com.fruit_shop.dto.response.ApiResponse;
import com.fruit_shop.dto.response.category.CategoryResponse;
import com.fruit_shop.service.impl.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("")
    public ApiResponse<List<CategoryResponse>> getAllCategory(){
        return ApiResponse.<List<CategoryResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(categoryService.getAllCategory())
                .build();
    }

    @GetMapping("/enable")
    public ApiResponse<List<CategoryResponse>> getCategoryEnable(){
        return ApiResponse.<List<CategoryResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(categoryService.getCategoryEnable())
                .build();
    }

    @PostMapping("/create")
    public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest request){
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(categoryService.createCategory(request))
                .build();
    }

    @PutMapping("/update/{id}")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable long id, @RequestBody @Valid CategoryRequest request){
        return ApiResponse.<CategoryResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(categoryService.updateCategory(id, request))
                .build();
    }

    @PutMapping("/enable/{id}")
    public String enableCategory(@PathVariable long id){
        categoryService.enableCategory(id);
        return "enable category successfully with id: "+id;
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return "deleted category with id: "+id;
    }

}
