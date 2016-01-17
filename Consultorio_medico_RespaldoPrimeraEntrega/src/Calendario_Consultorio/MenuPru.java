/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario_Consultorio;


import static Calendario_Consultorio.SwitchPru.PanelPrincipal;
import JSON.Crearjsoncalendario;
import consultorio_medico.Proyecto;
import java.awt.BorderLayout;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.shaper.StandardButtonShaper;

/**
 *
 * @author Nico
 */
public class MenuPru extends javax.swing.JPanel {
   Panel_calendario calendario;  
   Ven_calendario vcan;

    /**
     * Creates new form NewJPanel
     */
    public MenuPru() {
        initComponents();                 
        this.JBcalendario.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        //this.JTconfiguracion.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        //this.JThistorial.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        //this.JBregistro_Citas.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLtitulo = new javax.swing.JLabel();
        JBcalendario = new javax.swing.JButton();

        JLtitulo.setFont(new java.awt.Font("Gisha", 1, 24)); // NOI18N
        JLtitulo.setText("Consultorio Medico");

        JBcalendario.setFont(new java.awt.Font("Gisha", 0, 14)); // NOI18N
        JBcalendario.setText("Calendario");
        JBcalendario.setDefaultCapable(false);
        JBcalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcalendarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLtitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(JBcalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(JLtitulo)
                .addGap(72, 72, 72)
                .addComponent(JBcalendario)
                .addContainerGap(118, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBcalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcalendarioActionPerformed
       
        Crearjsoncalendario prueba=new Crearjsoncalendario(25620021);

        vcan=new Ven_calendario(
            prueba.fil,
            prueba.col,
            prueba.tuplas);                
        vcan.setVisible(true);
        ProyectoPru.Switch.setVisible(false);        
         //this.setVisible(true);
                                   
    }//GEN-LAST:event_JBcalendarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBcalendario;
    private javax.swing.JLabel JLtitulo;
    // End of variables declaration//GEN-END:variables
}