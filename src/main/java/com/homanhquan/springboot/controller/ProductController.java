package com.homanhquan.springboot.controller;

import com.homanhquan.springboot.dto.ProductDto;
import com.homanhquan.springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    // [POST] /products/add
    @PostMapping("/add")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.createProduct(productDto);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // [GET] /products/:id
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        ProductDto productDto = productService.getProductById(productId);

        return ResponseEntity.ok(productDto);
    }

    // [GET] /products
    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    // [PUT] /products/:id
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDto updatedProduct) {
        ProductDto productDto = productService.updateProduct(productId, updatedProduct);

        return ResponseEntity.ok(productDto);
    }

    // [DELETE] /products/:id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);

        return ResponseEntity.ok("Product deleted successfully.");
    }
}
