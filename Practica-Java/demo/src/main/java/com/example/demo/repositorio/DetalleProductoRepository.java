package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.DetalleProducto;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long> {

 // vacio

}
