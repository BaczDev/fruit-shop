package com.fruit_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categories")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean enable;

    private String name;
}
