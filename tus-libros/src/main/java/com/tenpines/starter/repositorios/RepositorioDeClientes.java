package com.tenpines.starter.repositorios;

import com.tenpines.starter.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface RepositorioDeClientes extends CrudRepository<Cliente, Long> {
}