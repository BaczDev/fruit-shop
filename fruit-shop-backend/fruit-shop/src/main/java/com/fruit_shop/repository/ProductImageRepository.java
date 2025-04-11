package com.fruit_shop.repository;

import com.fruit_shop.dto.response.productImage.ProductImageResponse;
import com.fruit_shop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> getAllImageByProductId(Long productId);
}
