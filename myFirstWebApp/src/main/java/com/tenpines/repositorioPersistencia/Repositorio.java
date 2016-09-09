package com.tenpines.repositorioPersistencia;

import java.util.ArrayList;
import java.util.HashMap;

public class Repositorio {

    HashMap<String, String> listaDeItems = new HashMap<String, String>();

    public void guardar(String id,String unItem){
        listaDeItems.put(id, unItem);
    }

    public String tomar(String id){
        String unItem = listaDeItems.get(id);
        return unItem;
    }
}
