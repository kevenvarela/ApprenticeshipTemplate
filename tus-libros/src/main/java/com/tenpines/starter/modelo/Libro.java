package com.tenpines.starter.modelo;


import javax.persistence.*;

@Entity
public class Libro {

    public static Libro crearLibro(String nombreLibro, String isbn, Integer precio){
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

    @Column
    public String nombreLibro;

    @Column
    public String isbn;

    @Column
    public Integer precio;
    //TODO: Cambiar a BigDecimal.


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


}

