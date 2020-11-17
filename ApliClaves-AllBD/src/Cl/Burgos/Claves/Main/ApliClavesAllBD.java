/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.Main;

import Cl.Burgos.Claves.Conf.Confi;
import Cl.Burgos.Claves.FUN.Directorio;
import Cl.Burgos.Claves.GUI.FrLogin;
import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author march
 */
public class ApliClavesAllBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File log4jfile = new File(Confi.userProgra+"/Log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
    
        Directorio.crearDirecPre();
        Directorio.crearDirecSec();
        new FrLogin().setVisible(true);
    } 
}
