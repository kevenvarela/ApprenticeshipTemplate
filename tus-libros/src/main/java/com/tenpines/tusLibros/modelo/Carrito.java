package com.tenpines.tusLibros.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Carrito implements Serializable, Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PackDeLibros> items;

    public Carrito(){
    }

    public static Carrito crearCarrito(){
        Carrito carrito = new Carrito();
        carrito.setItems(new HashSet<PackDeLibros>());
        return carrito;
    }
    //PERSISTENCIA

    private void setId(Long unId) {
        this.id = unId;
    }

    public Long getId() {
        return id;
    }

    public void setItems(HashSet<PackDeLibros> items) {
        this.items = items;
    }

    public Set<PackDeLibros> getItems() {
        return items;
    }

    // METODOS


    public Boolean estaVacio() {
        return items.size() == 0;
    }
        //TODO: ARREGLAR TEST Y ARREGLAR RELACIONES

    public void agregarLibro(Libro unLibro, Integer cantidad) {
        this.verificarQueLaCantidadSeaValida(cantidad);
        if (this.yaEstaAgregado(unLibro)){
            this.actualizarCantidad(unLibro,cantidad);
        }
        else {
            this.agregarLibroCantidad(unLibro, cantidad);
        }
    }

    private void agregarLibroCantidad(Libro unLibro, Integer cantidad) {
        items.add(PackDeLibros.nuevoLibroEnCarrito(this ,unLibro,cantidad));
    }

    private void actualizarCantidad(Libro unLibro, Integer cantidad) {
        PackDeLibros libroBuscado = items.stream().filter(libroPorCarrito -> libroPorCarrito.getLibro().equals(unLibro)).findFirst().get();
        libroBuscado.setCantidad(libroBuscado.getCantidad() + cantidad);
    }

    private boolean yaEstaAgregado(Libro unLibro) {
        return items.stream().anyMatch(libroPorCarrito -> libroPorCarrito.getLibro().equals(unLibro));
    }

//    public void agregarLibro(Libro unLibro, Integer cantidad) {
//        this. verificarQueLaCantidadSeaValida(cantidad);
//        for (int i=0; i<cantidad; i++) {
//            items.add(unLibro);
//        }
//    }

    private void verificarQueLaCantidadSeaValida(Integer cantidad) {
        if (cantidad <= 0){
            throw new RuntimeException(mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa());
        }
    }

    public static String mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa() {
        return "La cantidad de libros a agregar debe ser mayor a 0";
    }


    public Boolean contiene(Libro unItem) {
        return items.stream().anyMatch(pack -> pack.getLibro().equals(unItem));
    }

    public Integer contidadDeUnItem(final Libro unItem) {
        return Math.toIntExact(
                items.stream().filter(pack -> pack.getLibro().equals(unItem)).findFirst().get().getCantidad());
    }

    public Integer cantidadTotalDeItems() {
        return items.size();
    }

    @Override
    public boolean equals(Object objeto){
        if (objeto == null){
            return false;
        }
        if (!(objeto instanceof Carrito)){
            return false;
        }
        Carrito carrito = (Carrito) objeto;

        if(carrito.getItems().equals(this.getItems())){
            return false;
        }

        return true;
    }


}
