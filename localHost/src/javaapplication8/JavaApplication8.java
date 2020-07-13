/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import Cl.Burgos.Claves.BD.Log;
import Cl.Burgos.Claves.DAO.DAOLogin;
import Cl.Burgos.Claves.ENT.ClLogin;
import Cl.Burgos.Claves.FUN.MetodoBase64E;
import Cl.Burgos.Claves.FUN.PasswordGenerator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author march
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        EnviarCorreo correo = new EnviarCorreo();
        DAOLogin dAOLogin = new DAOLogin();
        List<ClLogin> lista = dAOLogin.leerClientes();
        for(ClLogin str : lista)
        {
            String key = generarPASS();
            if(str.getClaveSecreta().length()==20){
                Log.log("Clave Lista:"+str.getRut());
            }else{
                dAOLogin.sqlUpdateClaveSecreta(key,str.getRut());
                Log.log("Clave Generada:"+str.getRut()+" Para Mail: "+str.getCorreo()+" Clave: "+key+" Fecha: "+new Date());
                correo.enviarMail(key,str.getCorreo(),"Clave Secreta Para Cambio de Clave");
            }
        }
        
        
//            correo.enviarMail(key,"marchelo.1989@live.cl","Clave Secreta");
        
    }
    public static String generarPASS(){
        String Pass =PasswordGenerator.getPassword(
                PasswordGenerator.NUMEROS+
		PasswordGenerator.MINUSCULAS+
		PasswordGenerator.MAYUSCULAS+
		PasswordGenerator.ESPECIALES,20);
        return Pass;
    }
}
