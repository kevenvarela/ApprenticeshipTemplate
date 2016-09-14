package com.tenpines.starter.modelo;

import com.tenpines.starter.rest.AgregarRequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private ArrayList<String> contenido = new ArrayList<String>();

    private String cliente;

    public Carrito(){
    }

    public Carrito(AgregarRequest carrito) {
    }

    //PERSISTENCIA

    private void setId(Integer unId) {
        this.id = unId;
    }

    public Integer getId() {
        return id;
    }

    public void setContenido(ArrayList<String> contenido) {
        this.contenido = contenido;
    }

    public ArrayList<String> getContenido() {
        return contenido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    // METODOS
    private ArrayList<String> items = new ArrayList<String>();

    public Boolean estaVacio() {
        return items.size() == 0;
    }

    public void agregarItem(String unItem) {
        this.verificarQueElItemSeaValido(unItem);
        items.add(unItem);
    }

    private void verificarQueElItemSeaValido(String unItem) {
        if (unItem.equals("INVALIDO")){
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
