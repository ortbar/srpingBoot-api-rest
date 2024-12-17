package com.application.rest.persistence;

import com.application.rest.entities.Maker;
import com.application.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {

// solo DEFINIMOS LOS METODOS QUE VAMOS A UTILIZAR
    List<Product> findAll();

    Optional<Product> findById(Long id);

    // ej para query methods. Listar productos que esten entre un precio minimo y maximo dado
    List<Product>findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    void save(Product product);

    void deleteById(Long id);
}
