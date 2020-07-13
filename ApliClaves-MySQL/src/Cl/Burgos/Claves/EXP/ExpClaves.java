/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.EXP;

/**
 *
 * @author march
 */
public class ExpClaves extends Exception{
    public static final int ERR_Id=1;
    public static final int ERR_Nombre=2;
    public static final int ERR_NombreNull=3;
    public static final int ERR_Pagina=4;
    public static final int ERR_PaginaNull=5;
    public static final int ERR_User=6;
    public static final int ERR_UserNull=7;
    public static final int ERR_Pass=8;
    public static final int ERR_PassNull=9;
    public static final int ERR_Fecha=10;
    
    public ExpClaves (int error) throws Exception{
        switch(error){
            case ERR_Id:
                throw new Exception("El Id debe ser Mayor que 0");
            case ERR_NombreNull:
                throw new Exception("El Nombre no puede estar vacio");
            case ERR_Nombre:
                throw new Exception("El Nombre debe estar entre 4...25 caracteres");
            case ERR_Pagina:
                throw new Exception("La Pagina no puede estar vacio");
            case ERR_PaginaNull:
                throw new Exception("La Pagina debe estar entre 4...45 caracteres");
            case ERR_User:
                throw new Exception("El Usuario no puede estar vacio");
            case ERR_UserNull:
                throw new Exception("El Usuario debe estar entre 4...45 caracteres");
            case ERR_Pass:
                throw new Exception("La Passworld no puede estar vacio");
            case ERR_PassNull:
                throw new Exception("La Passworld debe estar entre 4...45 caracteres");
            case ERR_Fecha:
                throw new Exception("La Fecha debe ser Anterior a la Actual");
                default:
                    throw new Exception("Error desconocido "+ error);
        }
    }
}
