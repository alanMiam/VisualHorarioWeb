package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Seguridad.Encriptacion;
public class UsuarioProvider {    
    Statement stmt;
    Encriptacion enc = new Encriptacion();
    
    public ArrayList<Usuario> ObtenerUsuario(){
        ArrayList<Usuario> arrayUsuario = new ArrayList();
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();
        String sql="SELECT * FROM `usuario`";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            System.out.println("ObtenerUsuario ejecutado correctamente");
            System.out.println("-----------------------------");
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombreUsuario(rs.getString(2));
                
                //Obtiene la contraseña y la decodifica
                //usuario.setPassUsuario(enc.decode(rs.getString(3)));
                usuario.setPassUsuario(rs.getString(3));
                usuario.setCorreoUsuario(rs.getString(4));
                usuario.setRolUsuario(rs.getInt(5));          
                arrayUsuario.add(usuario);
                System.out.println("ID disponibles: "+rs.getInt(1));
            }
            System.out.println("-----------------------------");
            return arrayUsuario;
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
//*************************************************************************************************    
    public String ObtenerUsuario234(String correo, int elemento){
        Usuario us = new Usuario();
        String info="";
        
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();
        String sql="SELECT * FROM `usuario` WHERE `correoUsuario`='"+correo+"'";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            System.out.println("ObtenerUsuario ejecutado correctamente");
            System.out.println("-----------------------------");
            while(rs.next()){
                
                us.setIdUsuario(rs.getInt(1));//no
                us.setNombreUsuario(rs.getString(2));
                
                //DECODIFICA LA CONTRASEÑA
                //us.setPassUsuario(enc.decode(rs.getString(3)));
                us.setPassUsuario(rs.getString(3));
                us.setCorreoUsuario(rs.getString(4));
                us.setRolUsuario(rs.getInt(5));//no          
                System.out.println("ID disponibles: "+rs.getString(2));
                info=rs.getString(elemento);
            }
            System.out.println("-----------------------------");
        }catch(SQLException ex){
            System.out.println("No funcionó");
            return info;}
        return info;
    }
    //---------------------------------------------------------------------------
    public int ObtenerUsuario15(String correo, int elemento){
        Usuario us = new Usuario();
        int info=0;
        
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = a.getConexion();
        String sql="SELECT * FROM `usuario` WHERE `correoUsuario`='"+correo+"'";
        try{
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            System.out.println("ObtenerUsuario ejecutado correctamente");
            System.out.println("-----------------------------");
            while(rs.next()){
                
                us.setIdUsuario(rs.getInt(1));//no
                us.setNombreUsuario(rs.getString(2));
                
                //DECODIFICA LA CONTRASEÑA
                //us.setPassUsuario(enc.decode(rs.getString(3)));
                us.setPassUsuario(rs.getString(3));
                us.setCorreoUsuario(rs.getString(4));
                us.setRolUsuario(rs.getInt(5));//no          
                System.out.println("ID disponibles: "+rs.getString(2));
                info=rs.getInt(elemento);
            }
            System.out.println("-----------------------------");
        }catch(SQLException ex){
            System.out.println("No funcionó");
            return info;}
        return info;
    }
//*************************************************************************************************************
    public boolean Insertar(Usuario usuario) throws SQLException{
        String nom;String cont;String corr;int rol;
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
        
        try{
            nom = usuario.getNombreUsuario();
            
            //codifica la contraseña
            //cont=enc.code(usuario.getPassUsuario());
            cont=usuario.getPassUsuario();
            corr=usuario.getCorreoUsuario();
            rol=usuario.getRolUsuario();
            sql="INSERT INTO usuario (nombreUsuario, passUsuario, correoUsuario, rolUsuario) VALUES('"+nom+"','"+cont+"','"+corr+"',"+rol+")";

            stmt.executeUpdate(sql);

            System.out.println("Insertado correctamente UWU");
            return true;

        }catch(SQLException ex){
            System.out.println("No se insertaron los datos UnU");
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
    public boolean Modificar(int ID, Usuario usuario) throws SQLException{
        String nom;String cont;int rol;
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        nom = usuario.getNombreUsuario();
        
        //CODIFICA LA CONTRASEÑA PARA SER ENVIADA A LA BASE DE DATOS 
        cont=enc.code(usuario.getPassUsuario());
        
        cont=usuario.getPassUsuario();
        rol=usuario.getRolUsuario();
        sql="UPDATE `usuario` SET nombreUsuario='"+nom+"', passUsuario='"+cont+"', rolUsuario='"+rol+"' where idUsuario="+ID;    
        stmt.executeUpdate(sql);
        System.out.println("Actualizado correctamente UWU");    
        return true;
    }catch(SQLException ex){
        System.out.println("No se actualizó UnU");
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
    
    public boolean Eliminar(int ID) throws SQLException{
        Modelo.Conexion a = new Modelo.Conexion();
        PreparedStatement ps = null;
        Connection con = a.getConexion();
        String sql;
        stmt=con.createStatement();
    try{
        sql="DELETE FROM `usuario` WHERE idUsuario="+ID;
        stmt.executeUpdate(sql);
        System.out.println("Eliminado correctamente UWU");  
        return true;
    }catch(SQLException ex){
        System.out.println("No se eliminó UnU");
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
