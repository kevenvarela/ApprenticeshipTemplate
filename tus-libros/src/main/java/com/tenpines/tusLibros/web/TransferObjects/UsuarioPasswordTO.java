package com.tenpines.tusLibros.web.TransferObjects;

/**
 * Created by Aye on 29/09/16.
 */
public class UsuarioPasswordTO {

    public Long usuario;
    public String password;

    public Long getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UsuarioPasswordTO(){}

    public static UsuarioPasswordTO crearUsuarioPasswordTO(Long idUsuario, String password){
        UsuarioPasswordTO usuarioPasswordTO = new UsuarioPasswordTO();
        usuarioPasswordTO.setUsuario(idUsuario);
        usuarioPasswordTO.setPassword(password);
        return usuarioPasswordTO;
    }

}
