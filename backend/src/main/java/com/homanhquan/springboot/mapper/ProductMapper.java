package com.homanhquan.springboot.mapper;

import com.homanhquan.springboot.dto.ProductDto;
import com.homanhquan.springboot.entity.Product;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getCsw_products(),
                product.getType(),
                product.getDescription(),
                product.getPrice(),
                product.getCreated_at()
        );
    }

    public static Product mapToProduct(ProductDto productdto) {
        return new Product(
                productdto.getId(),
                productdto.getCsw_products(),
                productdto.getType(),
                productdto.getDescription(),
                productdto.getPrice(),
                productdto.getCreated_at()
        );
    }
}
