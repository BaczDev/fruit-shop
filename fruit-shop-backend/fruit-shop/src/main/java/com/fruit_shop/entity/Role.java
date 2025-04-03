package com.fruit_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "roles")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
