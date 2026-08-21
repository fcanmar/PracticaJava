package com.example.demo.servicio.serImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductoDto;
import com.example.demo.entidad.Producto;
import com.example.demo.mapper.ProductoMapper;
import com.example.demo.repositorio.AlmacenProductoRepository;
import com.example.demo.repositorio.ProductoRepository;
import com.example.demo.servicio.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repositorio;
    private final AlmacenProductoRepository almacenProductoRepository;
    private final ProductoMapper mapper;

    public ProductoServiceImpl(ProductoRepository repositorio, AlmacenProductoRepository almacenProductoRepository,
            ProductoMapper mapper) {
        this.repositorio = repositorio;
        this.almacenProductoRepository = almacenProductoRepository;
        this.mapper = mapper;

    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDto dto) throws Exception {
        Optional<Producto> optProducto = this.repositorio.findById(id);
        if (optProducto.isPresent()) {
            Producto producto = optProducto.get();
            producto.setNombre(dto.getNombre());
            producto.setPrecio(dto.getPrecio());
            this.repositorio.save(producto);
            return mapper.toDTO(producto);
        }

        throw new Exception("el id no existe");
    }

    @Override
    public ProductoDto crearProducto(ProductoDto dto) {
        Producto producto = mapper.toEntity(dto);
        producto = this.repositorio.save(producto);
        return mapper.toDTO(producto);
    }

    @Override
    public void eliminarProducto(Long id) throws Exception {
        if (!repositorio.existsById(id)) {
            throw new Exception("Producto no existe");
        } else {
            repositorio.deleteById(id);
        }
    }

    @Override
    public List<ProductoDto> obtenerProductosPorAlmacen(Long idAlmacen) {

        return almacenProductoRepository.findByAlmacen_Id(idAlmacen)
                .stream().map(ap -> mapper.toDTO(ap.getProducto())).toList();
    }

    @Override
    public List<ProductoDto> obtenerTodos() {

        return repositorio.findAll().stream()
                .map(mapper::toDTO).toList();
    }

}
