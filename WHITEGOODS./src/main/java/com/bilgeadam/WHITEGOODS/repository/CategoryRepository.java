package com.bilgeadam.WHITEGOODS.repository;

import com.bilgeadam.WHITEGOODS.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
