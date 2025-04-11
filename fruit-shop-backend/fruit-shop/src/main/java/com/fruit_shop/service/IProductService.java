package com.fruit_shop.service;

import com.fruit_shop.dto.request.product.ProductRequest;
import com.fruit_shop.dto.response.product.ProductResponse;

import java.util.List;

public interface IProductService {
    //tao san pham moi
    ProductResponse createProduct(ProductRequest request);

    //cap nhat san pham
    ProductResponse updateProduct(long id, ProductRequest request);

    //xoa san pham
    void deleteProduct(long id);

    //lay san pham bang id
    ProductResponse getProductById(long id);

    //lay toan bo san pham
    List<ProductResponse> getAllProduct();

    //lay ra list san pham moi nhat
    List<ProductResponse> getListNew(int number);

    //lay 8 san pham theo gia tu thap den cao
    List<ProductResponse> getListByPrice();

    //lay ngau nhien 4 sp cung danh muc
    List<ProductResponse> findRelatedProduct(long categoryId);

    //lay all sp cung danh muc
    List<ProductResponse> getAllProductByCategoryId(long categoryId);

    //loc sp theo gia
    List<ProductResponse> getProductByPriceRange(long categoryId, int min, int max);

    //tim kiem sp
    List<ProductResponse> searchProduct(String keyword);

}
