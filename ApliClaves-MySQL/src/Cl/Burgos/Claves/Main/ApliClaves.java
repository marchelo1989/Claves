/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.Main;

import Cl.Burgos.Claves.FUN.Directorio;
import Cl.Burgos.Claves.GUI.FrLogin;
import java.io.File;

/**
 *
 * @author march
 */
public class ApliClaves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Directorio.crearDirecPre();
        Directorio.crearDirecSec();
        FrLogin frLogin = new FrLogin();
        frLogin.setVisible(true);
    }
    
}
