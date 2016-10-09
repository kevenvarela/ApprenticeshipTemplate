package com.tenpines.tusLibros.modelo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class VentaConcretada implements Serializable, Cloneable{

    public VentaConcretada(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    public Carrito carrito;

    @Column
    public Integer precioTotal;

    @Column
    @Type(type="timestamp")
    private Timestamp fechaYHoraDeVenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrito getCarrito(){return this.carrito;}

    public void setCarrito(Carrito carrito) {this.carrito = carrito;}

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDateTime getFechaYHoraDeVenta() {
        return fechaYHoraDeVenta.toLocalDateTime();
    }

    public void setFechaYHoraDeVenta(Timestamp fechaYHoraDeVenta) {
        this.fechaYHoraDeVenta = fechaYHoraDeVenta;
    }

    public static VentaConcretada nuevaVentaConcretada(Carrito unCarrito, Integer precioTotal, LocalDateTime fechaYHoraDeVenta){
        VentaConcretada ventaConcretada = new VentaConcretada();
        ventaConcretada.setCarrito(unCarrito);
        ventaConcretada.setPrecioTotal(precioTotal);
        ventaConcretada.setFechaYHoraDeVenta(Timestamp.valueOf(fechaYHoraDeVenta));
        return ventaConcretada;
    }
}
