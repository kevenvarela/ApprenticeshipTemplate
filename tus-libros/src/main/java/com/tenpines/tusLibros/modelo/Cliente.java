package com.tenpines.tusLibros.modelo;

import javax.persistence.*;


@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    public String password;

    //PERSISTENCIA
    private void setId(Long unId) {
        this.id = unId;
    }

    public Long getId() {
        return id;
    }

    private void setPassword(String pass){this.password = pass;}

    public String getPassword() {return password;}

    public Cliente(){}

    public static Cliente crearCliente(String password) {
        Cliente cliente = new Cliente();
        cliente.setPassword(password);
        return cliente;
    }
}
