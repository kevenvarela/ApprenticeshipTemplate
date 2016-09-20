package com.tenpines.starter.repositorios;


import com.tenpines.starter.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCatalogo extends JpaRepository<Libro, Long> {

}