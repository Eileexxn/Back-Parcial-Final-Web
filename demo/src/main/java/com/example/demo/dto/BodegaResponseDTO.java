package main.java.com.example.demo.dto;

import java.util.List;

public record BodegaResponseDTO(
        Long id,
        String nombre,
        String ubicacion,
        List<ProductoResponseDTO> productos
) {}