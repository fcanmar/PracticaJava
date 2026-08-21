package com.example.demo.servicio.serImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.AlmacenDto;
import com.example.demo.mapper.AlmacenMapper;
import com.example.demo.repositorio.AlmacenRepository;
import com.example.demo.servicio.AlmacenService;
@Service
public class AlmacenServiceImpl implements AlmacenService {

    private final AlmacenRepository repositorio;
    private final AlmacenMapper mapper;

    public AlmacenServiceImpl(AlmacenRepository repositorio, AlmacenMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public List<AlmacenDto> obtenerTodos() {
       return repositorio.findAll().stream()
                .map(mapper::toDTO).toList();
    }
}
