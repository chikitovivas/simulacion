/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import javax.swing.JFrame;

/**
 *
 * @author Administrador
 */
public class Framefondo extends JFrame{
    private final PanelFondo p = new PanelFondo();

    public Framefondo() {
        this.setContentPane(p);
    }
}
