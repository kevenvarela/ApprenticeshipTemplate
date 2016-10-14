package com.tenpines.tusLibros.web.TransferObjects;

/**
 * Created by Aye on 29/09/16.
 */
public class UsuarioPasswordTO {

    public Long id;
    public String password;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UsuarioPasswordTO(){}

    public static UsuarioPasswordTO crearUsuarioPasswordTO(Long idUsuario, String password){
        UsuarioPasswordTO usuarioPasswordTO = new UsuarioPasswordTO();
        usuarioPasswordTO.setId(idUsuario);
        usuarioPasswordTO.setPassword(password);
        return usuarioPasswordTO;
    }

}
