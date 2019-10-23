/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Maestro;
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
public class MaestroDAO {
    Connection conexion = null;
    Maestro maestro; //que te pasa java ¬¬
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }private void cerrarConexion() throws SQLException{conexion.close();}
    
    public boolean validarMaestroDB(Maestro maestro) throws ClassNotFoundException, SQLException{
        boolean condition = false;
        try{
            this.abrirConexion();
            String sql = "select usuario,contraseña from maestro where usuario ='" + maestro.getUsuario() + "' and contraseña ='"+maestro.getContraseña() +"' ";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            condition = rs.next();
            
        }catch(SQLException e){}
    this.cerrarConexion();
    return condition;
    } 
    
    public void insertarMaestroDB(Maestro maestro) throws ClassNotFoundException, SQLException{
        try{
            this.abrirConexion();
            String sql = "insert into maestro(nombre,usuario,contraseña,no_empleado,tipoEmpleadoId,estatus) VALUES ('"+maestro.getNombre()+"','"+maestro.getUsuario()+"','"+maestro.getContraseña()+"',"+maestro.getNo_empleado()+","+maestro.getTipoEmpleadoId()+","+maestro.getEstatus()+");";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//INSERT INTO maestro(nombre,usuario,contraseña,no_empleado,tipoEmpleadoId,estatus) VALUES ('?','?','?',?,?,?);
    
    public List obtenerMaestroDB() throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro;";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    }//SELECT * FROM maestro;
    
    
    public List buscarMaestroNombreDB(Maestro maestro) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro where nombre = '"+ maestro.getNombre() +"';";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    }//SELECT * FROM maestro where nombre = '"+  +"';

    public List buscarMaestroUsuarioDB(Maestro maestro) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro where usuario = '"+ maestro.getUsuario()+"';";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    }//SELECT * FROM maestro where usuario = '"+  +"';
    
    public List buscarMaestroNo_empleadoDB(Maestro maestro) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro where matricula = "+ maestro.getNo_empleado() +";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    }//SELECT * FROM maestro where matricula = "+  +";
    
    public List buscarMaestroTipoEmpleadoIdDB(Maestro maestro) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro where estatus = "+ maestro.getEstatus() +";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    
    public List buscarMaestroEstatusDB(Maestro maestro) throws ClassNotFoundException{
        List lista = new ArrayList();
        ResultSet rs;
        try{
            this.abrirConexion();
            String sql = "SELECT * FROM maestro where estatus = "+ maestro.getEstatus() +";";
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                maestro = new Maestro();
                
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
    
    public void editarMaestroDB(Maestro maestro) throws SQLException, ClassNotFoundException{
        try{
            this.abrirConexion();
            String sql = "update maestro set nombre = '"+maestro.getNombre()+"' ,usuario = '"+maestro.getUsuario()+"',contraseña='"+maestro.getContraseña()+"',no_empleado ="+maestro.getNo_empleado()+",tipoEmpleadoId="+maestro.getTipoEmpleadoId()+",estatus="+maestro.getEstatus()+" where id = "+maestro.getId()+";";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }//update maestro set nombre = '?',usuario= '?',contraseña = '?',no_empleado = ?,tipoEmpleadoId = ? ,estatus = ? where id = ?;
    
    public void eliminarMaestroDB(Maestro maestro) throws ClassNotFoundException, SQLException {
        try{
            this.abrirConexion();
            String sql = "delete from maestro where id = "+maestro.getId()+"";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
        }catch(SQLException e){}
    this.cerrarConexion();
    }
    
    
    
}//FIN
