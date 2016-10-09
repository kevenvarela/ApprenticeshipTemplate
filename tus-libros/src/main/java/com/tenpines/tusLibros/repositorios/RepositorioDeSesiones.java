package com.tenpines.tusLibros.repositorios;

import com.tenpines.tusLibros.modelo.Carrito;
import com.tenpines.tusLibros.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RepositorioDeSesiones extends JpaRepository<Sesion, Long> {


    @Query("select c from Sesion c where c.carrito.id = ?1")
    Sesion getSesion(Long carritoId);

    @Query("select c.carrito from Sesion c where c.cliente.id = ?1")
    List<Carrito> getCarritoDeUsuario(Long idUsuario);

    @Query("select u from Sesion u where u.cliente.id = ?1")
    List<Sesion> getSesionParaCliente(Long id);


}