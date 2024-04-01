package com.bilgeadam.WHITEGOODS.controller;

import com.bilgeadam.WHITEGOODS.DTO.CartDTO;
import com.bilgeadam.WHITEGOODS.entity.Cart;
import com.bilgeadam.WHITEGOODS.service.CartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> getAllCart() {
        return cartService.getAllCart();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart getCartByID(@PathVariable("id") Integer id) {
        return cartService.getCartByID(id);
    }

    @PostMapping(path ="/add" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart saveCart(@RequestBody CartDTO dto) {
        return cartService.saveCart(dto);
    }

    @PutMapping(path ="/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart updateCart(@RequestBody CartDTO dto) throws Exception {
        return cartService.updateCart(dto);
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCart(@PathVariable("id") Integer id) throws Exception {
        cartService.deleteCart(id);
        return "Silme İşlemi Başarılı.";
    }
}

