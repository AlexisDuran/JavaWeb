/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.GrupoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class Grupo {
    private int id,materiaid,cantidad,estatus;
    private GrupoDAO grupoDAO;
    public Grupo(){grupoDAO = new GrupoDAO();}
    public Grupo(int materiaid, int cantidad, int estatus){
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.materiaid = materiaid;
        grupoDAO = new GrupoDAO();
    }
    public Grupo(int id, int materiaid, int cantidad, int estatus){
        this.id = id;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.materiaid = materiaid;
        grupoDAO = new GrupoDAO();
    }

    public void insertarGrupo(Grupo grupo) throws SQLException, ClassNotFoundException{
        grupoDAO.insertarGrupoDB(grupo);
    }
    public List obtenerGrupo() throws ClassNotFoundException{
        List lista =  grupoDAO.obtenerGrupoDB();
        return lista;
    }
    public List buscarGrupoMateriaid(Grupo grupo) throws ClassNotFoundException{
        List lista = grupoDAO.buscarGrupoMateriaidDB(grupo);
        return lista;
    }
    public List buscarGrupoEstatus(Grupo grupo) throws ClassNotFoundException{
        List lista = grupoDAO.buscarGrupoEstatusDB(grupo);
        return lista;
    }
    public void editarGrupo(Grupo grupo) throws SQLException, ClassNotFoundException{
        grupoDAO.editarGrupoDB(grupo);
    }
    public void eliminarGrupo(Grupo grupo) throws ClassNotFoundException, SQLException{
        grupoDAO.eliminarGrupoDB(grupo);
        //unos no se eliminan por las llaves foraneas de la base de datos ...
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(int materiaid) {
        this.materiaid = materiaid;
    }
}
