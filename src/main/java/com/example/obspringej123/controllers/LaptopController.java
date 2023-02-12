package com.example.obspringej123.controllers;

import com.example.obspringej123.entities.Laptop;
import com.example.obspringej123.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    @Value("${app.message}")
    String message;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // Atributos
    private LaptopRepository laptopRepository;

    // Constructores
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    // Métodos

    /**
     * Recuperar lista de ordenadores.
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        System.out.println(message);

        return laptopRepository.findAll();
    }

    /**
     * Buscar un solo ordenador en base de datos según su id
     */
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable/*("id")*/ Long id) {
        System.out.println(message);

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if (laptopOpt.isPresent()) {
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Guardar ordenador.
     */
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(message);

        return laptopRepository.save(laptop);
    }

    /**
     * Actualizar un ordenador existente en base de datos
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
        System.out.println(message);

        if (laptop.getId() == null) {
            // Si no tiene id quiere decir que sí es una creación.
            log.warn("Trying to update a non-existent laptop.");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to update a non-existent laptop.");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // El ordenador devuelto tiene una clave primaria.
    }

    /**
     * Borrar un ordenador en base de datos
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable/*("id")*/ Long id) {
        System.out.println(message);

        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non-existent laptop.");
            return ResponseEntity.notFound().build();
        }

        //try {
        laptopRepository.deleteById(id);
        //} catch (Exception e) {}

        return ResponseEntity.noContent().build();
    }

    /**
     * Borrar todos los ordenadores en base de datos
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll() {
        System.out.println(message);

        log.info("REST Request for delete all laptops");
        //try {
        laptopRepository.deleteAll();
        //} catch (Exception e) {}

        return ResponseEntity.noContent().build();
    }
}
