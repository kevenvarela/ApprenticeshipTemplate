package com.tenpines.tusLibros.servicios;

import com.tenpines.tusLibros.modelo.*;
import com.tenpines.tusLibros.repositorios.RepositorioDeSesiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ServicioDeSesion {

    @Autowired
    private ServicioDeCarritos servicioDeCarritos;

    @Autowired
    private ServicioDeCliente servicioDeCliente;

    @Autowired
    private RepositorioDeSesiones repositorio;

    @Autowired
    private ServicioDeVentasConcretadas servicioDeVentasConcretadas;

    private RelojDePrueba reloj = new RelojDePrueba(LocalDateTime.now().getHour(),LocalDateTime.now().getMinute());

    public Sesion crearCarrito(Cliente unCliente) {
        Carrito carrito = servicioDeCarritos.nuevoCarrito();
        Sesion nuevaSesion = Sesion.crearSesion(carrito,unCliente);
        repositorio.save(nuevaSesion);
        return nuevaSesion;
    }

    public Set<PackDeLibros> mostrarLibrosDeCarrito(Long carritoId) {
        Sesion laSesion = buscarSesionParaElCarrito(carritoId);
        chequearSesionExpiradaYActulizarUltimoUso(laSesion);
        return servicioDeCarritos.mostrarLibrosDeCarrito(laSesion.getCarrito().getId());
    }

    private void actualizarUltimoUsoDeSesion(Sesion sesion) {
        sesion.setUltimoUso(reloj.horaActual());
        repositorio.save(sesion);
    }

    private static String mensajeDeErrorCuandoNoExisteElCarritoQueQuiero() {
        return "No existe el carrito del que quiere ver el contenido";
    }

    private Sesion buscarSesionParaElCarrito(Long carritoId) {
        Sesion sesion = repositorio.getSesion(carritoId);
        if (sesion == null){
            throw new RuntimeException(mensajeDeErrorCuandoNoExisteElCarritoQueQuiero());
        }
        return sesion;
    }

//    private Sesion buscarSesionParaElCarrito(Long carritoId) {
//        try {
//            Sesion sesion = repositorio.getSesion(carritoId);
//            return sesion;}
//        catch (RuntimeException NoExisteElCarrito) {
//                throw new RuntimeException(mensajeDeErrorCuandoNoExisteElCarritoQueQuiero());
//        }
//    }

    public void agregarLibro(Sesion sesion, Long idLibro, Integer cantidad) {
        chequearSesionExpiradaYActulizarUltimoUso(sesion);
        servicioDeCarritos.agregarLibro(sesion.getCarrito(),idLibro,cantidad);
    }

    private void chequearSesionExpiradaYActulizarUltimoUso(Sesion sesion) {
        sesion.chequearSesionExpirada(reloj);
        actualizarUltimoUsoDeSesion(sesion);
    }

    public Set<PackDeLibros> obtenerUnCarrito(Long id){
        Sesion sesion = buscarSesionParaElCarrito(id);
        chequearSesionExpiradaYActulizarUltimoUso(sesion);
        return servicioDeCarritos.mostrarLibrosDeCarrito(id);
    }

    public void cobrarCarrito(Long carritoId, String nombreDeDuenio,Long numeroDeTarjeta, LocalDate fechaDeExpiracion) {
        Sesion sesion = buscarSesionParaElCarrito(carritoId);
        chequearSesionExpiradaYActulizarUltimoUso(sesion);
        Carrito carrito = servicioDeCarritos.buscarElCarrito(carritoId);
        TarjetaDeCredito tarjetaValidada = TarjetaDeCredito.nuevaTarjeta(numeroDeTarjeta, fechaDeExpiracion, nombreDeDuenio);
        servicioDeVentasConcretadas.concretarVenta(carrito, tarjetaValidada);
    }

    public List<VentaConcretada> mostrarVentasParaUnCliente(Cliente cliente, String password) {
        servicioDeCliente.loguearCliente(cliente.getId(), password);
        List<Carrito> listaDeCarritos = repositorio.getCarritoDeUsuario(cliente.getId());
        return servicioDeVentasConcretadas.mostrarVentasDeCarritos(listaDeCarritos);
    }


//      Lo comento porque sé que en algún momento sirvió.
//    private Sesion buscarSesionParaElCliente(Long id) {
//        try {
//            List<Sesion> sesion = repositorio.getSesionParaCliente(id, em);
//            return sesion.get(sesion.size()-1);}
//        catch (RuntimeException NoHaySesionParaElUsuarioIngresado) {
//
//            throw new RuntimeException(mensajeDeErrorCuandoNoExisteSesionParaElUsuarioSeleccionado());
//        }
//
//    }
//
//    private static String mensajeDeErrorCuandoNoExisteSesionParaElUsuarioSeleccionado() {
//        return "No existe sesión para el cliente ingresado";
//    }

    public List<Sesion> mostrarSesiones(){
        return repositorio.findAll();
    }

}

