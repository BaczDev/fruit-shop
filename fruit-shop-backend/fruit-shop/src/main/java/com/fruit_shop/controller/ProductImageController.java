package com.fruit_shop.controller;

import com.fruit_shop.dto.response.ApiResponse;
import com.fruit_shop.dto.response.productImage.ProductImageResponse;
import com.fruit_shop.service.impl.ProductImageService;
import com.fruit_shop.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productImage")
@Slf4j
@RequiredArgsConstructor
public class ProductImageController {

    private final ProductImageService productImageService;

    @PostMapping("/upload/{productId}")
    public ApiResponse<String> uploadProductImage(@PathVariable Long productId, @RequestParam("files") MultipartFile file){
        return ApiResponse.<String>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productImageService.uploadProductImage(productId, file))
                .build();
    }
    @DeleteMapping("/delete/{productImageId}")
    public String deleteImage(@PathVariable long productImageId){
        productImageService.deleteImage(productImageId);
        return "deleted product image with id= "+ productImageId;
    }


    @GetMapping("/getAll/{productId}")
    public ApiResponse<List<ProductImageResponse>> getAllImageByProductId(@PathVariable long productId){
        return ApiResponse.<List<ProductImageResponse>>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productImageService.getAllImageByProductId(productId))
                .build();
    }

    @GetMapping("/{productImageId}")
    public ApiResponse<ProductImageResponse> getImageByProductImageId(@PathVariable long productImageId){
        return ApiResponse.<ProductImageResponse>builder()
                .success(true)
                .errorCode(0)
                .errorMessage("")
                .data(productImageService.getImageByProductImageId(productImageId))
                .build();
    }
}
