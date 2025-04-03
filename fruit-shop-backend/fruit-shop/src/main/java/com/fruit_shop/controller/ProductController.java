package com.fruit_shop.controller;

import com.fruit_shop.dto.request.product.ProductRequest;
import com.fruit_shop.dto.response.ApiResponse;
import com.fruit_shop.dto.response.product.ProductResponse;
import com.fruit_shop.service.impl.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ApiResponse<ProductResponse> createProduct(@RequestBody @Valid ProductRequest request){
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.createProduct(request))
                .build();
    }

    @PutMapping("/update/{id}")
    public ApiResponse<ProductResponse> updateProduct(@RequestBody @Valid ProductRequest request, @PathVariable long id){
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.updateProduct(id, request))
                .build();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return "deleted product with id= "+id;
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getProductById(@PathVariable long id){
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getProductById(id))
                .build();
    }

    @GetMapping("")
    public ApiResponse<List<ProductResponse>> getAllProduct(){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getAllProduct())
                .build();
    }

    @GetMapping("/new/{number}")
    public ApiResponse<List<ProductResponse>> getNewList(@PathVariable int number){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getListNew(number))
                .build();
    }

    @GetMapping("/price")
    public ApiResponse<List<ProductResponse>> getListByPrice(){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getListByPrice())
                .build();
    }

    @GetMapping("/related/{categoryId}")
    public ApiResponse<List<ProductResponse>> findRelatedProduct(@PathVariable long categoryId){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.findRelatedProduct(categoryId))
                .build();
    }

    @GetMapping("/category/{categoryId}")
    public ApiResponse<List<ProductResponse>> getAllProductByCategoryId(@PathVariable long categoryId){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getAllProductByCategoryId(categoryId))
                .build();
    }

    @GetMapping("/range")
    public ApiResponse<List<ProductResponse>> getProductByPriceRange(
            @RequestParam("categoryId") long categoryId,
            @RequestParam("min") int min,
            @RequestParam("max") int max){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.getProductByPriceRange(categoryId, min, max))
                .build();
    }

    @GetMapping("/search")
    public ApiResponse<List<ProductResponse>> searchProduct(@RequestParam("keyword") String keyword){
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productService.searchProduct(keyword))
                .build();
    }
}
