package com.example.demo.servicio;

public interface AlmacenProductoService {

// Aumentar stock

public void aumentarStock(Long idProducto, Long idAlmacen, Integer cantidad) throws Exception;

// Disminuir stock

public void disminuirStock(Long idProducto, Long idAlmacen, Integer cantidad) throws Exception;

}
