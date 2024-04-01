package com.bilgeadam.WHITEGOODS.controller;

import com.bilgeadam.WHITEGOODS.DTO.ProductDTO;
import com.bilgeadam.WHITEGOODS.entity.Product;
import com.bilgeadam.WHITEGOODS.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String isRunning() {
        return "API is working";
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProductByID(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDTO> getAllProduct() {return productService.getAllProduct();}

    @PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO saveProduct(@RequestBody ProductDTO dto) throws Exception {
        return productService.saveProduct(dto);
    }
    @PutMapping(path ="/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@RequestBody ProductDTO dto) throws Exception {
        return productService.updateProduct(dto);
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteProduct(@PathVariable("id") Integer id) throws Exception {
        productService.deleteProduct(id);
        return "Silme İşlemi Başarılı.";
    }
}

