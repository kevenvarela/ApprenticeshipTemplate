package com.tenpines.tusLibros.web;

public class Endpoints {
    public static final String HOME = "";
    public static final String OBTENER_CARRITO = HOME + "/carts";
    public static final String AGREGAR_ITEM = HOME + "/addToCart";// post /carts/:cart_id/books
    public static final String MOSTRAR_ITEMS = HOME + "/listCart";
    public static final String LOGUEAR_CLIENTE = HOME + "/loguearCliente";
    public static final String OBTENER_CLIENTE = HOME + "/obtenerClientes";
    public static final String COBRAR_CARRITO = HOME + "/checkoutCart";
    public static final String COBRAR_CARRITO_PAGINA = "/cobrarCarrito";
    public static final String LISTAR_VENTAS = "/listarVentas";

    public static final String LIBROS = "/libros";
    public static final String REGISTRAR = "/nuevoClientes";
    public static final String CARRITO = HOME + "/clientes";
}
