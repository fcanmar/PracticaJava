package com.example.demo.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="almacen")
@Data

public class Almacen {
@Id
@GeneratedValue
  private Long id;

 @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "ubicacion", nullable = false)
  private String ubicacion;

  // Almacen NO ES EL PROPIETARIO DE LA RELACIÓN

// Un almacén tiene muchos productos
  @OneToMany(mappedBy = "almacen")
  @JsonIgnore
  private List<AlmacenProducto> productos;
}
