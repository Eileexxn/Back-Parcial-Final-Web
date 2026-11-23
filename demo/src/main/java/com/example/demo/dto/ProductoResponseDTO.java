package main.java.com.example.demo.dto;

public record ProductoResponseDTO(
        Long id,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Integer cantidad
) {}
