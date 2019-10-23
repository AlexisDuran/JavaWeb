/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Materia;
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
public class MateriaDAO {
    Connection conexion = null;
    Materia materia;
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }private void cerrarConexion() throws SQLException{conexion.close();}
    
    public void insertarMateriaDB(Materia materia) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "insert into materia(nombre,clave,estatus) VALUES ('"+materia.getNombre()+"',"+materia.getClave()+","+materia.getEstatus()+");";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
    public List obtenerMateriaDB() throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM materia;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setClave(rs.getInt("clave"));
                materia.setEstatus(rs.getInt("estatus"));
                lista.add(materia);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM materia;
    
    public List buscarMateriaNombreDB(Materia materia) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM materia where nombre = '"+ materia.getNombre() +"';";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                materia = new Materia();
                
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setClave(rs.getInt("clave"));
                materia.setEstatus(rs.getInt("estatus"));
                lista.add(materia);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM materia where nombre = "+  +";
    
    public List buscarMateriaClaveDB(Materia materia) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM materia where clave = "+ materia.getClave()+";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                materia = new Materia();
                
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setClave(rs.getInt("clave"));
                materia.setEstatus(rs.getInt("estatus"));
                lista.add(materia);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM materia where clave = "+  +";
    public List buscarMateriaEstatusDB(Materia materia) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM materia where estatus = "+ materia.getEstatus()+";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                materia = new Materia();
                
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setClave(rs.getInt("clave"));
                materia.setEstatus(rs.getInt("estatus"));
                lista.add(materia);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM materia where estatus = "+  +";
    
    public void editarMateriaDB(Materia materia) throws SQLException, ClassNotFoundException{
        try{
            this.abrirConexion();
            String sql = "update materia set nombre = '"+materia.getNombre()+"' ,clave="+materia.getClave()+",estatus="+materia.getEstatus()+" where id = "+materia.getId()+";";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//update materia set nombre = '?',clave = ? ,estatus = ? where id = ?;
    
    public void eliminarMateriaDB(Materia materia) throws ClassNotFoundException, SQLException {
        try{
            this.abrirConexion();
            String sql = "delete from materia where id = "+materia.getId()+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
}//fin
