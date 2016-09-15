package com.tenpines.starter.repositorios;


import com.tenpines.starter.modelo.Catalogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeCatalogo extends CrudRepository<Catalogo, Integer> {

}