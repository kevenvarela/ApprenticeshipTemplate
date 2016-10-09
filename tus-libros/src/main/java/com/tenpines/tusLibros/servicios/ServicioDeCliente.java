package com.tenpines.tusLibros.servicios;

import com.tenpines.tusLibros.modelo.Cliente;
import com.tenpines.tusLibros.repositorios.RepositorioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioDeCliente {


    @Autowired
    private RepositorioDeClientes repo;

    @Transactional
    public void guardarCliente(Cliente cliente) {
        repo.save(cliente);
    }

    public Cliente buscarElCliente(Long id) {return repo.findOne(id);}

    public List<Cliente> mostrarClientes(){return repo.findAll();}


    public boolean loguearCliente(Long Id, String password) {
        return ((buscarElCliente(Id).getPassword()).equals(password));
    }

    public Cliente clienteLogueado(Long id, String password){
        if (loguearCliente(id, password)){
            return buscarElCliente(id);
        }
        throw new RuntimeException(mensajeDeErrorCuandoUnUsuarioOUnaContraseniaEsInvalida());
    }

    public static String mensajeDeErrorCuandoUnUsuarioOUnaContraseniaEsInvalida() {
        return "Su usuario o contrasenia es invalido";
    }


}
