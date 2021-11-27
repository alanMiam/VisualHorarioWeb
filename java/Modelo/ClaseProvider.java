package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClaseProvider {
    Statement stmt;
    public ArrayList<Clase> ObtenerClase() throws SQLException{
    ArrayList<Clase> arrayClase = new ArrayList();
    Modelo.Conexion a = new Modelo.Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = a.getConexion();
    
    String sql="SELECT * FROM `clase`";
    try{
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        
        while(rs.next()){
            Clase clase = new Clase();
            clase.setID(rs.getInt(1));
            clase.setIdAsignatura(rs.getInt(2));
            clase.setGrupo(rs.getString(3));
            clase.setSemestre(rs.getInt(4));
            clase.setIdCarrera(rs.getInt(5));
            arrayClase.add(clase);
            System.out.println("Id: "+rs.getInt(1)+", asignatura: "+rs.getInt(2)+", grupo: "+rs.getString(3)+", semestre: "+rs.getInt(4));
        }
        return arrayClase;
    }catch(SQLException ex){
        return null;
    }finally{
        try{
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    }
    
    public boolean insertar(Clase clase) throws SQLException{
        int idAsignatura; String grupo; int semestre; int idCarrera;
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
        
        try{
            idAsignatura=clase.getIdAsignatura();
            grupo=clase.getGrupo();
            semestre=clase.getSemestre();
            idCarrera=1;
            sql="INSERT INTO `clase`(`idAsignatura`, `grupo`, `semestre`, `idEspecialidad`) VALUES ()('"+idAsignatura+"','"+grupo+"','"+semestre+"','"+idCarrera+"')";

            stmt.executeUpdate(sql);
            System.out.println("Se insertó la clase correctamente");
            return true;
        }catch(SQLException ex){
            System.out.println("No se insertó");
            return false;
        }    
        finally{
            try{
                con.close();
            }catch(SQLException ex){
                Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
            }
        }
    } 
    
    public boolean Modificar(int idClase, Clase clase) throws SQLException{
        int idAsignatura; String grupo; int semestre; int idCarrera;
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        idAsignatura= clase.getIdAsignatura();
        grupo= clase.getGrupo();
        semestre=clase.getSemestre();
        idCarrera=clase.getIdCarrera();
        sql="UPDATE `clase` SET idAsignatura='"+idAsignatura+"', grupo='"+grupo+"', semestre='"+idCarrera+"', idCarrera='"+idCarrera+"' where ID="+idClase;
        stmt.executeUpdate(sql);
        System.out.println("Se modificó la clase: "+idClase);
        return true;
    }catch(SQLException ex){
        System.out.println("No se modificó");
        return false;
    }    
    finally{
        try{
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    }
    
    public boolean Eliminar(int idClase) throws SQLException{
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        sql="DELETE FROM `clase` where ID="+idClase;
        stmt.executeQuery(sql);
        System.out.println("Se eliminó la clase: "+idClase);
        return true;
    }catch(SQLException ex){
        System.out.println("No se eliminó");
        return false;
    }    
    finally{
        try{
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(ClaseProvider.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    }
}
