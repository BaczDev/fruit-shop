package com.fruit_shop.dto.request.product;

import com.fruit_shop.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    @NotNull(message = "PRODUCT_NAME_IS_EMPTY")
    @NotEmpty(message="PRODUCT_NAME_IS_EMPTY")
    private String name;

    @NotNull(message = "PRODUCT_DES_IS_EMPTY")
    @NotEmpty(message="PRODUCT_DES_IS_EMPTY")
    private String description;

    @NotNull(message = "PRODUCT_PRICE_IS_EMPTY")
    private long price;

    @NotNull(message = "PRODUCT_QUANTITY_IS_EMPTY")
    private int quantity;

    @NotNull(message = "CATEGORY_ID_IS_EMPTY")
    private long categoryId;
}
