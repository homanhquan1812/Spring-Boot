package com.homanhquan.springboot.service;

import com.homanhquan.springboot.dto.ProductDto;

import java.util.List;

public interface ProductService {
    // [POST] /products
    ProductDto createProduct(ProductDto productDto);

    // [GET] /products/edit/:id
    ProductDto getProductById(Long productId);

    // [GET] /products
    List<ProductDto> getAllProducts();

    // [PUT] /products/edit/:id
    ProductDto updateProduct(Long productId, ProductDto updatedProduct);

    void deleteProduct(Long productId);
}
