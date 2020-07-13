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
import Cl.Burgos.Claves.BD.Log;
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
        
        strConsulta="call ProClavesBuscarIdLogin("+id+");";
        
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
        strConsulta="call ProClavesCuantos('" +strBusqueda +"');";
      
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
        try {
            String stSql =  "Call ProClavesInsertar (";
            stSql += "'" + claves.getNombre()+ "'";
            stSql += ",'" + claves.getPagina()+ "'";
            
            stSql += ",'" + MetodoBase64E.cifrarBase64(claves.getUser())+ "'";
            stSql += ",'" + MetodoBase64E.cifrarBase64(claves.getPass())+ "'";
            
            stSql += ",'" + claves.getIdLogin()+ "'";
            stSql += ")";
            return BD.getInstance().sqlEjecutar(stSql);
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
        
        strConsulta="call ProClavesBuscarID("+claves.getId()+");";
     
      
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
        try {
            String stSql =  "Call ProClavesModificar (";
            stSql += "'"+claves.getNombre()+"',";
            stSql += "'"+claves.getPagina()+"',";
            stSql += "'"+MetodoBase64E.cifrarBase64(claves.getUser())+"',";
            stSql += "'"+MetodoBase64E.cifrarBase64(claves.getPass())+"',";
            stSql += "'"+claves.getIdLogin()+"',";
            stSql += "'"+claves.getId()+"'";
            stSql += ")";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean sqlDelete(ClClaves claves) {
        try {
            String stSql =  "call ProClavesEliminar(";
            stSql += " '" + claves.getId()+ "')";
            return BD.getInstance().sqlEjecutar(stSql);
        } catch (SQLException ex) {
//            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
            Log.log(ex.getMessage());
        }
        return false;
    }
    
}
