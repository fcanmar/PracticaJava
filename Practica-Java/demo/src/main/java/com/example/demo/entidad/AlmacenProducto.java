package com.example.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "almacenes_productos")
@Data

public class AlmacenProducto {
  @Id
  @GeneratedValue
  private Long id;

  // los registros apuntan a varias veces al mismo productos/almacenes
  @ManyToOne
  @JoinColumn(name = "id_almacen")
  private Almacen almacen;

  @ManyToOne
  @JoinColumn(name = "id_producto")
  private Producto producto;

  @Column(name = "cantidad", nullable = false)
  private Integer cantidad;
}
