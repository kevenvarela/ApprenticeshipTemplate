package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Catalogo;
import com.tenpines.starter.repositorios.RepositorioDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServicioDeCatalogo {

    @Autowired
    private RepositorioDeCatalogo repo;

    public Catalogo darCatalogo(Integer id) {
        return repo.findOne(id);
    }

    public void guardarCatalogo(Catalogo catalogo) {
        repo.save(catalogo);
    }

//    @Transactional
//    public void almacenar(Carrito carrito) {
//        repo.save(carrito);
//    }


//    public Iterable<Carrito> mostrarCarritos(){
//        return repo.findAll();
//    }
}