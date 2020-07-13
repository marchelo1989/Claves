/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.ENT;

//import Cl.Burgos.Claves.EXP.ExpLogin;
import Cl.Burgos.Claves.FUN.Metodos;

/**
 *
 * @author Marchelo
 */
public class ClLogin {
    private int id;
    private String rut; // not null
    private String nombre; //not Null
    private String apellido;
    private String correo; //not null
//    private String celular;
    private String password; //not Null
    private String preguntaSecreta; //not null
    private String respuestaSecreta; //not null
    private String claveSecreta;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreguntaSecreta() {
        return preguntaSecreta;
    }

    public void setPreguntaSecreta(String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }

    public String getRespuestaSecreta() {
        return respuestaSecreta;
    }

    public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

    public String getClaveSecreta() {
        return claveSecreta;
    }

    public void setClaveSecreta(String claveSecreta) {
        this.claveSecreta = claveSecreta;
    }   

    public ClLogin(int id, String rut, String nombre, String apellido, String correo, String password, String preguntaSecreta, String respuestaSecreta, String claveSecreta) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.preguntaSecreta = preguntaSecreta;
        this.respuestaSecreta = respuestaSecreta;
        this.claveSecreta = claveSecreta;
    }

    public ClLogin(String rut, String correo,String claveSecreta) {
        this.rut = rut;
        this.correo = correo;
        this.claveSecreta = claveSecreta;
    }

    public ClLogin() {
    }
    
    
    
}
