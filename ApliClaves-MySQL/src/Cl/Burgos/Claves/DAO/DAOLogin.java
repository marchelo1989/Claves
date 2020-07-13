/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.DAO;

import Cl.Burgos.Claves.BD.BD;
import Cl.Burgos.Claves.ENT.ClLogin;
import Cl.Burgos.Claves.Inter.LoginInter;
import Cl.Burgos.Claves.BD.Log;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marchelo
 */
public class DAOLogin implements LoginInter{
    @Override
    public boolean sqlSelectValidar(ClLogin login) {
        String stSql =  "Call ProLoginValidar (";
            stSql += "'" + login.getRut()+ "'";
            stSql += ",'" + login.getPassword()+ "'";
            stSql += ")";
        try {
            ResultSet rs = BD.getInstance().sqlSelect(stSql);
            if(rs==null || !rs.next())return false;
            login.setId(rs.getInt("idLogin")) ;
            login.setRut(rs.getString("rut")) ;
            login.setNombre(rs.getString("nombre")) ;
            login.setApellido(rs.getString("apellido")) ;
            login.setCorreo(rs.getString("correo")) ;
            login.setPassword(rs.getString("password")) ;
            login.setPreguntaSecreta(rs.getString("preguntaSecreta"));
            login.setRespuestaSecreta(rs.getString("respuestaSecreta"));
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlSearchRut(ClLogin login) {
        String strConsulta;
        strConsulta="call ProLoginBuscarRut('" +login.getRut() +"');";
        try {
            ResultSet rs = BD.getInstance().sqlSelect(strConsulta);
            if(rs==null || !rs.next())return false;
            login.setId(rs.getInt("idLogin")) ;
            login.setRut(rs.getString("rut")) ;
            login.setNombre(rs.getString("nombre")) ;
            login.setApellido(rs.getString("apellido")) ;
            login.setCorreo(rs.getString("correo")) ;
            login.setPassword(rs.getString("password")) ;
            login.setPreguntaSecreta(rs.getString("preguntaSecreta"));
            login.setRespuestaSecreta(rs.getString("respuestaSecreta"));
            return true;
        } catch (SQLException ex) {
            Log.log(ex.getMessage());
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlInsert(ClLogin login) {
        try {
            String stSql  = "CALL ProLoginInsertar(";
            stSql += "'" + login.getRut()+ "'";
            stSql += ",'" + login.getNombre()+ "'";
            stSql += ",'" + login.getApellido()+ "'";
            stSql += ",'" + login.getCorreo()+ "'";
            stSql += ",'" + login.getPassword()+ "'";
            stSql += ",'" + login.getPreguntaSecreta()+ "'";
            stSql += ",'" + login.getRespuestaSecreta()+ "'";
            stSql += " )";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean sqlUpdate(ClLogin login) {
        try {
            String stSql =  "Call ProLoginUpdateSolicitud (";
            stSql += "'" + login.getRut()+ "'";
            stSql += "'" + login.getNombre()+ "'";
            stSql += "'" + login.getApellido()+ "'";
            stSql += "'" + login.getCorreo()+ "'";
            stSql += "'" + login.getPreguntaSecreta()+ "'";
            stSql += "'" + login.getRespuestaSecreta()+ "'";
            stSql += ")";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlValidar(String rut, String correo, String respSecre) {
        String stSql =  "Call ProLoginValidarCuenta (";
            stSql += "'" + rut+ "'";
            stSql += ",'" + correo+ "'";
            stSql += ",'" + respSecre+ "'";
            stSql += ")";
        try {
            ResultSet rs = BD.getInstance().sqlSelect(stSql);
            if(rs==null || !rs.next())return false;
//            login.setId(rs.getInt("idLogin")) ;
//            login.setRut(rs.getString("rut")) ;
//            login.setNombre(rs.getString("nombre")) ;
//            login.setApellido(rs.getString("apellido")) ;
//            login.setCorreo(rs.getString("correo")) ;
//            login.setPassword(rs.getString("password")) ;
//            login.setPreguntaSecreta(rs.getString("preguntaSecreta"));
//            login.setRespuestaSecreta(rs.getString("respuestaSecreta"));
            return true;
        } catch (SQLException ex) {
            Log.log(ex.getMessage());
            return false;
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean sqlUpdateSolicitud(String rut) {
        try {
            String stSql =  "Call ProLoginUpdateSolicitud (";
            stSql += "'" + rut+ "'";
            stSql += ")";
//            String stSql =  "UPDATE `login` SET `cambioPass`='si', claveSecreta='' WHERE `rut`='"+login.getRut()+"';";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlVerificarPass2(String rut, String key) {
        String stSql =  "Call ProLoginValidarClave (";
            stSql += "'" + rut+ "'";
            stSql += ",'" + key+ "'";
            stSql += ")";
        try {
            ResultSet rs = BD.getInstance().sqlSelect(stSql);
            if(rs==null || !rs.next())return false;
//            login.setId(rs.getInt("idLogin")) ;
//            login.setRut(rs.getString("rut")) ;
//            login.setNombre(rs.getString("nombre")) ;
//            login.setApellido(rs.getString("apellido")) ;
//            login.setCorreo(rs.getString("correo")) ;
//            login.setPassword(rs.getString("password")) ;
//            login.setPreguntaSecreta(rs.getString("preguntaSecreta"));
//            login.setRespuestaSecreta(rs.getString("respuestaSecreta"));
            return true;
        } catch (SQLException ex) {
            Log.log(ex.getMessage());
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlUpdatePass(String rut, String pass) {
        try {
             String stSql =  "Call ProLoginCambioPass (";
            stSql += "'" + rut+ "'";
            stSql += ",'" + pass+ "'";
            stSql += ")";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

}
