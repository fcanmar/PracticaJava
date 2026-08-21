package com.example.demo.DTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor // Constructor con todos los parámetros
@NoArgsConstructor // Constructor sin parámetros
@Data // getter y setter


public class AlmacenProductoDto {
    
    
    private Long id;          
    private Long idProducto;  // FK al producto
    private Long idAlmacen;   // FK al almacén
    private Integer cantidad; 


}
