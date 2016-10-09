package com.tenpines.tusLibros.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PackDeLibros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    public Libro libro;

    @Column
    public Integer cantidad;


    @ManyToOne
    public Carrito carito;

    public PackDeLibros(){
    }

    public static PackDeLibros nuevoLibroEnCarrito(Carrito carrito, Libro libro, Integer cantidad){
        PackDeLibros libroPorCarrito = new PackDeLibros();
        libroPorCarrito.setLibro(libro);
        libroPorCarrito.setCantidad(cantidad);
        libroPorCarrito.setCarrito(carrito);
        return libroPorCarrito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Carrito getCarrito() {
        return carito;
    }

    public void setCarrito(Carrito carito) {
        this.carito = carito;
    }

    @Override
    public boolean equals(Object objeto){
        if (objeto == null){
            return false;
        }
        if (!(objeto instanceof PackDeLibros)){
            return false;
        }
        PackDeLibros pack = (PackDeLibros) objeto;

        if (!(pack.getLibro().equals(this.getLibro()))){
            return false;
        }
        if (!(pack.getCarrito().equals(this.getCarrito()))){
            return false;
        }
        return true;
    }
}
