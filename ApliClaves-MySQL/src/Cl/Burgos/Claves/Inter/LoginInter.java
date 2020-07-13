/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cl.Burgos.Claves.Inter;

import Cl.Burgos.Claves.ENT.ClLogin;

/**
 *
 * @author Marchelo
 */
public interface LoginInter {
    //******** Sql Validar Login ***
    public boolean sqlSelectValidar(ClLogin login);
    //Buscar el RUT ***
    public boolean sqlSearchRut(ClLogin login);
    //******** Sql insetar *****
    public boolean sqlInsert(ClLogin login);
    //******** Sql actualizar *****
    public boolean sqlUpdate(ClLogin login);
    
    // Metodos de cambios de clave
    //Valida el Usuario 
    public boolean sqlValidar(String rut,String correo,String respSecre);
    //Cambia el estado de cambio pass a si
    public boolean sqlUpdateSolicitud(String rut);
    //valida la clave secreta con la ingresada
    public boolean sqlVerificarPass2(String rut,String key);
    //Cambio de la Password de Login
    public boolean sqlUpdatePass(String rut,String pass);
}
