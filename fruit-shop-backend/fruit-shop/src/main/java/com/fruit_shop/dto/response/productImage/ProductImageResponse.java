package com.fruit_shop.dto.response.productImage;

import com.fruit_shop.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageResponse {
    private long id;
    private long productId;
    private String imageUrl;

    public static ProductImageResponse toProductImageResponse(ProductImage productImage){
        return ProductImageResponse.builder()
                .id(productImage.getId())
                .productId(productImage.getId())
                .imageUrl(productImage.getImageUrl())
                .build();
    }
}
