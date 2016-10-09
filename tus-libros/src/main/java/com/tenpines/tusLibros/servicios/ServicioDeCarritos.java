package com.tenpines.tusLibros.servicios;

import  com.tenpines.tusLibros.modelo.Carrito;
import com.tenpines.tusLibros.modelo.Libro;
import com.tenpines.tusLibros.modelo.PackDeLibros;
import com.tenpines.tusLibros.repositorios.RepositorioDeCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@Service
public class ServicioDeCarritos {

    @Autowired
    private RepositorioDeCarritos repo;

    @Autowired
    private ServicioDeCliente servicioDeCliente;

    @Autowired
    private ServicioDeCatalogo servicioDeCatalogo;

    @Autowired
    private EntityManager em;

    @Transactional
    public void almacenar(Carrito carrito) {
        repo.save(carrito);
    }

    public Carrito buscarElCarrito(Long id) {
        return repo.findOne(id);
    }

    public List<Carrito> mostrarCarritos(){
        return repo.findAll();
    }

    public Carrito nuevoCarrito() {
        Carrito carrito = Carrito.crearCarrito();
        almacenar(carrito);
        return carrito;
    }

    public void agregarLibro(Carrito unCarrito, Long unLibro, Integer cantidad){
        validarQueElLibroPertenezcaALaEditorial(unLibro);
        Libro miLibroAAgregar = servicioDeCatalogo.darLibro(unLibro);
        unCarrito.agregarLibro(miLibroAAgregar,cantidad);
        almacenar(unCarrito);
    }

    private void validarQueElLibroPertenezcaALaEditorial(Long libroId) {
        Libro unLibro = servicioDeCatalogo.darLibro(libroId);
        if(unLibro == null){
            throw new RuntimeException(mensajeDeErrorCuandoElLibroNoExisteEnLaEditorial());
        }
    }

    private static String mensajeDeErrorCuandoElLibroNoExisteEnLaEditorial() {
        return "El libro que intenta agregar al carrito no corresponde a esta editorial";
    }

    public Set<PackDeLibros> mostrarLibrosDeCarrito(Long id) {
        Carrito carrito = repo.findOne(id);
        return carrito.getItems();
    }
}
