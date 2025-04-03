package com.fruit_shop.dto.response.category;

import com.fruit_shop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private long id;
    private boolean enable;
    private String name;

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .enable(category.isEnable())
                .name(category.getName())
                .build();
    }
}
