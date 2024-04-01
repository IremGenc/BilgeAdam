package com.bilgeadam.WHITEGOODS.DTO;

import lombok.Data;

@Data
public class CartDTO {
    private Integer cartId;
    private Integer totalPrice;
    private Integer quantity;
}
