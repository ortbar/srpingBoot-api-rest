package com.application.rest.Controllers.DTO;

import com.application.rest.entities.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {


    // PONEMOS los mismo atributos del PRODUCT, pero quitando las anotaciones de JPA


    // basicamente ésto es lo que vamos a retornar como respuesta - DTO
    private Long id;

    private String name;

    private BigDecimal price;

    private Maker maker;
}
