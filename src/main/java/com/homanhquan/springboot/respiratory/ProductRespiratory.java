package com.homanhquan.springboot.respiratory;

import com.homanhquan.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespiratory extends JpaRepository<Product, Long> {
}
