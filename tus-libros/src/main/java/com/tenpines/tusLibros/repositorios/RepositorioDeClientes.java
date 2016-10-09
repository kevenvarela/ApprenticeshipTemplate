package com.tenpines.tusLibros.repositorios;

import com.tenpines.tusLibros.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeClientes extends JpaRepository<Cliente, Long> {
}
