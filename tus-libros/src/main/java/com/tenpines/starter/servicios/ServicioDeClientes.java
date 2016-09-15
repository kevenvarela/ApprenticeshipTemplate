package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Cliente;
import com.tenpines.starter.repositorios.RepositorioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioDeClientes {

    @Autowired
    private RepositorioDeClientes repo;

    @Transactional
    public void almacenar(Cliente cliente) {
        repo.save(cliente);
    }

    public Cliente buscarElCliente(Long id) {return repo.findOne(id);}





}