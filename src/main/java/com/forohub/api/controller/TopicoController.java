package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new RuntimeException("Este tópico ya existe con el mismo título y mensaje.");
        }
        repository.save(new Topico(datos));
    }
    @GetMapping
    public Page<DatosListadoTopico> listar(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListadoTopico::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {
        // findById devuelve un optional, asi evito la excepción si el ID no existe.
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        }

        //si no está presente, regreso el 404
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        Optional<Topico> optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();

            if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
                throw new RuntimeException("Ya existe un tópico con ese título y mensaje.");
            }

            topico.actualizarDatos(datos);
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        Optional<Topico> optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}