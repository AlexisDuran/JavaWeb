/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.Alumno_materiaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class Alumno_materia {
    private int id,materiaId,alumnoId;Alumno_materiaDAO alumno_materiaDAO;
    public Alumno_materia(){alumno_materiaDAO = new Alumno_materiaDAO();}
    public Alumno_materia(int id, int materiaId, int alumnoId){
        this.id = id;
        this.materiaId = materiaId;
        this.alumnoId = alumnoId;
        alumno_materiaDAO = new Alumno_materiaDAO();
    }
    public Alumno_materia(int materiaId, int alumnoId){
        this.materiaId = materiaId;
        this.alumnoId = alumnoId;
        alumno_materiaDAO = new Alumno_materiaDAO();
    }
    
    public void insertarMateria(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        alumno_materiaDAO.insertarMateriaDB(alumno_materia);
    }
    public void eliminarMateria(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        alumno_materiaDAO.eliminarMateriaDB(alumno_materia);
    }
    public List buscarRegistro(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        List lista = alumno_materiaDAO.buscarRegistroDB(alumno_materia);
        return lista;
    }
    public void editarMateria(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        alumno_materiaDAO.editarMateriaDB(alumno_materia);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }
}
