package com.example.demo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_producto")
@Data

public class DetalleProducto {
  @Id
  private Long id;
  // 1 Producto tiene 1 DetalleProducto
  @OneToOne
  // No genera ID para DetalleProducto
  @MapsId
  // columna en esta tabla que une con otra tabla
  @JoinColumn(name = "id", nullable = false)
  private Producto producto;

  @Column(name = "descripcionLarga", nullable = false)
  private String descripcionLarga;

  @Column(name = "peso", nullable = false)
  private Double peso;

}
