package com.tenpines.starter.modelo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne
    @Column
    private ArrayList<String> items = new ArrayList<String>();

    @OneToOne
    private Cliente cliente;


    public Carrito(){
    }

    //PERSISTENCIA

    private void setId(Integer unId) {
        this.id = unId;
    }

    public Integer getId() {
        return id;
    }

    public void setItems(ArrayList<String> unItem) {
        this.items = unItem;
    }

    public ArrayList<String> getItems() {
        return items;
    }

//    public String getCliente() {
//        return cliente;
//    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    // METODOS
//    @Column
//    public ArrayList<String> catalogo = new ArrayList<String>();
//
//    public void inicializarCatalogo(){
//        catalogo.add("Guerra de los mundos");
//        catalogo.add("El perfume");
//        catalogo.add("Nacidos de la bruma");
//    }
//
//    public ArrayList<String> catalogo(){
//        return catalogo;
//    }

    public Boolean estaVacio() {
        return items.size() == 0;
    }

    public void agregarLibro(String unItem, Integer cantidad) {
//        this.verificarQueElItemSeaValido(unItem);
        this. verificarQueLaCantidadSeaValida(cantidad);
        for (int i=0; i<cantidad; i++) {
            items.add(unItem);
        }
    }

//    private void verificarQueElItemSeaValido(String unItem) {
//        if (!catalogo.contains(unItem)){
//            throw new RuntimeException(mensajeDeErrorCuandoUnLibroNoEsValido());
//        }
//    }

    private void verificarQueLaCantidadSeaValida(Integer cantidad) {
        if (cantidad <= 0){
            throw new RuntimeException(mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa());
        }
    }

    public static String mensajeDeErrorCuandoUnLibroNoEsValido() {
        return "El libro no corresponde a esta editorial";
    }

    public static String mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa() {
        return "La cantidad de libros a agregar debe ser mayor a 0";
    }


    public Boolean contiene(String unItem) {
        return items.contains(unItem);
    }

    public Integer contidadDeUnItem(final String unItem) {
        return Math.toIntExact(
                items.stream().filter((item) -> item.equals(unItem)).count());
    }

    public Integer cantidadTotalDeItems() {
        return items.size();
    }

    public ArrayList<String> contenido(){
        return items;
    }

}
