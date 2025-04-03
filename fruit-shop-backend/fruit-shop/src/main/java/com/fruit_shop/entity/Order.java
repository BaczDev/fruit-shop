package com.fruit_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "orders")
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    private String country;

    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private String note;

    private String phone;

    @Column(name = "post_code")
    private long postCode;

    private String state;

    @Column(name = "total_price")
    private long totalPrice;

    private String town;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
