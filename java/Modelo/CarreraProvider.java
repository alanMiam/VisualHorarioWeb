package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarreraProvider {
    Statement stmt;
    public ArrayList<Carrera> ObtenerCarrera() throws SQLException{
        ArrayList<Carrera> arrayCarrera = new ArrayList();
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();

        String sql="SELECT * FROM `carrera`";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Carrera carrera = new Carrera();
                carrera.setIdCarrera(rs.getInt(1));
                carrera.setNombreCarrera(rs.getString(2));
                carrera.setIdPlantel(rs.getInt(3));
                arrayCarrera.add(carrera);
                System.out.println("Carrera: "+rs.getString(2)+", id: "+rs.getInt(1));
            }
            return arrayCarrera;
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
