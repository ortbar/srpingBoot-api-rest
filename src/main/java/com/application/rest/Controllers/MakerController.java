package com.application.rest.Controllers;


import com.application.rest.Controllers.DTO.MakerDTO;
import com.application.rest.entities.Maker;
import com.application.rest.service.IMakerService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/maker")

public class MakerController {

    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Maker> makerOptional = makerService.findById(id);

        if (makerOptional.isPresent()) {
            // no se retorna el objeto entity, xq es mala practica, en su lugar DTO - Data Transfer Object
            // convertimos el maker de la respusta a maker DTO. Extraer los atributos del entity y setearlos en el DTO
            Maker maker = makerOptional.get();

            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findall(){

        // convertir a DTO. convirtiendo una lista de entidades Maker a una lista de objetos MakerDTO
        // MAPEA el maker y lo coniverte a una manera mas sencilla DTO, eliminando dependencias y logica MAkerDTO
        List<MakerDTO> makerList = makerService.findall()
                .stream()
                .map(maker -> MakerDTO.builder()
                        .id(maker.getId())
                        .name(maker.getName())
                        .productList(maker.getProductList())
                        .build())
                .toList(); // convertir todo lo anterior a lista
        return ResponseEntity.ok(makerList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO makerDTO) throws URISyntaxException {

        if(makerDTO.getName().isBlank()) {
            // si el nombre en blanco, peticion mal formulada
            return ResponseEntity.badRequest().build();
        }
        makerService.save(Maker.builder()
                //madamos solamente el nombre, el id lo genera JPA automaticamente,
                // y construimos el nuevo entity a partir del nombre del makerDTO
                .name(makerDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>upadateMaker(@PathVariable Long id, @RequestBody MakerDTO makerDTO){

        Optional<Maker> makerOptional = makerService.findById(id);

        if(makerOptional.isPresent()) {
            //recuperamos el entity maker
            // cambiamos el nombre y luego volvemos a guardar
            Maker maker = makerOptional.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
            return ResponseEntity.ok("Registro actualizado");
        }
        // si no existe el registro...
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteMaker(@PathVariable Long id) {
        if(id != null) {
            makerService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }

        return ResponseEntity.badRequest().build();

    }



}
