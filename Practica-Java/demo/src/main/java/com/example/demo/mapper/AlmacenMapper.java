package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.AlmacenDto;
import com.example.demo.entidad.Almacen;

@Component
public class AlmacenMapper {
  
    private ModelMapper mapper = new ModelMapper();
    public AlmacenDto toDTO(Almacen almacen){
        return mapper.map(almacen, AlmacenDto.class);
    }   
    public Almacen toEntity(AlmacenDto almacenDto){
        return mapper.map(almacenDto, Almacen.class);
    }  

    
}
