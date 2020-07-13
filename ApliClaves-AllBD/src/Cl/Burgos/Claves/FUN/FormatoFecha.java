/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.FUN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author march
 */
public class FormatoFecha {
    public static String mostrarFecha(Date date){
        //Muestra la dia mes año
        DateFormat dateFormatFecha = new SimpleDateFormat("dd/MM/yyyy");
        String d=dateFormatFecha.format(date);
//        System.out.println("Muestra El dia-mes-año: "+d);
        return d;
    }
}
