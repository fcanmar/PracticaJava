package com.example.demo.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicio.AlmacenProductoService;

@RestController
@RequestMapping("/stock")
public class AlmacenProductoController {

    private final AlmacenProductoService almacenProducto;

    public AlmacenProductoController(AlmacenProductoService almacenProducto) {
        this.almacenProducto = almacenProducto;
    }

    // POST - Aumentar stock
    @PostMapping("/aumentar")
    public ResponseEntity<Void> aumentarStock(@RequestParam Long idProducto, @RequestParam Long idAlmacen,
            @RequestParam Integer cantidad) {
        try {
            this.almacenProducto.aumentarStock(idProducto, idAlmacen, cantidad);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    // POST - Disminuir stock
    @PostMapping("/disminuir")
    public ResponseEntity<Void> disminuirStock(@RequestParam Long idProducto, @RequestParam Long idAlmacen,
            @RequestParam Integer cantidad) {

        try {
            this.almacenProducto.disminuirStock(idProducto, idAlmacen, cantidad);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();

    }
}
