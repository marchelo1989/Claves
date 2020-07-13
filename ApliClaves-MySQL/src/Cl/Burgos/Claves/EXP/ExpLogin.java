/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.EXP;

/**
 *
 * @author Marchelo
 */
public class ExpLogin extends Exception{
    public static final int ERR_Id=1;
    public static final int ERR_RutNull=2;
    public static final int ERR_Rut=3;
    public static final int ERR_Nombre=4;
    public static final int ERR_NombreNull=5;
    public static final int ERR_Apellido=6;
    public static final int ERR_CorreoNull=7;
    public static final int ERR_Correo=8;
    public static final int ERR_Password=9;
    public static final int ERR_PreguntaSecretaNull=10;
    public static final int ERR_PreguntaSecreta=11;
    public static final int ERR_RespuestaSecretaNull=12;
    public static final int ERR_RespuestaSecreta=13;
    
    public ExpLogin (int error) throws Exception{
        switch(error){
            case ERR_Id:
                throw new Exception("El Id debe ser Mayor que 0");
            case ERR_RutNull:
                throw new Exception("El Rut no puede estar vacio");
            case ERR_Rut:
                throw new Exception("El Rut es Incorrecto");
            case ERR_NombreNull:
                throw new Exception("El Nombre no puede estar vacio");
            case ERR_Nombre:
                throw new Exception("El Nombre debe estar entre 4...25 caracteres");
            case ERR_Apellido:
                throw new Exception("El Apellido debe estar entre 4...25 caracteres");
            case ERR_CorreoNull:
                throw new Exception("El Correo no puede estar vacio");
            case ERR_Correo:
                throw new Exception("El Correo es incorrecto");
            case ERR_Password:
                throw new Exception("El Password debe estar entre 4...25 caracteres");
            case ERR_PreguntaSecretaNull:
                throw new Exception("La Pregunta Secreta no puede estar vacio");
            case ERR_PreguntaSecreta:
                throw new Exception("La Pregunta Secreta debe estar entre 4...45 caracteres");
            case ERR_RespuestaSecretaNull:
                throw new Exception("La Respuata Secreta no puede estar vacio");
            case ERR_RespuestaSecreta:
                throw new Exception("La Respuata Secreta debe estar entre 4...45 caracteres");
            
                default:
                    throw new Exception("Error desconocido "+ error);
        }
    }
}
