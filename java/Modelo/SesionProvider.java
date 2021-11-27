package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SesionProvider {    
    Statement stmt;
    public ArrayList<Sesion> ObtenerSesion() throws SQLException{
        ArrayList<Sesion> arraySesion = new ArrayList();
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();

        String sql="SELECT * FROM `sesion`";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                Sesion sesion = new Sesion();
                sesion.setIdSesion(rs.getInt(1));
                sesion.setHoraInicio(rs.getTime(2));
                sesion.setHoraFin(rs.getTime(3));
                sesion.setDia(rs.getInt(4));
                sesion.setID(rs.getInt(5));          
                arraySesion.add(sesion);
            }
            return arraySesion;
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

    public boolean Insertar(Sesion sesion) throws SQLException{
        Time inicio; Time fin; int dia; int id;
//INSERT into sesion (horaInicio, horaFin, dia, ID) values(?,?,?,?)
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        inicio=sesion.getHoraInicio();
        fin=sesion.getHoraFin();
        dia=sesion.getDia();
        id=sesion.getID();
        sql="INSERT INTO sesion (horaInicio, horaFin, dia) VALUES('"+inicio+"','"+fin+"','"+dia+"')";
        
        stmt.executeUpdate(sql);
        
        System.out.println("Sesion insertada correctamente");
        return true;
    }catch(SQLException ex){
        System.out.println("No se insertó sesion");
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
    
    public boolean Modificar(int idSesion, Sesion sesion) throws SQLException{
        Time inicio; Time fin; int dia;
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();//"UPDATE sesion SET horaInicio=?, horaFin=?, dia=?, ID=? where idSesion=?"  
    try{
        inicio=sesion.getHoraInicio();
        fin=sesion.getHoraFin();
        dia=sesion.getDia();
        sql="UPDATE `sesion` SET horaInicio='"+inicio+"', horaFin='"+fin+"', dia='"+dia+"' WHERE idSesion="+idSesion;
        stmt.executeUpdate(sql);
        System.out.println("Se actualizó la sesión con el id: "+idSesion);
        return true;
    }catch(SQLException ex){
        System.out.println("No se actualizó");
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
    
    public boolean Eliminar(int idSesion) throws SQLException{
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        sql="DELETE FROM `sesion` WHERE idSesion="+idSesion;
        stmt.executeUpdate(sql);
        System.out.println("Se eliminó la sesión con id: "+idSesion);
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
