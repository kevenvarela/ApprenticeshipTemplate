package com.tenpines.starter.repositorios;

import com.tenpines.starter.modelo.Carrito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCarritos extends CrudRepository<Carrito, Long> {

}
