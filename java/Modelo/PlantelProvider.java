package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlantelProvider {
    Statement stmt;
    public ArrayList<Plantel> ObtenerPlantel() throws SQLException{
    ArrayList<Plantel> arrayPlantel = new ArrayList();
    Modelo.Conexion a = new Modelo.Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = a.getConexion();
    
    String sql="SELECT * FROM `plantel`";
    try{
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        
        while(rs.next()){
            Plantel plantel = new Plantel();
            plantel.setIdPlantel(rs.getInt(1));
            plantel.setNombrePlantel(rs.getString(2));      
            arrayPlantel.add(plantel);
            System.out.println("Plantel: "+rs.getString(2)+", ID: "+rs.getInt(1));
        }
        return arrayPlantel;
    }catch(SQLException ex){
        System.out.println("No funcionó");
        return null;
    }finally{
        try{
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    }
}
