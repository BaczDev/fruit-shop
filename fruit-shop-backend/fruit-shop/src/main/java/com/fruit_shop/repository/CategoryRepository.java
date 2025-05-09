package com.fruit_shop.repository;

import com.fruit_shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("Select c from Category c where c.enable = true")
    List<Category> findAllByEnable();

    boolean existsByName(String name);
}
