package com.tenpines.tusLibros.repositorios;

import com.tenpines.tusLibros.modelo.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCarritos extends JpaRepository<Carrito, Long> {

}
