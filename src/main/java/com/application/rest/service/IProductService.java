package com.application.rest.service;

import com.application.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    // ej para query methods. Listar productos que esten entre un precio minimo y maximo dado
    List<Product>findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    void save(Product product);

    void deleteById(Long id);
}
