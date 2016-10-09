package com.tenpines.tusLibros.repositorios;


import com.tenpines.tusLibros.modelo.VentaConcretada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RepositorioDeVentasConcretadas extends JpaRepository<VentaConcretada, Long> {

    @Query("select c from VentaConcretada c where c.carrito.id = :id")
    List<VentaConcretada> getVentasParaElCarrito(Long id);

}
