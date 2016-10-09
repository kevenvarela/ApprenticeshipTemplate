package com.tenpines.tusLibros.web.TransferObjects;

/**
 * Created by Aye on 04/10/16.
 */
public class SesionConClienteTO {

    public Long clienteId;
    public Long sesionId;
    public Long carrito;

    public Long getClienteId() {
        return clienteId;
    }

    public Long getSesionId() {
        return sesionId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setSesionId(Long sesionId) {
        this.sesionId = sesionId;
    }

    public Long getCarrito() {
        return carrito;
    }

    public void setCarrito(Long carrito) {
        this.carrito = carrito;
    }

    public SesionConClienteTO(){}

    public static SesionConClienteTO crearSesionConCliente(Long sesionId, Long clienteId, Long carritoId){
        SesionConClienteTO unaSesionConCliente = new SesionConClienteTO();
        unaSesionConCliente.setClienteId(clienteId);
        unaSesionConCliente.setSesionId(sesionId);
        unaSesionConCliente.setCarrito(carritoId);
        return unaSesionConCliente;
    }
}
