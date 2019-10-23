/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.AdministradorDAO;
import java.sql.SQLException;

/**
 *
 * @author Equipo16
 */
public class Administrador {
    private int id; 
    private String usuario, contraseña;
    private AdministradorDAO administradorDao ;
    public Administrador(){
        this.administradorDao = new AdministradorDAO();
    }
    public Administrador(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.administradorDao = new AdministradorDAO();
    }
    public Administrador(int id,String usuario, String contraseña){
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    
    public boolean validarAdministrador(Administrador admin) throws SQLException, ClassNotFoundException{
        boolean condition = this.administradorDao.validarBasededatos(admin);
        return condition;
    }
}
