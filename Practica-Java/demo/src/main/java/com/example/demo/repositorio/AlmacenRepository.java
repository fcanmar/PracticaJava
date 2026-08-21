package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Long> {

// vacio

}
