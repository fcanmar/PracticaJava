package com.example.demo.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DetalleProductoDto;
import com.example.demo.servicio.DetalleProductoService;

@RestController
@RequestMapping("/detalle")
public class DetalleProductoController {

    private final DetalleProductoService detalle;

    public DetalleProductoController(DetalleProductoService detalle) {
        this.detalle = detalle;
    }

    // GET - Obtener detalle por id
    @GetMapping("/{id}")
    public ResponseEntity<DetalleProductoDto> obtenerDetalle(@PathVariable Long id) {

        return this.detalle.obtenerDetalle(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - Crear detalle
    @PostMapping
    public ResponseEntity<DetalleProductoDto> crearDetalle(@RequestBody DetalleProductoDto dto) throws Exception {
        return ResponseEntity.ok(this.detalle.crearDetalle(dto));
    }

}
