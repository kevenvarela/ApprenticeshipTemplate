package com.tenpines.starter.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Libro> items = new ArrayList<Libro>();

    @OneToOne
    private Cliente cliente;


    public Carrito(){
    }

    public static Carrito crearCarrito(Cliente unCliente){
        Carrito carrito = new Carrito();
        carrito.setCliente(unCliente);
        return carrito;
    }
    //PERSISTENCIA

    private void setId(Long unId) {
        this.id = unId;
    }

    public Long getId() {
        return id;
    }

    public void setItems(ArrayList<Libro> unItem) {
        this.items = unItem;
    }

    public List<Libro> getItems() {
        return items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    // METODOS

    private static Libro libro = new Libro();



    public Boolean estaVacio() {
        return items.size() == 0;
    }

    public void agregarLibro(Libro unLibro, Integer cantidad) {
        this.verificarQueLaCantidadSeaValida(cantidad);
        for (int i=0; i<cantidad; i++) {
            items.add(unLibro);
        }
    }

    private void verificarQueLaCantidadSeaValida(Integer cantidad) {
        if (cantidad <= 0){
            throw new RuntimeException(mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa());
        }
    }


    public static String mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa() {
        return "La cantidad de libros a agregar debe ser mayor a 0";
    }


    public Boolean contiene(Libro unItem) {
        return items.contains(unItem);
    }

    public Integer contidadDeUnItem(final Libro unItem) {
        return Math.toIntExact(
                items.stream().filter((item) -> item.equals(unItem)).count());
    }

    public Integer cantidadTotalDeItems() {
        return items.size();
    }

    public List<Libro> contenido(){
        return items;
    }

    public Long tuClienteId() {

        return cliente.getId();
    }

    public static Libro catalogo() {
        return libro;
    }
}
