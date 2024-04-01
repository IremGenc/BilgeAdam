package com.bilgeadam.WHITEGOODS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart", schema = "white_good")
public class Cart {

    @Id
    @GeneratedValue(generator = "cart_id_generator")
    @SequenceGenerator(name = "cart_id_generator", schema ="white_good", sequenceName = "cart_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}