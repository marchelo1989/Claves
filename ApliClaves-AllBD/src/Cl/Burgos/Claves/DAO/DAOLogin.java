/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.DAO;

import Cl.Burgos.Claves.BD.BD;
import Cl.Burgos.Claves.ENT.ClLogin;
import Cl.Burgos.Claves.Inter.LoginInter;
import Cl.Burgos.Claves.FUN.Log;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Marchelo
 */
public class DAOLogin implements LoginInter{
    //Variables del Log4j
    static  Logger log =Logger.getLogger(DAOLogin.class);
    
    @Override
    public boolean sqlSelectValidar(ClLogin login) {
        String stSql =  "select idLogin,rut,nombre,apellido,correo,password,preguntaSecreta,respuestaSecreta,ClaveSecreta,cambioPass from Login where ";
            stSql += "rut='" + login.getRut()+ "'";
            stSql += " and password='" + login.getPassword()+ "'";
            stSql += ";";
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
            log.info(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlSearchRut(ClLogin login) {
        String strConsulta;
        strConsulta="select idLogin,rut,nombre,apellido,correo,password,preguntaSecreta,respuestaSecreta from Login where rut='" +login.getRut() +"';";
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
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlInsert(ClLogin login) {
        Connection con = BD.getInstance().conectar();
        String stSql  = "insert into login(rut,nombre,apellido,correo,password,preguntaSecreta,respuestaSecreta) values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(stSql);
            ps.setString(1, login.getRut());
            ps.setString(2, login.getNombre());
            ps.setString(3, login.getApellido());
            ps.setString(4, login.getCorreo());
            ps.setString(5, login.getPassword());
            ps.setString(6, login.getPreguntaSecreta());
            ps.setString(7, login.getRespuestaSecreta());
            
            ps.execute();
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean sqlUpdate(ClLogin login) {
        Connection con = BD.getInstance().conectar();
        String stSql =  "update login set nombre=?, apellido=?, correo=?, preguntaSecreta=?, respuestaSecreta=? where rut=?;";
        PreparedStatement ps = null;
        try {            
            ps = con.prepareStatement(stSql);
            ps.setString(1, login.getNombre());
            ps.setString(2, login.getApellido());
            ps.setString(3, login.getCorreo());
            ps.setString(4, login.getPreguntaSecreta());
            ps.setString(5, login.getRespuestaSecreta());
            ps.setString(6, login.getRut());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlValidar(String rut, String correo, String respSecre) {
        String stSql =  "select idLogin, rut, nombre, apellido, correo, password, preguntaSecreta, respuestaSecreta, claveSecreta from login where ";
            stSql += "rut='" + rut+ "'";
            stSql += " and correo='" + correo+ "'";
            stSql += " and respuestaSecreta='" + respSecre+ "'";
            stSql += ";";
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
            log.info(ex.getMessage());
            return false;
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean sqlUpdateSolicitud(String rut) {
        try {
            String stSql =  "update login set cambioPass='si', claveSecreta='0' ";
            stSql += "WHERE rut='" + rut+ "'";
            stSql += ";";
//            String stSql =  "UPDATE `login` SET `cambioPass`='si', claveSecreta='' WHERE `rut`='"+login.getRut()+"';";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlVerificarPass2(String rut, String key) {
        String stSql =  "select idLogin, rut, nombre, apellido, correo, password, preguntaSecreta, respuestaSecreta, claveSecreta from login where ";
            stSql += "rut='" + rut+ "'";
            stSql += " and claveSecreta='" + key+ "'";
            stSql += ";";
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
            log.info(ex.getMessage());
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlUpdatePass(String rut, String pass) {
        try {
             String stSql =  "update login set claveSecreta=null ,cambioPass=null";
            
            stSql += ",password='" + pass+ "'";
            stSql += "WHERE rut='" + rut+ "'";
            stSql += ";";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            log.info(ex.getMessage());
        }
        return false;
    }

}
