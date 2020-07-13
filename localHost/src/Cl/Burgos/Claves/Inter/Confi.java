/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.Inter;

/**
 *
 * @author march
 */
public interface Confi {
    //Configuracion de BD localhot
    //Para mySQL
    String DriverBD="com.mysql.jdbc.Driver";
    //Para Oracle
//    String DriverBD="oracle.jdbc.OracleDriver";
    // BD Local
    String ip="localhost";
    String puerto="3306";
    String BaseDatos="claves";
    String userBD="root";
    String passBD="";
    // BD Windows 7
//    String ip="192.168.101.9";
//    String puerto="3306";
//    String BaseDatos="claves";
//    String userBD="marchelo";
//    String passBD="HP2117la";
    // BD Servidor
//    String ip="10.20.30.1";
//    String puerto="3306";
//    String BaseDatos="RepararPC";
//    String userBD="marchelo";
//    String passBD="HP2117la";
//    
    //Configuracion de Log
    String nameLog="LogGeneral.log";
    //Configuracion del Log4j
    // Nombre de Referencia del Archivo Log4j.properties
    String nameLog4jLib="Log4jLib.log";
    String nameLog4jApli="Log4jApli.log";
    String nameLog4jWeb="Log4jWeb.log";
    
    // Ubicacion del los Archivos
    static String urlDirec="C:\\Aplicaciones\\Claves\\";
    
    //Configuracion de Directorio
    static String Url = "C:\\";
    static String carpeta1 = "Aplicaciones";
    static String carpeta2 = "Claves";
    static String SO = System.getProperty("os.name");
    static String userDir = System.getProperty("user.home");
    
    //Prueba Login
    String loginUsep="170088646";
    String loginPasp="HP2117la";
//    String loginUsep="111111111";
//    String loginPasp="admin";
}
