/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_cita;
import java.awt.Graphics;
import javax.swing.ImageIcon; 

/**
 *
 * @author Pat
 */
public class Fondo_Formulariopaciente  extends javax.swing.JPanel { 
    public Fondo_Formulariopaciente(){
      //  this.setSize(700, 800); 
    }
    public void paintComponent(Graphics g){
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Registro_cita/imagenes/fondorosa.png" ) ) ;

        g.drawImage(imagenFondo.getImage(),0,0,395, 493, null);
        setOpaque(false);
        super.paintComponent(g);
    }

}