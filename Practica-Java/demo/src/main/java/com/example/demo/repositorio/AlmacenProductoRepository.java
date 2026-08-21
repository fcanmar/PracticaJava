package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.AlmacenProducto;

@Repository
public interface AlmacenProductoRepository extends JpaRepository<AlmacenProducto, Long> {

// Obtener todos los productos de un almacén 
// Única tabla que tiene FK del id de almacen
List<AlmacenProducto> findByAlmacen_Id(Long idAlmacen);

// Metodo para aumentar y disminuir stock
// Se necesita los id de almacen y de produto
// Optional porque puede devolver NULL
Optional<AlmacenProducto> findByAlmacen_IdAndProducto_Id(Long idAlmacen, Long idProducto);


}
