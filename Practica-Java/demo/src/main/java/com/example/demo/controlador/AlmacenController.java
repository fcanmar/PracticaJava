package com.example.demo.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AlmacenDto;
import com.example.demo.servicio.AlmacenService;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {

    private final AlmacenService almacen;

    public AlmacenController(AlmacenService almacen) {
        this.almacen = almacen;
    }

    // GET - Obtener todos los almacenes
    @GetMapping
    public ResponseEntity<List<AlmacenDto>> obtenerTodos() {
        return ResponseEntity.ok(this.almacen.obtenerTodos());
    }

}
