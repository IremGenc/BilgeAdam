package com.bilgeadam.WHITEGOODS.service;


import com.bilgeadam.WHITEGOODS.DTO.CartDTO;
import com.bilgeadam.WHITEGOODS.entity.Cart;
import com.bilgeadam.WHITEGOODS.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    public Cart getCartByID(Integer id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        return optionalCart.isEmpty() ? null : optionalCart.get();
    }

    public Cart saveCart(CartDTO dto) {
        Cart cart = new Cart();
        cart.setId(dto.getCartId());
        cart.setTotalPrice(dto.getTotalPrice());
        cart.setQuantity(dto.getQuantity());
        return cartRepository.save(cart);
    }

    public Cart updateCart(CartDTO dto) {
        Optional<Cart> optionalCart = cartRepository.findById(dto.getCartId());
        if (optionalCart.isEmpty()) return null;
        Cart cart = optionalCart.get();
        cart.setId(dto.getCartId());
        return cartRepository.save(cart);
    }
    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }
}

