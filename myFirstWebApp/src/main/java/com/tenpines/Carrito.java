package com.tenpines;

//import org.assertj.core.api.AbstractBigDecimalAssert;

import java.util.ArrayList;

public class Carrito {

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

    public Integer contidadTotalDeItems() {
        return items.size();
    }

    public ArrayList<String> contenido(){
        return items;
    }
}
