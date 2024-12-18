package com.application.rest.persistence;
// DAO = DATA ACCESS OBJECT. - patron de diseño, abstracción que se utiliza para separar la lógica de acceso a datos del resto de la aplicación.

// Separar la lógica de acceso a datos del negocio.
// Facilitar el mantenimiento y reutilización del código.
// Permitir cambios en la tecnología de persistencia (por ejemplo, cambiar de MySQL a MongoDB) sin afectar al resto de la aplicación.

// Componentes de patron DAO: Entity, DAO/Repository, Service y Controller

// 🗂 RESUMEN DEL FLUJO
//El controlador recibe la petición (por ejemplo, un POST o GET).
//El servicio maneja la lógica de negocio y delega el acceso a datos al DAO/Repositorio.
//El DAO/Repositorio interactúa con la base de datos y devuelve la información al servicio.
//El servicio envía los datos al controlador, que finalmente responde al cliente.

import com.application.rest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {
    // metodos que se van a implementar

    List<Maker> findall();

    Optional<Maker> findById(Long id);

    void save(Maker maker);

    void deleteById(Long id);







}
