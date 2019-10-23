/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Administrador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Equipo16
 */
public class AdministradorDAO {
    Connection conexion = null;
    private void abrirConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        String user = "root", pass = "";
        conexion = DriverManager.getConnection(url,user,pass);
    }
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
        
    public boolean validarBasededatos(Administrador admin) throws SQLException, ClassNotFoundException{
        boolean condition = false;
        try{
            this.abrirConexion();
            String sql = "select usuario,contraseña from administrador where usuario ='" + admin.getUsuario() + "' and contraseña ='"+admin.getContraseña() +"' ";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            condition = rs.next();
            
        }catch(SQLException e){}
    this.cerrarConexion();
    return condition;
    }
    
    public void altas(){}
}
