package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsignaturaProvider {
    Statement stmt;
    Modelo.Conexion a = new Modelo.Conexion();
    public ArrayList<Asignatura> ObtenerAsignatura() throws SQLException{
        ArrayList<Asignatura> arrayAsignatura = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();

        String sql="selec * from asignatura";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Asignatura asignatura = new Asignatura();
                asignatura.setIdAsignatura(rs.getInt(1));
                asignatura.setAsignatura(rs.getString(2));
                asignatura.setSemestre(rs.getInt(3));
                arrayAsignatura.add(asignatura);
                System.out.println("Materias disponibles: "+rs.getString(2));
            }
            System.out.println("-------------------------------------------");
            return arrayAsignatura;
        }catch(SQLException ex){
            System.out.println("No funciono");
            return null;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }
//-------------------------------------------------------------------------------
    public ArrayList<Asignatura> ObtenerAsignaturaSemestre(int semestre) throws SQLException{
        ArrayList<Asignatura> arrayAsignatura = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();

        String sql="SELECT * FROM `asignatura` WHERE `semestre`="+semestre+";";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Asignatura asignatura = new Asignatura();
                asignatura.setIdAsignatura(rs.getInt(1));
                asignatura.setAsignatura(rs.getString(2));
                asignatura.setSemestre(rs.getInt(3));
                arrayAsignatura.add(asignatura);
                System.out.println("Materias disponibles: "+rs.getString(2));
            }
            System.out.println("-------------------------------------------");
            return arrayAsignatura;
        }catch(SQLException ex){
            System.out.println("No funciono");
            return null;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    }  
//-------------------------------------------------------------------------------
    
//-------------------------------------------------------------------------------    
}
