/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.MateriaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class Materia {
    private int id,clave,estatus;
    private String nombre;
    private MateriaDAO materiaDAO;
    public Materia(){materiaDAO = new MateriaDAO();}
    public Materia(String nombre, int clave, int estatus){
        this.nombre = nombre;
        this.clave = clave;
        this.estatus = estatus;
        materiaDAO = new MateriaDAO();
    }
    public Materia(int id, String nombre, int clave, int estatus){
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.estatus = estatus;
        materiaDAO = new MateriaDAO();
    }
    
    public void insertarMateria(Materia materia) throws SQLException, ClassNotFoundException{
        materiaDAO.insertarMateriaDB(materia);
    }
    
    public List obtenerMateria() throws ClassNotFoundException{
        List lista =  materiaDAO.obtenerMateriaDB();
        return lista;
    }

    public List buscarMateriaNombre(Materia materia) throws ClassNotFoundException{
        List lista = materiaDAO.buscarMateriaNombreDB(materia);
        return lista;
    }
    public List buscarMateriaClave(Materia materia) throws ClassNotFoundException{
        List lista = materiaDAO.buscarMateriaClaveDB(materia);
        return lista;
    }
    public List buscarMateriaEstatus(Materia materia) throws ClassNotFoundException{
        List lista = materiaDAO.buscarMateriaEstatusDB(materia);
        return lista;
    }
    public void editarMateria(Materia materia) throws SQLException, ClassNotFoundException{
        materiaDAO.editarMateriaDB(materia);
    }
    public void eliminarMateria(Materia materia) throws ClassNotFoundException, SQLException{
        materiaDAO.eliminarMateriaDB(materia);
        //unos no se eliminan por las llaves foraneas de la base de datos ...
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
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
}
