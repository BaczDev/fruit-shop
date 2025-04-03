package com.fruit_shop.repository;

import com.fruit_shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    @Query(value = "select * from products order by id desc limit :number", nativeQuery = true)
    List<Product> getListNew(int number);

    @Query(value = "select * from products order by price limit 8", nativeQuery = true)
    List<Product> getListByPrice();

    @Query(value = "select * from products where category_id = :categoryId order by rand() limit 4", nativeQuery = true)
    List<Product> findRelatedProduct(long categoryId);

    @Query(value = "select * from products where category_id = :categoryId", nativeQuery = true)
    List<Product> getAllProductByCategoryId(long categoryId);

    @Query(value = "select * from products where category_id = :categoryId and price between :min and :max", nativeQuery = true)
    List<Product> getProductByPriceRange(long categoryId, int min, int max);

    @Query(value= "Select p from Product p where p.name like %:keyword% order by id desc")
    List<Product> searchProduct(String keyword);
}
