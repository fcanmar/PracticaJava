package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.DetalleProductoDto;
import com.example.demo.entidad.DetalleProducto;

@Component
public class DetalleProductoMapper {
    
        private ModelMapper mapper = new ModelMapper();
    public DetalleProductoDto toDTO(DetalleProducto detalle){
        return mapper.map(detalle, DetalleProductoDto.class);
    }   
    public DetalleProducto toEntity(DetalleProductoDto detalleDto){
        return mapper.map(detalleDto, DetalleProducto.class);
    }
}
