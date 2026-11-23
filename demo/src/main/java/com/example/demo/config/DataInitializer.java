package main.java.com.example.demo.config;

import main.java.com.example.demo.entity.Bodega;
import main.java.com.example.demo.entity.Producto;
import main.java.com.example.demo.repository.BodegaRepository;
import main.java.com.example.demo.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BodegaRepository bodegaRepository;
    private final ProductoRepository productoRepository;

    @Override
    @Transactional
    public void run(String... args) {
        if (bodegaRepository.count() > 0 || productoRepository.count() > 0) {
            return;
        }

        Bodega bodegaNorte = bodegaRepository.save(Bodega.builder()
                .nombre("Bodega Norte")
                .ubicacion("Zona Norte")
                .build());

        Bodega bodegaSur = bodegaRepository.save(Bodega.builder()
                .nombre("Bodega Sur")
                .ubicacion("Zona Sur")
                .build());

        Producto computador = Producto.builder()
                .nombre("Computador portátil")
                .descripcion("Equipo portátil de oficina")
                .precio(new BigDecimal("2500000"))
                .cantidad(15)
                .bodega(bodegaNorte)
                .build();

        Producto monitor = Producto.builder()
                .nombre("Monitor")
                .descripcion("Monitor de escritorio")
                .precio(new BigDecimal("750000"))
                .cantidad(20)
                .bodega(bodegaNorte)
                .build();

        Producto impresora = Producto.builder()
                .nombre("Impresora")
                .descripcion("Impresora multifuncional")
                .precio(new BigDecimal("1200000"))
                .cantidad(8)
                .bodega(bodegaSur)
                .build();

        productoRepository.saveAll(List.of(computador, monitor, impresora));
    }
}
