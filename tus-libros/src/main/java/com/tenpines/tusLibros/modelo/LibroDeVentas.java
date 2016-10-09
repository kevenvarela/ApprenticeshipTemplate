package com.tenpines.tusLibros.modelo;


import java.util.ArrayList;
import java.util.List;


public class LibroDeVentas {

    public List<VentaConcretada> getVentasConcretadas() {
        return ventasConcretadas;
    }

    public void setVentasConcretadas(List<VentaConcretada> ventasConcretadas) {
        this.ventasConcretadas = ventasConcretadas;
    }

    private List<VentaConcretada> ventasConcretadas = new ArrayList<VentaConcretada>();

    public void registrarVenta(VentaConcretada venta) {
        ventasConcretadas.add(venta);
    }
}

