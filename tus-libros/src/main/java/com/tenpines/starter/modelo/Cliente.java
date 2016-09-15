package com.tenpines.starter.modelo;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@OneToOne(cascade= CascadeType.ALL)
    private Long id_cliente;

    @Column
    public String password;

    public Cliente(){
    }

    //PERSISTENCIA
    private void setId_cliente(Long unId) {
        this.id_cliente = unId;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    private void setPassword(String pass){this.password = pass;}

    public String getPassword(){
        return password;
    }

}
