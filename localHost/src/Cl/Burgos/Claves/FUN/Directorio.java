/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.FUN;

import static Cl.Burgos.Claves.Inter.Confi.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Marchelo
 */
public class Directorio {
//    static String carpeta = "RepararPC";
//    static String SO = System.getProperty("os.name");
//    static String userDir = System.getProperty("user.home");
    
    public static File selectDirecPre(){
        File f = null;
        if(SO.startsWith("Windows")){
            String url = Url +"/"+ carpeta1 +"/"+ carpeta2 ;
            f = new File(url);
        }else{
            String url = userDir +"/"+carpeta1;
            f = new File(url);
        }
        return f;
    }
    public static void crearDirecPre(){
        if(SO.startsWith("Windows")){
            File directorio = new File(Url +"/"+ carpeta1 ); 
            directorio.mkdir(); 
        }else{
            File directorio = new File(Url +"/"+ carpeta1); 
            directorio.mkdir();
        } 
    }
    public static void crearDirecSec(){
        if(SO.startsWith("Windows")){
            File directorio = new File(Url +"/"+ carpeta1 +"/"+ carpeta2 ); 
            directorio.mkdir(); 
        }else{
            File directorio = new File(Url +"/"+ carpeta1 +"/"+ carpeta2 ); 
            directorio.mkdir();
        } 
    }
    
    public static void abrirArchivo(String url) throws IOException{
        File objetofile = new File (url);
        Desktop.getDesktop().open(objetofile);
    }
    public static void abrirDirecPre() throws IOException{
        if(SO.startsWith("Windows")){
            File directorio = new File(Url +"/"+ carpeta1 +"/"+ carpeta2 );
            Desktop.getDesktop().open(directorio);
        }else{
            File directorio = new File(userDir +"/"+ carpeta2 );
            Desktop.getDesktop().open(directorio);
        }
    }
}
