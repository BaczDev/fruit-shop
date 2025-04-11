package com.fruit_shop.service.impl;

import com.fruit_shop.dto.request.product.ProductRequest;
import com.fruit_shop.dto.response.product.ProductResponse;
import com.fruit_shop.entity.Category;
import com.fruit_shop.entity.Product;
import com.fruit_shop.exception.AppException;
import com.fruit_shop.exception.ErrorCode;
import com.fruit_shop.repository.CategoryRepository;
import com.fruit_shop.repository.ProductRepository;
import com.fruit_shop.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Category existingCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow(() ->
                new AppException(ErrorCode.CATEGORY_NOT_FOUND));

        if(productRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }

        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setPrice(request.getPrice());
        newProduct.setQuantity(request.getQuantity());
        newProduct.setCategory(existingCategory);
        productRepository.save(newProduct);
        return ProductResponse.toProductResponse(newProduct);
    }

    @Override
    public ProductResponse updateProduct(long id, ProductRequest request) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        Category existingCategory = categoryRepository.findById(request.getCategoryId()).orElseThrow(() ->
                new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setQuantity(request.getQuantity());
        existingProduct.setCategory(existingCategory);
        productRepository.save(existingProduct);
        return ProductResponse.toProductResponse(existingProduct);
    }

    @Override
    public void deleteProduct(long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponse getProductById(long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        return ProductResponse.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll().stream()
                .map(ProductResponse::toProductResponse)
                .toList();

    }

    @Override
    public List<ProductResponse> getListNew(int number) {
        return productRepository.getListNew(number).stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getListByPrice() {
        return productRepository.getListByPrice().stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> findRelatedProduct(long categoryId) {
        return productRepository.findRelatedProduct(categoryId).stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getAllProductByCategoryId(long categoryId) {
        return productRepository.getAllProductByCategoryId(categoryId).stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> getProductByPriceRange(long categoryId, int min, int max) {
        return productRepository.getProductByPriceRange(categoryId, min, max).stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }

    @Override
    public List<ProductResponse> searchProduct(String keyword) {
        return productRepository.searchProduct(keyword).stream()
                .map(ProductResponse::toProductResponse)
                .toList();
    }
}
