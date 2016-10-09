package com.tenpines.tusLibros.repositorios;

import com.tenpines.tusLibros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCatalogo extends JpaRepository<Libro, Long> {

}