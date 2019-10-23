/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Alumno;
import Modelo.Maestro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo16
 */
public class AlumnoDAO {
    Connection conexion = null;
    Alumno alumno;
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }private void cerrarConexion() throws SQLException{conexion.close();}
    
    public boolean validarAlumnoDB(Alumno alumno) throws ClassNotFoundException, SQLException{
        boolean condition = false;
        try{
            this.abrirConexion();
            String sql = "select usuario,contraseña from alumno where usuario ='" + alumno.getUsuario() + "' and contraseña ='"+alumno.getContraseña() +"' ";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            condition = rs.next();
            
        }catch(SQLException e){}
    this.cerrarConexion();
    return condition;
    } 
    
    public void insertarAlumnoDB(Alumno alumno) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "insert into alumno(nombre,usuario,contraseña,matricula,estatus) VALUES ('"+alumno.getNombre()+"','"+alumno.getUsuario()+"','"+alumno.getContraseña()+"',"+alumno.getMatricula()+","+alumno.getEstatus()+");";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//insert into alumno(nombre,usuario,contraseña,matricula,estatus) VALUES ('?','?','?',?,?);
    
    public List obtenerAlumnoDB() throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Alumno alumno = new Alumno();
                
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setUsuario(rs.getString("usuario"));
                alumno.setContraseña(rs.getString("contraseña"));
                alumno.setMatricula(rs.getInt("matricula"));
                alumno.setEstatus(rs.getInt("estatus"));
                lista.add(alumno);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM alumno;
    
    public List obtenerMaestroDB() throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Maestro maestro = new Maestro();
                
                maestro.setId(rs.getInt("id"));
                maestro.setNombre(rs.getString("nombre"));
                maestro.setUsuario(rs.getString("usuario"));
                maestro.setContraseña(rs.getString("contraseña"));
                maestro.setNo_empleado(rs.getInt("no_empleado"));
                maestro.setTipoEmpleadoId(rs.getInt("tipoEmpleadoId"));
                maestro.setEstatus(rs.getInt("estatus"));
                lista.add(maestro);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }
    
    public List buscarAlumnoNombreDB(Alumno alumno) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno where nombre = '"+ alumno.getNombre() +"';";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setUsuario(rs.getString("usuario"));
                alumno.setContraseña(rs.getString("contraseña"));
                alumno.setMatricula(rs.getInt("matricula"));
                alumno.setEstatus(rs.getInt("estatus"));
                lista.add(alumno);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM alumno where nombre = '"+  +"';

    public List buscarAlumnoUsuarioDB(Alumno alumno) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno where usuario = '"+ alumno.getUsuario()+"';";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setUsuario(rs.getString("usuario"));
                alumno.setContraseña(rs.getString("contraseña"));
                alumno.setMatricula(rs.getInt("matricula"));
                alumno.setEstatus(rs.getInt("estatus"));
                lista.add(alumno);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM alumno where usuario = '"+  +"';
    
    public List buscarAlumnoMatriculaDB(Alumno alumno) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno where matricula = "+ alumno.getMatricula() +";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setUsuario(rs.getString("usuario"));
                alumno.setContraseña(rs.getString("contraseña"));
                alumno.setMatricula(rs.getInt("matricula"));
                alumno.setEstatus(rs.getInt("estatus"));
                lista.add(alumno);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM alumno where matricula = "+  +";
    
    public List buscarAlumnoEstatusDB(Alumno alumno) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM alumno where estatus = "+ alumno.getEstatus() +";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setId(rs.getInt("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setUsuario(rs.getString("usuario"));
                alumno.setContraseña(rs.getString("contraseña"));
                alumno.setMatricula(rs.getInt("matricula"));
                alumno.setEstatus(rs.getInt("estatus"));
                lista.add(alumno);
            }
            this.cerrarConexion();
        }catch(SQLException e){
        }
        return lista;
    }//SELECT * FROM alumno where estatus = "+  +";
    
    public void editarAlumnoDB(Alumno alumno) throws SQLException, ClassNotFoundException{
        try{
            this.abrirConexion();
            String sql = "update alumno set nombre = '"+alumno.getNombre()+"' ,usuario = '"+alumno.getUsuario()+"',contraseña='"+alumno.getContraseña()+"',matricula="+alumno.getMatricula()+",estatus="+alumno.getEstatus()+" where id = "+alumno.getId()+";";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//update alumno set nombre = '?',usuario= '?',contraseña = '?',matricula = ? ,estatus = ? where id = ?;
    
    public void eliminarAlumnoDB(Alumno alumno) throws ClassNotFoundException, SQLException {
        try{
            this.abrirConexion();
            String sql = "delete from alumno where id = "+alumno.getId()+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
    
    
}//FIN
