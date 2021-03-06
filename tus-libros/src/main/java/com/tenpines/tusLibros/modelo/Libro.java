package com.tenpines.tusLibros.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Libro implements Serializable, Cloneable{

    public static Libro crearLibro(String nombreLibro, String isbn, Integer precio){
        verificaQueTengaTodosLosAtributos(nombreLibro, isbn, precio);
        Libro libro = new Libro();
        libro.setNombreLibro(nombreLibro);
        libro.setIsbn(isbn);
        libro.setPrecio(precio);
        return libro;
    }

    public Libro(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    public String nombreLibro;

    @Column(nullable=false)
    public String isbn;

    @Column(nullable=false)
    public Integer precio;
    //TODO: Cambiar a Float.



    public String getNombreLibro(){
        return nombreLibro;
    }

    public void setNombreLibro(String unLibro) {
        this.nombreLibro = unLibro;
    }

    public Long getId(){ return this.id;}

    public void setId(Long id){ this.id = id;}

    public String getIsbn(){ return this.isbn;}

    public void setIsbn(String isbn){this.isbn = isbn;}

    public Integer getPrecio(){ return this.precio;}

    public void setPrecio(Integer precio){ this.precio = precio;}

    private static void verificaQueTengaTodosLosAtributos(String nombreLibro, String isbn, Integer precio) {
        if (nombreLibro == null || isbn == null || precio == null){
            throw new RuntimeException(mensajeDeErrorCuandoQuieroCrearUnLibroInvalido());
        }
    }

    public static String mensajeDeErrorCuandoQuieroCrearUnLibroInvalido(){
        return "El libro que intenta agregar es invalido";
    }

    @Override
    public boolean equals(Object objeto){
        if (objeto == null){
            return false;
        }
        if (!(objeto instanceof Libro)){
            return false;
        }
        Libro libro = (Libro) objeto;

        if (!(Objects.equals(libro.getNombreLibro(), this.getNombreLibro()))){
            return false;
        }
        if (!(Objects.equals(libro.getIsbn(), this.getIsbn()))){
            return false;
        }
        return true;
    }

    public boolean igualId(Object algo){
        if(algo == this.getId()){
            return true;
        }
        return false;
    }

    public boolean contieneEsteId(Long id){
       return this.igualId(id);
    }
}

