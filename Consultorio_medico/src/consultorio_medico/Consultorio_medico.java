/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio_medico;

import BD.ConexionBD;
import Login.Init_login;

/**
 *
 * @author Nico
 */
public class Consultorio_medico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConexionBD con= new ConexionBD();
       con.Conexion("prueba_consultorio", "root", "");
       Init_login log=new Init_login();
       log.setVisible(true);
    }
    
}
