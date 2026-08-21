package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.AlmacenProductoDto;
import com.example.demo.entidad.AlmacenProducto;

@Component
public class AlmacenProductoMapper {
    

    private ModelMapper mapper = new ModelMapper();
    public AlmacenProductoDto toDTO(AlmacenProducto almacenProducto){
        return mapper.map(almacenProducto, AlmacenProductoDto.class);
    }   
    public AlmacenProducto toEntity(AlmacenProductoDto almacenProductoDto){
        return mapper.map(almacenProductoDto, AlmacenProducto.class);
    }



}
