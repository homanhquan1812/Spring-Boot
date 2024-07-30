package com.homanhquan.springboot.service.implement;

import com.homanhquan.springboot.dto.ProductDto;
import com.homanhquan.springboot.entity.Product;
import com.homanhquan.springboot.exception.Exception;
import com.homanhquan.springboot.mapper.ProductMapper;
import com.homanhquan.springboot.respiratory.ProductRespiratory;
import com.homanhquan.springboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService {
    private ProductRespiratory productRespiratory;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRespiratory.save(product);

        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRespiratory.findById(productId)
                .orElseThrow(() -> new Exception("This product with ID: " + productId + " doesn't exist."));

        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRespiratory.findAll();

        // return products.stream().map((product -> ProductMapper.mapToProductDto(product))).collect(Collectors.toList());
        return products.stream().map((ProductMapper::mapToProductDto)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRespiratory.findById(productId).orElseThrow(() -> new Exception("This product with ID: " + productId + " doesn't exist."));

        product.setCsw_products(updatedProduct.getCsw_products());
        product.setType(updatedProduct.getType());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());

        Product updatedProductObj = productRespiratory.save(product);

        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRespiratory.findById(productId).orElseThrow(() -> new Exception("This product with ID: " + productId + " doesn't exist."));

        productRespiratory.deleteById(productId);
    }
}
