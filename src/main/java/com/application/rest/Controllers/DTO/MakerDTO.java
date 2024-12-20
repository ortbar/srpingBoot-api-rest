package com.application.rest.Controllers.DTO;

import com.application.rest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
    // PONEMOS los mismo atributos del maker, pero quitando las anotaciones de JPA


    // basicamente ésto es lo que vamos a retornar como respuesta - DTO
    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
