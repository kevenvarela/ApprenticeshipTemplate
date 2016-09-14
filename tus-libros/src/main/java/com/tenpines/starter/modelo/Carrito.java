package com.tenpines.starter.modelo;

import com.tenpines.starter.rest.AgregarRequest;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Carrito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToMany
    private ArrayList<String> items = new ArrayList<String>();

    private String cliente;

    public Carrito(){
    }

    public Carrito(AgregarRequest carrito) {
        this.inicializarCatalogo();
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

//    public void setCliente(String cliente) {
//        this.cliente = cliente;
//    }


    // METODOS
    private ArrayList<String> catalogo = new ArrayList<String>();

    public void inicializarCatalogo(){
        catalogo.add("Guerra de los mundos");
        catalogo.add("El pergume");
        catalogo.add("Nacidos de la bruma");
    }


    public Boolean estaVacio() {
        return items.size() == 0;
    }

    public void agregarItem(String unItem) {
        this.verificarQueElItemSeaValido(unItem);
        items.add(unItem);
    }

    private void verificarQueElItemSeaValido(String unItem) {
        if (!catalogo.contains(unItem)){
            throw new RuntimeException(mensajeDeErrorCuandoUnLibroNoEsValido());
        }
    }

    public static String mensajeDeErrorCuandoUnLibroNoEsValido() {
        return "El libro no corresponde a esta editorial";
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
