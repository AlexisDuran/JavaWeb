/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Alumno_materia;
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
public class Alumno_materiaDAO {
    Connection conexion = null;
     Alumno_materia alumno_materia;
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }private void cerrarConexion() throws SQLException{conexion.close();}
    
    public void insertarMateriaDB(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "insert into alumno_materia(materiaId,alumnoId) VALUES ("+alumno_materia.getMateriaId()+","+alumno_materia.getAlumnoId()+");";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    public void eliminarMateriaDB(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "delete from alumno_materia where id = "+alumno_materia.getId()+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    public List buscarRegistroDB(Alumno_materia alumno_materia) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno_materia where id = "+alumno_materia.getId()+" ;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                alumno_materia = new Alumno_materia();
                
                alumno_materia.setId(rs.getInt("id"));
                alumno_materia.setMateriaId(rs.getInt("materiaId"));
                alumno_materia.setAlumnoId(rs.getInt("alumnoId"));
                
                lista.add(alumno_materia);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }
    public void editarMateriaDB(Alumno_materia alumno_materia) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "update alumno_materia set materiaId = "+alumno_materia.getMateriaId()+" ,alumnoId = "+alumno_materia.getAlumnoId()+" where id = "+alumno_materia.getId()+";";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
}//fin   
