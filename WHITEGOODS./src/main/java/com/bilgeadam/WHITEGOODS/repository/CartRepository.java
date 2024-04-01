package com.bilgeadam.WHITEGOODS.repository;

import com.bilgeadam.WHITEGOODS.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
