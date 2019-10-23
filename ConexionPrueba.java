
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DURAN
 */
public class ConexionPrueba {
    //private static final String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    //private static final String dbName = "cursocsi"; //Nombre de tu base de datos
    private static final String user = "root";//Nombre del usuario que utilizas en SQL SERVER
    private static final String password = "";//Contraseña con el que ingresar al SQL Server
    //private static final String service = "3306";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //
        String url = "jdbc:mysql://127.0.0.1:3306/cursocsi";
        return DriverManager.getConnection(url, user, password);
        //----------------------------------------------------------------//

    }

    public static void main(String[] args) throws SQLException{
        Connection con = ConexionPrueba.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
