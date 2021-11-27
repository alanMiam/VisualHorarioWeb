package Modelo;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prueba1 {
    public static void main (String[] args) throws SQLException{
        Scanner entrada = new Scanner(System.in);
        int ID;
        String nombre;
        
        Usuario us = new Usuario();
        //EJECUTAR PRUEBA
        UsuarioProvider up = new UsuarioProvider();
        up.ObtenerUsuario();
        
        System.out.println("Insertar: 1/ Modificar: 2/ Eliminar: 3");
        int sel = entrada.nextInt();
        
        switch(sel){
        case 1:
            entrada.reset();
            System.out.println("Introduzca nombre de usuario:");
                String in = entrada.nextLine();
                us.setNombreUsuario(entrada.nextLine());
            
            System.out.println("--------------------------------------");
            System.out.println("Introduzca un correo:");
                us.setCorreoUsuario(entrada.nextLine());
            System.out.println("--------------------------------------");
            System.out.println("Introduzca una contraseña:");
                us.setPassUsuario(entrada.nextLine());
            System.out.println("-----------------------------------------");
                us.setRolUsuario(0);
                up.Insertar(us);
        break;
        case 2:
            entrada.reset();
            entrada.nextLine();
            System.out.println("________________________________________");
            System.out.println("Introduzca un nuevo nombre de usuario:");
                
                us.setNombreUsuario(entrada.nextLine());
            System.out.println("nombre:"+us.getNombreUsuario());
            System.out.println("--------------------------------------");
            System.out.println("Introduzca un nuevo correo para el usuario:");
                us.setCorreoUsuario(entrada.nextLine());
            System.out.println("--------------------------------------");
            System.out.println("Introduzca una nueva contraseña para el usuario:");
                us.setPassUsuario(entrada.nextLine());
            System.out.println("-----------------------------------------");
            System.out.println("Seleccione el ID del usuario a modificar:");
                ID=entrada.nextInt();
                up.Modificar(ID, us);
        break;
        case 3:
            System.out.println("Introduzca el ID del usuario a eliminar");
             ID=entrada.nextInt();
             up.Eliminar(ID);
        break;
        default:
            System.out.println("UWU");
        break;    
        }
    }
}
