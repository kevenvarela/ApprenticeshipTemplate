package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.repositorios.RepositorioDeCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ServicioDeCarritos {

    @Autowired
    private RepositorioDeCarritos repo;

    @Transactional
    public void almacenar(Carrito carrito) {
        repo.save(carrito);
    }

//    public Carrito buscarElCarrito(Long id) {
//        return repo.findOne(id);
//    }

    public Iterable<Carrito> mostrarCarritos(){
        return repo.findAll();
    }
}
