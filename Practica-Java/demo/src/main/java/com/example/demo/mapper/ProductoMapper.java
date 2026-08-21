package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.ProductoDto;
import com.example.demo.entidad.Producto;

@Component
public class ProductoMapper {
    
        private ModelMapper mapper = new ModelMapper();
    public ProductoDto toDTO(Producto producto){
        return mapper.map(producto, ProductoDto.class);
    }   
    public Producto toEntity(ProductoDto productoDto){
        return mapper.map(productoDto, Producto.class);
    }
}
