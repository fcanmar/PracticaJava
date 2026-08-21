package com.example.demo.servicio;

import java.util.Optional;

import com.example.demo.DTO.DetalleProductoDto;

public interface DetalleProductoService {

// Obtener el detalle de un producto

public Optional<DetalleProductoDto> obtenerDetalle(Long id);

// Crea un nuevo detalle producto

public DetalleProductoDto crearDetalle(DetalleProductoDto dto) throws Exception;

}
