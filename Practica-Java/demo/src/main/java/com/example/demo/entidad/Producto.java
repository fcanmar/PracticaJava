package com.example.demo.entidad;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
@Data

public class Producto {
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "nombre", nullable = false)
  private String nombre;

  @Column(name = "precio", nullable = false)
  private Double precio;

  // Producto NO ES EL PROPIETARIO DE LA RELACIÓN

  // 1 Producto tiene 1 DetalleProducto
  @OneToOne(mappedBy = "producto")
  @JsonIgnore
  private DetalleProducto detalle;

  // 1 Producto puede estar en muchos almacenes
  @OneToMany(mappedBy = "producto")
  @JsonIgnore
  private List<AlmacenProducto> almacenes;

}
