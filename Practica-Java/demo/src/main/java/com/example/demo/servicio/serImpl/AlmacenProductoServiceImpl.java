package com.example.demo.servicio.serImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AlmacenProductoDto;
import com.example.demo.entidad.Almacen;
import com.example.demo.entidad.AlmacenProducto;
import com.example.demo.entidad.Producto;
import com.example.demo.mapper.AlmacenProductoMapper;
import com.example.demo.repositorio.AlmacenProductoRepository;
import com.example.demo.repositorio.AlmacenRepository;
import com.example.demo.repositorio.ProductoRepository;
import com.example.demo.servicio.AlmacenProductoService;

@Service
public class AlmacenProductoServiceImpl implements AlmacenProductoService {

    private final AlmacenProductoRepository repositorio;
    private final ProductoRepository productoRepositorio;
    private final AlmacenRepository almacenRepositorio;
    private final AlmacenProductoMapper mapper;

    public AlmacenProductoServiceImpl(AlmacenProductoRepository repositorio, ProductoRepository productoRepositorio,
            AlmacenRepository almacenRepositorio, AlmacenProductoMapper mapper) {
        this.repositorio = repositorio;
        this.productoRepositorio = productoRepositorio;
        this.almacenRepositorio = almacenRepositorio;
        this.mapper = mapper;
    }

    @Override
    public void aumentarStock(Long idProducto, Long idAlmacen, Integer cantidad) throws Exception {
        if (cantidad == null || cantidad <= 0) {
            throw new Exception("Cantidad inválida");
        }

        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new Exception("Producto no existe"));

        if (producto.getDetalle() == null) {
            throw new Exception("El producto no tiene detalle");
        }

        Almacen almacen = almacenRepositorio.findById(idAlmacen)
                .orElseThrow(() -> new Exception("Almacén no existe"));

        Optional<AlmacenProducto> alpro = repositorio.findByAlmacen_IdAndProducto_Id(idAlmacen, idProducto);

        if (alpro.isPresent()) {
            AlmacenProducto ap = alpro.get();
            ap.setCantidad(ap.getCantidad() + cantidad);
            repositorio.save(ap);
        } else {
            // crear dto para usar el mapper
            AlmacenProductoDto dto = new AlmacenProductoDto();
            dto.setIdProducto(idProducto);
            dto.setIdAlmacen(idAlmacen);
            dto.setCantidad(cantidad);
            AlmacenProducto nuevo = mapper.toEntity(dto);
            nuevo.setProducto(producto);
            nuevo.setAlmacen(almacen);

            repositorio.save(nuevo);
        }

    }

    @Override
    public void disminuirStock(Long idProducto, Long idAlmacen, Integer cantidad) throws Exception {
        if (cantidad == null || cantidad <= 0) {
            throw new Exception("Cantidad inválida");
        }

        AlmacenProducto ap = repositorio
                .findByAlmacen_IdAndProducto_Id(idAlmacen, idProducto)
                .orElseThrow(() -> new Exception("No existe stock"));

        if (ap.getCantidad() < cantidad) {
            throw new Exception("Stock insuficiente");
        }

        ap.setCantidad(ap.getCantidad() - cantidad);

        repositorio.save(ap);

    }

}
