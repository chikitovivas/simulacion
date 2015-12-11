/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario_Consultorio;

import consultorio_medico.*;
import Calendario_Consultorio.Ven_calendario;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Nico
 */
public class ProyectoPru {
    public static SwitchPru Switch;
    
   
    
    public static void main(String[] args) {
        
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame.setDefaultLookAndFeelDecorated(true);

            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
            Switch= new SwitchPru(" UCAB   -   Consultotio Médico");
            Switch.setVisible(true);  
               
            }
        });
        
    }
    
}
