package com.fruit_shop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorCode {
    //category
    CATEGORY_IS_EMPTY(1, "Tên danh mục rỗng", HttpStatus.BAD_REQUEST),
    WRONG_SIZE_CATEGORY(2, "Tên danh mục sai kích thước(từ 5 đến 50 kí tự)", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_FOUND(3, "Không tìm thấy danh mục", HttpStatus.NOT_FOUND),
    CATEGORY_EXISTED(4, "danh mục đã tồn tại", HttpStatus.BAD_REQUEST),

    //product
    PRODUCT_EXISTED(5, "tên sản phẩm đã tồn tại", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_FOUND(6, "không tìm thấy sản phẩm", HttpStatus.BAD_REQUEST),
    PRODUCT_NAME_IS_EMPTY(7, "tên sản phẩm rỗng",HttpStatus.BAD_REQUEST),
    PRODUCT_DES_IS_EMPTY(8, "mô tả sản phẩm rỗng",HttpStatus.BAD_REQUEST),
    PRODUCT_PRICE_IS_EMPTY(9, "giá sản phẩm rỗng",HttpStatus.BAD_REQUEST),
    PRODUCT_QUANTITY_IS_EMPTY(10, "số lượng sản phẩm rỗng",HttpStatus.BAD_REQUEST),
    CATEGORY_ID_IS_EMPTY(11, "id danh mục rỗng",HttpStatus.BAD_REQUEST),

    //product image
    FILE_IS_NULL(12, "file is null", HttpStatus.BAD_REQUEST),
    FILE_TOO_LARGE(13, "File is too large! Maximum size is 10MB", HttpStatus.BAD_REQUEST),
    INVALID_FILE_FORMAT(14, "File must be an image", HttpStatus.BAD_REQUEST),
    FILE_UPLOAD_FAILED(15,"Failed to upload file", HttpStatus.BAD_REQUEST),
    PRODUCT_IMAGE_NOT_FOUND(16, "product image not found", HttpStatus.BAD_REQUEST),
    ;

    private int errorCode;
    private String errorMessage;
    private HttpStatusCode statusCode;
}
