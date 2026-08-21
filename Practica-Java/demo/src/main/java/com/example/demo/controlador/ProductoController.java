package com.example.demo.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductoDto;
import com.example.demo.servicio.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService producto;

    public ProductoController(ProductoService producto) {
        this.producto = producto;
    }

    // GET - Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductoDto>> obtenerTodos() {
        return ResponseEntity.ok(this.producto.obtenerTodos());
    }

    // GET - Obtener productos por almacén (RequestParam)
    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDto>> obtenerPorAlmacen(@RequestParam Long almacen) {
     return ResponseEntity.ok(this.producto.obtenerProductosPorAlmacen(almacen));
    }

    // POST - Crear producto
    @PostMapping
    public ResponseEntity<ProductoDto> crear(@RequestBody ProductoDto dto) {
        return ResponseEntity.ok(this.producto.crearProducto(dto));
    }

    // PUT - Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto>actualizar(@PathVariable Long id, @RequestBody ProductoDto dto) {
        ProductoDto productos;
        try {
            productos = this.producto.actualizarProducto(id, dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productos);

    }

    // DELETE - Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            this.producto.eliminarProducto(id);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

}
