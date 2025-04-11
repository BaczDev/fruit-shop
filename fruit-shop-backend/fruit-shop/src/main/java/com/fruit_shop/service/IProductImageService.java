package com.fruit_shop.service;

import com.fruit_shop.dto.response.productImage.ProductImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductImageService {
    String uploadProductImage(Long productId, MultipartFile file);
    void deleteImage(long productImageId);
    List<ProductImageResponse> getAllImageByProductId(long productId);
    ProductImageResponse getImageByProductImageId(long productImageId);
}
