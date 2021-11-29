package Seguridad;

import java.util.Base64;


public class Encriptacion {
    
    public String code(String entradaOriginal){
        String cadenaCodificada="";
        cadenaCodificada = Base64.getEncoder().encodeToString(entradaOriginal.getBytes());
        
        System.out.println("codificado: " + cadenaCodificada);
        return cadenaCodificada;
    }
        
    public String decode(String cadenaCodificada){
        String decode="";
        
        byte[] bytesDecodificados = Base64.getDecoder().decode(cadenaCodificada);
        String cadenaDecodificada = new String(bytesDecodificados);
        
        System.out.println("decodificado: " + cadenaDecodificada);
        decode = cadenaDecodificada;
        return decode;
    }
}
