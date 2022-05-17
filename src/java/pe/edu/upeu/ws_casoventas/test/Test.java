package pe.edu.upeu.ws_casoventas.test;

import pe.edu.upeu.ws_casoventas.config.Conexion;

/**
 *
 * @author CAMPOS
 */
public class Test {
    
    public static void main(String[] args){
        if(Conexion.getConex()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("No conectado");}
    }
}
