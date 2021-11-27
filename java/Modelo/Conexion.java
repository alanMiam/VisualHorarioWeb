package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public String db = "visualhorario";
    public String user = "root";
    public String pass = "";
    public String url = "jdbc:mysql://localhost:3306/"+db;
    Connection con;
    Statement stmt;
    ResultSet rs;

    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }try{
            con = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion establecida");
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Conexion fallida");
        }
        return con;
    }
}