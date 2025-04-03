package com.fruit_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    private String name;

    private long price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
