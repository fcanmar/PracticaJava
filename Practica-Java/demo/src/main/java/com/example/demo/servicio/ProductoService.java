package com.example.demo.servicio;

import java.util.List;


import com.example.demo.DTO.ProductoDto;


public interface ProductoService {

// Obtener todos los productos

public List<ProductoDto> obtenerTodos();

// Obtener todos los productos de un almacén 

public List<ProductoDto> obtenerProductosPorAlmacen(Long idAlmacen);

// Crear un nuevo producto

public ProductoDto crearProducto(ProductoDto dto);

// actualizar un producto existente

public ProductoDto actualizarProducto(Long id, ProductoDto dto) throws Exception ;

// Eliminar un producto

public void eliminarProducto(Long id) throws Exception;

}
