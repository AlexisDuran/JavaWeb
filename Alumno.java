/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.AlumnoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class Alumno {
    private int id,matricula,estatus;
    private String nombre, usuario,contraseña;
    private AlumnoDAO alumnoDAO;
    public Alumno(){alumnoDAO = new AlumnoDAO();}
    public Alumno(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        alumnoDAO = new AlumnoDAO();
    }
    public Alumno(String nombre,String usuario,String contraseña,int matricula,int estatus){
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.matricula = matricula;
        this.estatus = estatus;
        alumnoDAO = new AlumnoDAO();
    }
    public Alumno(int id,String nombre,String usuario,String contraseña,int matricula,int estatus){
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.matricula = matricula;
        this.estatus = estatus;
        alumnoDAO = new AlumnoDAO();
    }
    
    public void altaMateria(){}
    
    public boolean validarAlumno(Alumno alumno) throws ClassNotFoundException, SQLException{
        boolean condition = alumnoDAO.validarAlumnoDB(alumno);
        return condition;
    }
    public void insertarAlumno(Alumno alumno) throws SQLException, ClassNotFoundException{
        alumnoDAO.insertarAlumnoDB(alumno);
    }
    
    public List obtenerAlumno() throws ClassNotFoundException{
        List lista =  alumnoDAO.obtenerAlumnoDB();
        return lista;
    }
    public void editarAlumno(Alumno alumno) throws SQLException, ClassNotFoundException{
        alumnoDAO.editarAlumnoDB(alumno);
    }
    public void eliminarAlumno(Alumno alumno) throws ClassNotFoundException, SQLException{
        alumnoDAO.eliminarAlumnoDB(alumno);
        //unos no se eliminan por las llaves foraneas de la base de datos ...
    }
    public List obtenerMaestro() throws ClassNotFoundException{
        List lista =  alumnoDAO.obtenerMaestroDB();
        return lista;
    }
    
    public List buscarAlumnoNombre(Alumno alumno) throws ClassNotFoundException{
        List lista = alumnoDAO.buscarAlumnoNombreDB(alumno);
        return lista;
    }
    public List buscarAlumnoUsuario(Alumno alumno) throws ClassNotFoundException{
        List lista = alumnoDAO.buscarAlumnoUsuarioDB(alumno);
        return lista;
    }
    public List buscarAlumnoMatricula(Alumno alumno) throws ClassNotFoundException{
        List lista = alumnoDAO.buscarAlumnoMatriculaDB(alumno);
        return lista;
    }
    public List buscarAlumnoEstatus(Alumno alumno) throws ClassNotFoundException{
        List lista = alumnoDAO.buscarAlumnoEstatusDB(alumno);
        return lista;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
