/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio_medico;

import BD.ConexionBD;
import Calendario_Consultorio.Ven_calendario;
import Login.Ven_login;
import java.sql.Connection;

/**
 *
 * @author Nico
 */
public class Proyecto {
   
    static public ConexionBD con=new ConexionBD();
    public static void main(String[] args) {
        //con.Conexion("prueba_consultorio", "root", "");        
       //Ven_login log=new Ven_login();
       //log.setVisible(true);
        
        new Ven_calendario().setVisible(true);
        
    }
    
}
