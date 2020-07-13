/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.Inter;

import Cl.Burgos.Claves.ENT.ClClaves;
import java.util.List;

/**
 *
 * @author march
 */
public interface ClavesInter {
    public List<ClClaves> leerClientes(int id);
    public long leerCuantos(String strBusqueda);
    public String[] leerClaves(ClClaves claves);
    
    public boolean sqlInsert(ClClaves claves);
    public boolean sqlUpdate(ClClaves claves);
    public boolean sqlDelete(ClClaves claves);
    
}
