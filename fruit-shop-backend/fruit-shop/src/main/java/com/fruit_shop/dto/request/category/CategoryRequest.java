package com.fruit_shop.dto.request.category;

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
public class CategoryRequest {
    @NotNull(message = "CATEGORY_IS_EMPTY")
    @NotEmpty(message = "CATEGORY_IS_EMPTY")
    @Size(min=5,max=50,message="WRONG_SIZE_CATEGORY")
    private String name;
}
