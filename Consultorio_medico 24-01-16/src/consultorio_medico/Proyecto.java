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
    public static MenuPrincipal principal;
    
   
    
    public static void main(String[] args) {
        
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame.setDefaultLookAndFeelDecorated(true);

            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
            principal= new MenuPrincipal();
            principal.setVisible(true);
          
            }
        });
        
    }
    
}
