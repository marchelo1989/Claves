/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.DAO;

import Cl.Burgos.Claves.BD.BD;
import Cl.Burgos.Claves.ENT.ClLogin;
//import Cl.Burgos.Claves.Inter.LoginInter;
//import Cl.Burgos.Claves.Log4j.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;

/**
 *
 * @author Marchelo
 */
public class DAOLogin{
    //Variables del Log4j
//    static  Logger log =Logger.getLogger(DAOLogin.class);

        
    // Metodos de cambios de clave
    public List<ClLogin> leerClientes() {
        List<ClLogin> lista=new ArrayList<>();
        String strConsulta;
        
        strConsulta="SELECT rut, correo ,claveSecreta FROM `login` WHERE cambioPass='si';";
        
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
             ClLogin c = new ClLogin(rs.getString("rut"),rs.getString("correo"),rs.getString("claveSecreta"));
              lista.add(c);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
//            log.info(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//            Log.log(ex.getMessage());
//            log.info(ex.getMessage());
        }
        return lista;
    }
//    public static ClLogin sqlVerificarPass2() {
//        String stSql  = "SELECT `idLogin`, `rut`, `nombre`, `apellido`, `correo`, `password`, `preguntaSecreta`, `respuestaSecreta`, `claveSecreta` FROM `login` WHERE cambioPass='si'";
//        try {
//            ClLogin login = new ClLogin();
//            ResultSet rs = BD.getInstance().sqlSelect(stSql);
//            if(rs==null || !rs.next())return null;
//            login.setId(rs.getInt("idLogin")) ;
//            login.setRut(rs.getString("rut")) ;
//            login.setNombre(rs.getString("nombre")) ;
//            login.setApellido(rs.getString("apellido")) ;
//            login.setCorreo(rs.getString("correo")) ;
//            login.setPassword(rs.getString("password")) ;
//            login.setPreguntaSecreta(rs.getString("preguntaSecreta"));
//            login.setRespuestaSecreta(rs.getString("respuestaSecreta"));
//            return login;
//        } catch (SQLException ex) {
////            Log.log(ex.getMessage());
////            log.info(ex.getMessage());
////            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
////            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
////            Log.log(ex.getMessage());
////            log.info(ex.getMessage());
//        }
//        return null;
//    }
    
    
    public boolean sqlUpdateClaveSecreta(String key,String rut) {
        try {
            String stSql =  "UPDATE `login` SET `claveSecreta`='"+key+"' WHERE rut='"+rut+"' ;";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
//            log.info(ex.getMessage());
//            Log.log(ex.getMessage());
        }
        return false;
    }
}
