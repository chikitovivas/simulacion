/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio_medico;

import Calendario_Consultorio.Ven_calendario;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Nico
 */
public class Proyecto {
    public static Ven_switch Switch;
    
   
    
    public static void main(String[] args) {
        
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame.setDefaultLookAndFeelDecorated(true);

              SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
            Switch= new Ven_switch();
            Switch.setVisible(true);
            Switch.cambiar_vent(new Ven_calendario(null));
               
            }
        });
        
    }
    
}
