/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.DAO;

import Cl.Burgos.Claves.BD.BD;
import Cl.Burgos.Claves.ENT.ClClaves;
import Cl.Burgos.Claves.FUN.MetodoBase64E;
import Cl.Burgos.Claves.Inter.ClavesInter;
import Cl.Burgos.Claves.FUN.Log;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author march
 */
public class DAOClaves implements ClavesInter{

    
    @Override
    public List<ClClaves> leerClientes(int id) {
        List<ClClaves> lista=new ArrayList<>();
        String strConsulta;
        
        strConsulta="select idClaves,nombre,pag,usuario,pass,fechaInert,fechaUpdate,idLogin from Claves where idLogin="+id+";";
        
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         if(rs==null)return null;
         while(rs.next()){
             ClClaves c = new ClClaves(rs.getInt("idClaves"), rs.getString("nombre"), 
                     rs.getString("pag"), rs.getString("usuario"), rs.getString("pass"), 
                     rs.getDate("fechaInert"), rs.getDate("fechaUpdate"), rs.getInt("idLogin"));
              lista.add(c);
         }
         
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        } catch (Exception ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return lista;
    }

    @Override
    public long leerCuantos(String strBusqueda) {
        String strConsulta;
        long cuantos = 0;
        strConsulta="select count(*) as cuantos from Claves;";
//        strConsulta="call ProClavesCuantos('" +strBusqueda +"');";
      
        try{
             ResultSet rs=BD.getInstance().sqlSelect(strConsulta);

                 while(rs.next()){
//                      System.out.println(rs.getString("cuantos"));
                      cuantos=Long.valueOf(rs.getString("cuantos"));

                      return cuantos;

                 }
             rs.close();
          }catch(SQLException e){
              Log.log(e.getMessage());
              return cuantos;
          }
        return cuantos;
    }

    @Override
    public boolean sqlInsert(ClClaves claves) {
        Connection con = BD.getInstance().conectar();
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String stSql =  "insert into claves(nombre,pag,usuario,pass,fechaInert,fechaUpdate,idLogin)values(?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(stSql);
            ps.setString(1, claves.getNombre());
            ps.setString(2, claves.getPagina());
            ps.setString(3, MetodoBase64E.cifrarBase64(claves.getUser()));
            ps.setString(4, MetodoBase64E.cifrarBase64(claves.getPass()));
            ps.setDate(5, sqlDate);
            ps.setDate(6, sqlDate);
            ps.setInt(7, claves.getIdLogin());
            
            ps.execute();
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
            return false;
        }
    }

    @Override
    public String[] leerClaves(ClClaves claves) {
        String strConsulta;
        String datos[]=new String [8];
        
        strConsulta="select idClaves,nombre,pag,usuario,pass,fechaInert,fechaUpdate,idLogin from claves where idClaves="+claves.getId();
//        strConsulta="call ProClavesBuscarID("+claves.getId()+");";
     
      
        try{
         ResultSet rs=BD.getInstance().sqlSelect(strConsulta);
         
         
         while(rs.next()){
              //System.out.println(res.getString("Nombres"));
              datos[0]=rs.getString("idClaves");
              datos[1]=rs.getString("nombre");
              datos[2]=rs.getString("pag");
              datos[3]=rs.getString("usuario");
              datos[4]=rs.getString("pass");
              datos[5]=rs.getString("fechaInert");
              datos[5]=rs.getString("fechaUpdate");
              datos[6]=rs.getString("idLogin");
                      
              rs.close();
              return datos;
              
         }
         rs.close();
          }catch(SQLException e){
         Log.log(e.getMessage());
 
         return datos;
          }
      
        return datos;
    }

    @Override
    public boolean sqlUpdate(ClClaves claves) {
        Connection con = BD.getInstance().conectar();
        String insert = "update Claves set nombre=?,pag=?,usuario=?,pass=?,fechaUpdate=?,idLogin=? WHERE idClaves=?;";
        PreparedStatement ps = null;
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        try {
            ps = con.prepareStatement(insert);
            ps.setString(1, claves.getNombre());
            ps.setString(2, claves.getPagina());
            ps.setString(3, MetodoBase64E.cifrarBase64(claves.getUser()));
            ps.setString(4, MetodoBase64E.cifrarBase64(claves.getPass()));
            ps.setDate(5, sqlDate);
            ps.setInt(6, claves.getIdLogin());
            ps.setInt(7, claves.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlDelete(ClClaves claves) {
        try {
            String stSql =  "delete from Claves WHERE  idClaves=";
            stSql += " '" + claves.getId()+ "'";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }
    
}
