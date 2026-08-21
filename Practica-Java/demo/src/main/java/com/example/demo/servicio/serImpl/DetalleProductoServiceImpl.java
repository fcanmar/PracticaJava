package com.example.demo.servicio.serImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.DetalleProductoDto;
import com.example.demo.entidad.DetalleProducto;
import com.example.demo.entidad.Producto;
import com.example.demo.mapper.DetalleProductoMapper;
import com.example.demo.repositorio.DetalleProductoRepository;
import com.example.demo.repositorio.ProductoRepository;
import com.example.demo.servicio.DetalleProductoService;

@Service
public class DetalleProductoServiceImpl implements DetalleProductoService {

    private final DetalleProductoRepository repositorio;
    private final ProductoRepository productoRepositorio;
    private final DetalleProductoMapper mapper;

    public DetalleProductoServiceImpl(DetalleProductoRepository repositorio, ProductoRepository productoRepositorio,
            DetalleProductoMapper mapper) {
        this.repositorio = repositorio;
        this.productoRepositorio = productoRepositorio;
        this.mapper = mapper;
    }

    @Override
    public DetalleProductoDto crearDetalle(DetalleProductoDto dto) throws Exception {

        Producto producto = productoRepositorio.findById(dto.getIdProducto())
                .orElseThrow(() -> new Exception("producto no existe"));

        if (producto.getDetalle() != null) {  // del mappedby 
            throw new Exception("ya tiene detalle");
        }

        DetalleProducto detalle = mapper.toEntity(dto);
        detalle.setProducto(producto); // para que sea el mismo id, viene el joinColumn

        detalle = repositorio.save(detalle);
        return mapper.toDTO(detalle);
    }

    @Override
    public Optional<DetalleProductoDto> obtenerDetalle(Long id) {
        return this.repositorio.findById(id).map(mapper::toDTO);

    }

}
