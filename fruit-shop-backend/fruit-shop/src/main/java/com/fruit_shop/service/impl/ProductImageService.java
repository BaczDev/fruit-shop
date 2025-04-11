package com.fruit_shop.service.impl;

import com.fruit_shop.dto.response.productImage.ProductImageResponse;
import com.fruit_shop.entity.Product;
import com.fruit_shop.entity.ProductImage;
import com.fruit_shop.exception.AppException;
import com.fruit_shop.exception.ErrorCode;
import com.fruit_shop.repository.ProductImageRepository;
import com.fruit_shop.repository.ProductRepository;
import com.fruit_shop.service.IProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImageService implements IProductImageService {
    private final CloudinaryService cloudinaryService;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    public String uploadProductImage(Long productId, MultipartFile file) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        try{
            // Kiểm tra nếu file null hoặc rỗng
            if(file == null || file.isEmpty()){
                throw new AppException(ErrorCode.FILE_IS_NULL);
            }
            // Kiểm tra kích thước file (tối đa 10MB)
            if (file.getSize() > 10 * 1024 * 1024) {
                throw new AppException(ErrorCode.FILE_TOO_LARGE);
            }
            // Kiểm tra định dạng file
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                throw new AppException(ErrorCode.INVALID_FILE_FORMAT);
            }

            // Sử dụng dịch vụ upload file lên Cloudinary
            String fileUrl = cloudinaryService.upload(file);

            // Cập nhật thông tin anh cua san pham trong database
            ProductImage productImage = new ProductImage();
            productImage.setImageUrl(fileUrl);
            productImage.setProduct(existingProduct);
            productImageRepository.save(productImage);
            return fileUrl;
        }catch (IOException e){
            throw new AppException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    @Override
    public void deleteImage(long productImageId) {
        ProductImage existingProductImage = productImageRepository.findById(productImageId).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_IMAGE_NOT_FOUND));
        productImageRepository.deleteById(productImageId);
    }

    @Override
    public List<ProductImageResponse> getAllImageByProductId(long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        List<ProductImage> list = productImageRepository.getAllImageByProductId(productId);
        return list.stream()
                .map(ProductImageResponse::toProductImageResponse)
                .toList();

    }

    @Override
    public ProductImageResponse getImageByProductImageId(long productImageId) {
        ProductImage existingProductImage = productImageRepository.findById(productImageId).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_IMAGE_NOT_FOUND));
        return ProductImageResponse.toProductImageResponse(existingProductImage);
    }
}
