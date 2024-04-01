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
@Table(name = "order", schema = "white_good")
public class Order {
    @Id
    @GeneratedValue(generator = "order_id_generator")
    @SequenceGenerator(name = "order_id_generator", schema = "white_good", sequenceName = "order_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name="quantity")
    private int quantity;

}
