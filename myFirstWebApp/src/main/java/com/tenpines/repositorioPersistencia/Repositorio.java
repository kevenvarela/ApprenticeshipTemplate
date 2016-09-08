package com.tenpines.repositorioPersistencia;

import java.util.ArrayList;

public class Repositorio {

    ArrayList<String> listaDeItems = new ArrayList<String>();

    public void guardar(String unItem){
        listaDeItems.add(unItem);
    }

    public String tomar(Integer id){
        String unItem = listaDeItems.get(id);
        return unItem;
    }
}
