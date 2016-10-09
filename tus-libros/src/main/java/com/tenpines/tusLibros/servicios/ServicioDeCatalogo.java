package com.tenpines.tusLibros.servicios;

import com.tenpines.tusLibros.modelo.Libro;
import com.tenpines.tusLibros.repositorios.RepositorioDeCatalogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServicioDeCatalogo {

    @Autowired
    private RepositorioDeCatalogo repo;

    public Libro darLibro(Long id) {
        return repo.findOne(id);
    }

    public Libro agregarLibroAlCatalogo(String nombreLibro, String isbn , Integer precio){
        Libro libro = Libro.crearLibro(nombreLibro, isbn, precio);
        guardarEnCatalogo(libro);
        return libro;
    }

    @Transactional
    public void guardarEnCatalogo(Libro libro) {
        repo.save(libro);
    }

    public List<Libro> mostrarCatalogo(){
        List<Libro> repositorio = repo.findAll();
        return repositorio;
    }
}