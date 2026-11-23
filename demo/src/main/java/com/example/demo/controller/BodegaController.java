package main.java.com.example.demo.controller;

import main.java.com.example.demo.dto.BodegaResponseDTO;
import main.java.com.example.demo.entity.Bodega;
import main.java.com.example.demo.service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bodegas")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @PostMapping
    public ResponseEntity<BodegaResponseDTO> registrarBodega(@RequestBody Bodega bodega) {
        if (bodega.getNombre() == null || bodega.getNombre().isBlank()
                || bodega.getUbicacion() == null || bodega.getUbicacion().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        BodegaResponseDTO creada = bodegaService.registrarBodega(bodega);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public ResponseEntity<List<BodegaResponseDTO>> listarBodegas() {
        return ResponseEntity.ok(bodegaService.listarBodegasConProductos());
    }
}