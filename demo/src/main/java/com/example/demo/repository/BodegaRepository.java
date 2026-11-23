package main.java.com.example.demo.repository;

import main.java.com.example.demo.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    Optional<Bodega> findByNombre(String nombre);
}