/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Grupo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DURAN
 */
public class GrupoDAO {
    Connection conexion = null;
    Grupo grupo;
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }private void cerrarConexion() throws SQLException{conexion.close();}
    
    public void insertarGrupoDB(Grupo grupo) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "insert into grupo(materiaid,cantidad,estatus) VALUES ("+grupo.getMateriaid()+","+grupo.getCantidad()+","+grupo.getEstatus()+");";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
    public List obtenerGrupoDB() throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM grupo;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Grupo grupo = new Grupo();
                
                grupo.setId(rs.getInt("id"));
                grupo.setMateriaid(rs.getInt("materiaid"));
                grupo.setCantidad(rs.getInt("cantidad"));
                grupo.setEstatus(rs.getInt("estatus"));
                lista.add(grupo);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM grupo;
    
    public List buscarGrupoMateriaidDB(Grupo grupo) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM grupo where materiaid = "+ grupo.getMateriaid()+";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                grupo = new Grupo();
                
                grupo.setId(rs.getInt("id"));
                grupo.setMateriaid(rs.getInt("materiaid"));
                grupo.setCantidad(rs.getInt("cantidad"));
                grupo.setEstatus(rs.getInt("estatus"));
                lista.add(grupo);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM grupo where materiaid = "+  +";
    
    public List buscarGrupoEstatusDB(Grupo grupo) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM grupo where estatus = "+ grupo.getEstatus()+";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                grupo = new Grupo();
                
                grupo.setId(rs.getInt("id"));
                grupo.setMateriaid(rs.getInt("materiaid"));
                grupo.setCantidad(rs.getInt("cantidad"));
                grupo.setEstatus(rs.getInt("estatus"));
                lista.add(grupo);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM grupo where estatus = "+  +";
    
    public void editarGrupoDB(Grupo grupo) throws SQLException, ClassNotFoundException{
        try{
            this.abrirConexion();
            String sql = "update grupo set materiaid = "+grupo.getMateriaid()+" ,cantidad="+grupo.getCantidad()+",estatus="+grupo.getEstatus()+" where id = "+grupo.getId()+";";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//update grupo set materiaid = '?',cantidad = ? ,estatus = ? where id = ?;
    
    public void eliminarGrupoDB(Grupo grupo) throws ClassNotFoundException, SQLException {
        try{
            this.abrirConexion();
            String sql = "delete from grupo where id = "+grupo.getId()+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
    
}//fin
