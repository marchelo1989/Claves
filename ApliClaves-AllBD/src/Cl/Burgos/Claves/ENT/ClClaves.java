/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.ENT;

import Cl.Burgos.Claves.EXP.ExpClaves;
import Cl.Burgos.Claves.FUN.Metodos;
import java.util.Date;

/**
 *
 * @author Marchelo
 */
public class ClClaves {
    private int id;
    private String nombre; // not null
    private String pagina; // not null
    private String user; // not null
    private String pass; // not null
    private Date fechaInsert; // not null
    private Date fechaUpdate;
    private int idLogin; // not null

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id<0){
            throw new ExpClaves(ExpClaves.ERR_Id);
        }else{
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if(nombre.length()==0){
            throw new ExpClaves(ExpClaves.ERR_NombreNull);
        }else{
            if(nombre.length()<=3 || nombre.length()>=26){
                throw new ExpClaves(ExpClaves.ERR_Nombre);
            }else{
                this.nombre = nombre;
            }
        }
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) throws Exception {
        if(pagina.length()==0){
            throw new ExpClaves(ExpClaves.ERR_PaginaNull);
        }else{
            if(pagina.length()<=3 || pagina.length()>=45){
                throw new ExpClaves(ExpClaves.ERR_Pagina);
            }else{
                this.pagina = pagina;
            }
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) throws Exception {
        if(user.length()==0){
            throw new ExpClaves(ExpClaves.ERR_UserNull);
        }else{
            if(user.length()<=3 || user.length()>=45){
                throw new ExpClaves(ExpClaves.ERR_User);
            }else{
                this.user = user;
            }
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) throws Exception {
        if(pass.length()==0){
            throw new ExpClaves(ExpClaves.ERR_PassNull);
        }else{
            if(pass.length()<=3 || pass.length()>=45){
                throw new ExpClaves(ExpClaves.ERR_Pass);
            }else{
                this.pass = pass;
            }
        }
    }

    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) throws Exception {
        if(Metodos.validaFecha(fechaInsert)){
            throw new ExpClaves(ExpClaves.ERR_Fecha);
        }else{
            this.fechaInsert = fechaInsert;
        }
    }

    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    //Listar
    public ClClaves(int id, String nombre, String pagina, String user, String pass, Date fechaInsert, Date fechaUpdate, int idLogin) throws Exception {
        setId(id);
        setNombre(nombre);
        setPagina(pagina);
        setUser(user);
        setPass(pass);
        setFechaInsert(fechaInsert);
        setFechaUpdate(fechaUpdate);
        setIdLogin(idLogin);
    }
    //Insertar
    public ClClaves(String nombre, String pagina, String user, String pass, int idLogin) throws Exception {
        setNombre(nombre);
        setPagina(pagina);
        setUser(user);
        setPass(pass);
        setIdLogin(idLogin);
    }
    //Buscar - Eliminar
    public ClClaves(int id) throws Exception {
        setId(id);
    }
    //Actualizar
    public ClClaves(int id, String nombre, String pagina, String user, String pass, int idLogin) throws Exception {
        setId(id);
        setNombre(nombre);
        setPagina(pagina);
        setUser(user);
        setPass(pass);
        setIdLogin(idLogin);
    }
}
