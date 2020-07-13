/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.ENT;

import Cl.Burgos.Claves.EXP.ExpLogin;
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
    private String activo;

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id==0){
            throw new ExpLogin(ExpLogin.ERR_Id);
        }else{
            this.id = id;
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        if(rut.length()==0){
            throw new ExpLogin(ExpLogin.ERR_RutNull);
        }else{
            if(!Metodos.validarRut(Metodos.formatear(rut))){
                throw new ExpLogin(ExpLogin.ERR_Rut);
            }else{
                this.rut = Metodos.formatear(rut);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length()==0){
            throw new ExpLogin(ExpLogin.ERR_NombreNull);
        }else{
            if(nombre.length()<=3 || nombre.length()>=26){
                throw new ExpLogin(ExpLogin.ERR_Nombre);
            }else{
                this.nombre = nombre;
            }
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception {
        if(apellido.length()==0){
            this.apellido = apellido;
        }else{
            if(apellido.length()<=3 || apellido.length()>=26){
                throw new ExpLogin(ExpLogin.ERR_Apellido);
            }else{
                this.apellido = apellido;
            }
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        if(correo.length()==0){
            throw new ExpLogin(ExpLogin.ERR_CorreoNull);
        }else{
            if(!Metodos.validateEmail(correo)){
                throw new ExpLogin(ExpLogin.ERR_Correo);
            }else{
                this.correo = correo;
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(password.length()==0){
            throw new ExpLogin(ExpLogin.ERR_Password);
        }else{
            this.password = Metodos.encriptaEnMD5(password);
        }
    }

    public String getPreguntaSecreta() {
        return preguntaSecreta;
    }

    public void setPreguntaSecreta(String preguntaSecreta) throws Exception {
        if(preguntaSecreta.length()==0){
            throw new ExpLogin(ExpLogin.ERR_PreguntaSecretaNull);
        }else{
            if(preguntaSecreta.length()<=3 || preguntaSecreta.length()>=45){
                throw new ExpLogin(ExpLogin.ERR_PreguntaSecreta);
            }else{
                this.preguntaSecreta = preguntaSecreta;
            }
        }
    }

    public String getRespuestaSecreta() {
        return respuestaSecreta;
    }

    public void setRespuestaSecreta(String respuestaSecreta) throws Exception {
        if(respuestaSecreta.length()==0){
            throw new ExpLogin(ExpLogin.ERR_RespuestaSecretaNull);
        }else{
            if(respuestaSecreta.length()<=3 || respuestaSecreta.length()>=45){
                throw new ExpLogin(ExpLogin.ERR_RespuestaSecreta);
            }else{
                this.respuestaSecreta = respuestaSecreta.toLowerCase();
            }
        }
    }

    public String getClaveSecreta() {
        return claveSecreta;
    }

    public void setClaveSecreta(String claveSecreta) {
        this.claveSecreta = claveSecreta;
    }

    
    //Validar Login para inciar session
    public ClLogin(String rut, String password) throws Exception {
        setRut(rut);
        setPassword(password);
    }   
    
    public ClLogin(String rut, String nombre, String apellido, String correo, String preguntaSecreta, String respuestaSecreta) throws Exception {
        setRut(rut);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setPreguntaSecreta(preguntaSecreta);
        setRespuestaSecreta(respuestaSecreta);
    }
    
    public ClLogin(String rut, String nombre, String apellido, String correo, String password, String preguntaSecreta, String respuestaSecreta) throws Exception {
        setRut(rut);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setPassword(password);
        setPreguntaSecreta(preguntaSecreta);
        setRespuestaSecreta(respuestaSecreta);
    }

    public ClLogin(String rut, String correo, String respuestaSecreta) throws Exception {
        setRut(rut);
        setCorreo(correo);
        setRespuestaSecreta(respuestaSecreta);
    }

    public ClLogin(String claveSecreta) {
        setClaveSecreta(claveSecreta);
    }

    
    
    @Override
    public String toString() {
        return "ClLogin{" + "id=" + id + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", passworld=" + password + ", preguntaSecreta=" + preguntaSecreta + ", respuestaSecreta=" + respuestaSecreta + ", claveSecreta=" + claveSecreta + '}';
    }
    
}
