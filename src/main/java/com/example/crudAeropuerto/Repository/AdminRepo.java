package com.example.crudAeropuerto.Repository;

import com.example.crudAeropuerto.Entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Administrador, Integer> {
    Optional<Administrador> findByEmail(String email);
}
