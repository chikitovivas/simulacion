/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio_medico;

import BD.ConexionBD;
import Calendario_Consultorio.Ven_calendario;

/**
 *
 * @author Nico
 */
public class Proyecto {
    static Ven_switch Switch;
    
    static public ConexionBD con=new ConexionBD();
    
    public static void main(String[] args) {
        
       Switch= new Ven_switch();
       Switch.setVisible(true);
       Switch.cambiar_vent(new Ven_calendario(null));
        
    }
    
}
