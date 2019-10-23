/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.MaestroDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class Maestro {
    private int id,no_empleado,tipoEmpleadoId,estatus;
    private String nombre,usuario,contraseña;
    private MaestroDAO maestroDAO;
    public Maestro(){maestroDAO = new MaestroDAO();}
    public Maestro(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        maestroDAO = new MaestroDAO();
    }
    public Maestro(String nombre,String usuario, String contraseña, int no_empleado,int tipoEmpleadoId, int estatus){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.no_empleado = no_empleado;
        this.tipoEmpleadoId = tipoEmpleadoId;
        this.estatus = estatus;
        maestroDAO = new MaestroDAO();
    }
     public Maestro(int id,String nombre,String usuario, String contraseña, int no_empleado,int tipoEmpleadoId, int estatus){
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.no_empleado = no_empleado;
        this.tipoEmpleadoId = tipoEmpleadoId;
        this.estatus = estatus;
        maestroDAO = new MaestroDAO();
    }
    
    public boolean validarMestro(Maestro maestro) throws ClassNotFoundException, SQLException{
        boolean condition = maestroDAO.validarMaestroDB(maestro);
        return condition;
    }
    public void insertarMaestro(Maestro maestro) throws ClassNotFoundException, SQLException{
      maestroDAO.insertarMaestroDB(maestro);
    }
        
    public List obtenerMaestro() throws ClassNotFoundException{
        List lista =  maestroDAO.obtenerMaestroDB();
        return lista;
    }
    
    public List buscarMaestroNombre(Maestro maestro) throws ClassNotFoundException{
        List lista = maestroDAO.buscarMaestroNombreDB(maestro);
        return lista;
    }
    public List buscarMaestroUsuario(Maestro maestro) throws ClassNotFoundException{
        List lista = maestroDAO.buscarMaestroUsuarioDB(maestro);
        return lista;
    }
    public List buscarMaestroNo_empleado(Maestro maestro) throws ClassNotFoundException{
        List lista = maestroDAO.buscarMaestroNo_empleadoDB(maestro);
        return lista;
    }
    public List buscarMaestroTipoEmpleadoId(Maestro maestro) throws ClassNotFoundException{
        List lista = maestroDAO.buscarMaestroTipoEmpleadoIdDB(maestro);
        return lista;
    }
    public List buscarMaestroEstatus(Maestro maestro) throws ClassNotFoundException{
        List lista = maestroDAO.buscarMaestroEstatusDB(maestro);
        return lista;
    }
    
     public void editarMaestro(Maestro maestro) throws SQLException, ClassNotFoundException{
        maestroDAO.editarMaestroDB(maestro);
    }
    public void eliminarMaestro(Maestro maestro) throws ClassNotFoundException, SQLException{
        maestroDAO.eliminarMaestroDB(maestro);
        //unos no se eliminan por las llaves foraneas de la base de datos ...
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_empleado() {
        return no_empleado;
    }

    public void setNo_empleado(int no_empleado) {
        this.no_empleado = no_empleado;
    }

    public int getTipoEmpleadoId() {
        return tipoEmpleadoId;
    }

    public void setTipoEmpleadoId(int tipoEmpleadoId) {
        this.tipoEmpleadoId = tipoEmpleadoId;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
