package com.bilgeadam.WHITEGOODS.service;

import com.bilgeadam.WHITEGOODS.DTO.ProductDTO;
import com.bilgeadam.WHITEGOODS.entity.Category;
import com.bilgeadam.WHITEGOODS.entity.Product;
import com.bilgeadam.WHITEGOODS.repository.CategoryRepository;
import com.bilgeadam.WHITEGOODS.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }


    public List<ProductDTO> getAllProduct() {
        List<Product> product = productRepository.findAll();
        List<ProductDTO> dto = product.stream().map(this::getProductDTO).toList();
        return dto;
    }

    public ProductDTO getProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.isEmpty() ? null : getProductDTO(optionalProduct.get());
    }
    public Product updateProduct(ProductDTO dto) {
        Optional<Product> optionalProduct = productRepository.findById(dto.getId());
        if (optionalProduct.isEmpty()) return null;
        Product product = optionalProduct.get();
        product.setId(dto.getId());
        return productRepository.save(product);
    }
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public ProductDTO saveProduct(ProductDTO dto) throws Exception {
        if (Objects.isNull(dto.getCategoryId()))
            throw new Exception("Category alanı boş olamaz");
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());
        if (optionalCategory.isEmpty())
            throw new Exception("Category Bulunamadı");
        Product product = new Product();
        product.setCategory(optionalCategory.get());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setImage(dto.getImage());

        return getProductDTO(productRepository.save(product));
    }
    public ProductDTO getProductDTO(Product product) {

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategoryId(product.getCategory().getId());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImage());


        return dto;
    }
}
