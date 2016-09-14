package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.repositorios.RepositorioDeCarritos;
import com.tenpines.starter.rest.AgregarRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ServicioDeCarritos {

    @Autowired
    private RepositorioDeCarritos repo;

    @Transactional
    public void almacenar(AgregarRequest carrito) {
        repo.save(new Carrito(carrito));
    }

    public Carrito buscarElCarrito() {
        return new Carrito();
    }
}
