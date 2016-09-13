package com.tenpines.starter.repositorios;

import com.tenpines.starter.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface Repositorio extends CrudRepository<Carrito, Long> {

}
