package main.java.com.example.demo.service;

import main.java.com.example.demo.dto.*;
import main.java.com.example.demo.entity.Bodega;
import main.java.com.example.demo.repository.BodegaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    @Transactional
    public BodegaResponseDTO registrarBodega(Bodega bodega) {
        Bodega guardada = bodegaRepository.save(bodega);
        return mapToDTO(guardada);
    }

    @Transactional(readOnly = true)
    public List<BodegaResponseDTO> listarBodegasConProductos() {
        return bodegaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private BodegaResponseDTO mapToDTO(Bodega bodega) {
        List<ProductoResponseDTO> productosDTO = bodega.getProductos()
                .stream()
                .map(p -> new ProductoResponseDTO(
                        p.getId(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getPrecio(),
                        p.getCantidad()
                ))
                .toList();

        return new BodegaResponseDTO(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                productosDTO
        );
    }
}
