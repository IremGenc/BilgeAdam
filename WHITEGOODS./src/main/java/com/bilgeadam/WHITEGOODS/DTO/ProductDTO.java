package com.bilgeadam.WHITEGOODS.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Float price;
    private Integer categoryId;
    private String image;
}
