package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor // Constructor con todos los parámetros
@NoArgsConstructor // Constructor sin parámetros
@Data // getter y setter


public class ProductoDto {
    
    private Long id;
    private String nombre;
    private Double precio;
}
