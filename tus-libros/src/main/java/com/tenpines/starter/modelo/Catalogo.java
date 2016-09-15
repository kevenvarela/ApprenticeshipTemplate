package com.tenpines.starter.modelo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Catalogo {

    public Catalogo(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    public ArrayList<String> librosDisponibles = new ArrayList<String>();



    public void inicializarCatalogo(){
        librosDisponibles.add("Guerra de los mundos");
        librosDisponibles.add("El perfume");
        librosDisponibles.add("Nacidos de la bruma");
    }

    public ArrayList<String> getLibrosDisponibles(){
        return librosDisponibles;
    }

    public void setLibrosDisponibles(ArrayList<String> unCatalogo) {
        this.librosDisponibles = unCatalogo;
    }
}

