package com.tenpines.tusLibros.web;

import com.tenpines.tusLibros.modelo.*;
import com.tenpines.tusLibros.servicios.ServicioDeCatalogo;
import com.tenpines.tusLibros.servicios.ServicioDeCliente;
import com.tenpines.tusLibros.servicios.ServicioDeSesion;
import com.tenpines.tusLibros.web.TransferObjects.SesionConClienteTO;
import com.tenpines.tusLibros.web.TransferObjects.UsuarioPasswordTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class CarritoController extends GlobalExceptionHandlingController{

    private ServicioDeCatalogo servicioCatalogo;
    private ServicioDeSesion servicioDeSesion;
    @Autowired
    private ServicioDeCliente servicioDeCliente;


    private Cliente unCliente;
    private Carrito unCarrito;
    private List<Libro> itemsCarrito = new ArrayList<Libro>();

    @Autowired
    public CarritoController(ServicioDeSesion servicioDeSesion, ServicioDeCatalogo servicioDeCatalogo) {
        this.servicioCatalogo = servicioDeCatalogo;
        this.servicioDeSesion = servicioDeSesion;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("itemsCarrito", itemsCarrito);
        model.addAttribute("carrito", unCarrito);
        model.addAttribute("cliente", unCliente);
        model.addAttribute("libros", catalogo());
        return "nuevaCompra";
    }

    @RequestMapping(Endpoints.COBRAR_CARRITO_PAGINA)
    String cobrarCarrito(Model model) {
        return "cobrarCarrito";
    }


    @RequestMapping(value = Endpoints.AGREGAR_CARRITO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    SesionConClienteTO crearUnCarrito(@RequestBody UsuarioPasswordTO usuarioPasswordTO, HttpServletResponse response) throws IOException {
        Cliente unCliente = servicioDeCliente.buscarElCliente(usuarioPasswordTO.getIdUsuario());
        Sesion sesion = servicioDeSesion.crearCarrito(unCliente);
        SesionConClienteTO sesionConClienteTO = SesionConClienteTO.crearSesionConCliente(sesion.getId_sesion(),unCliente.getId(),sesion.getCarrito().getId());
        return sesionConClienteTO;
    }

//    @RequestMapping(value = Endpoints.AGREGAR_ITEM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    void agregarUnLibro(@RequestParam Map<String,String> requestParams, HttpServletResponse response) throws IOException {
//        Long idLibro = Long.valueOf(requestParams.get("libro"));
//        Integer cantidad = Integer.valueOf(requestParams.get("cantidad"));
//        servicioDeSesion.agregarLibro(sesion,idLibro,cantidad);
//        itemsCarrito = servicioDeSesion.mostrarLibrosDeCarrito(sesion.getCarrito().getId());
//        response.sendRedirect("/listCart?" + "carrito=" + sesion.getCarrito().getId()); //TODO VER COMO SE HACE PARA USAR EL ENDPOINT Y PASARLE UN PARAMETRO
//    }

    @RequestMapping(value=Endpoints.MOSTRAR_ITEMS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    Set<PackDeLibros> obtenerLibro(@RequestParam(value = "carrito") Carrito unCarrito){
        return servicioDeSesion.mostrarLibrosDeCarrito(unCarrito.getId());
    }

    @RequestMapping(value = Endpoints.LOGUEAR_CLIENTE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    private Cliente loguearCliente(@RequestParam Map<String,String> requestParams , HttpServletResponse response) throws IOException {
        Long idUsuario = Long.valueOf(requestParams.get("nombre"));
        String password = requestParams.get("password");

        unCliente = servicioDeCliente.clienteLogueado(idUsuario, password);
        return unCliente;
    }

    @RequestMapping(value=Endpoints.OBTENER_CLIENTE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<Cliente> obtenerCliente(){
        return servicioDeCliente.mostrarClientes();
    }

    @RequestMapping(value=Endpoints.LISTAR_VENTAS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<VentaConcretada> obtenerVentasParaUnCliente(@RequestBody UsuarioPasswordTO usuarioPasswordTO){
        Cliente cliente = getCliente(usuarioPasswordTO.getIdUsuario());
        return servicioDeSesion.mostrarVentasParaUnCliente(cliente, usuarioPasswordTO.getPassword());
    }

    private Cliente getCliente(Long unId) {
        return servicioDeCliente.buscarElCliente(unId);
    }


//    @RequestMapping(value = Endpoints.COBRAR_CARRITO, method = RequestMethod.POST)
//    void checkoutearCarrito(@RequestParam Map<String,String> requestParams, HttpServletResponse response) throws IOException {
//
//        Long idCarrito = sesion.getCarrito().getId();   //TODO RECIBIR POR PARAMETRO ID_CARRITO
//
//        Long numeroTarjeta = Long.valueOf(requestParams.get("numeroTarjeta"));
//
//        Integer anioExpiracion = Integer.valueOf(requestParams.get("anioExpiracion"));
//        Integer mesExpiracion = Integer.valueOf(requestParams.get("mesExpiracion"));
//
//        String nombreCliente = requestParams.get("nombreDuenio");
//
//        LocalDate fechaExpiracion = LocalDate.of(anioExpiracion,mesExpiracion,1); //yyyy-mm-dd
//
//        servicioDeSesion.cobrarCarrito(idCarrito, nombreCliente, numeroTarjeta, fechaExpiracion);
//        response.sendRedirect(Endpoints.HOME);
//    }
//

    private Iterable<Libro> catalogo(){
        return servicioCatalogo.mostrarCatalogo();
    }

//    private Carrito mostrarCarritoActual() {
//        return obtenerUnCarrito();
//    }

//    private Carrito obtenerUnCarrito(){
//        return sesion.getCarrito();
//    }

    private Set<PackDeLibros> itemsDeCarrito(Long idCarrito){
        Set<PackDeLibros> carrito = servicioDeSesion.obtenerUnCarrito(idCarrito);
        return  carrito;
    }
}
