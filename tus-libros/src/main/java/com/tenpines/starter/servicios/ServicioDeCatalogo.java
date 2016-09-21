package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Libro;
import com.tenpines.starter.repositorios.RepositorioDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServicioDeCatalogo {

    @Autowired
    private RepositorioDeCatalogo repo;

    public Libro darLibro(Long id) {
        return repo.findOne(id);
    }

    public void guardarEnCatalogo(Libro libro) {
        repo.save(libro);
    }


    public List<Libro> mostrarCatalogo(){
        List<Libro> repositorio = repo.findAll();
        return repositorio;
    }
}