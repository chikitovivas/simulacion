/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_cita;

import JSON.JSON;
import Lista_citas.Ven_registrocita_1;
import consultorio_medico.Proyecto;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import Registro_cita.Cod_registrocita;
import consultorio_medico.Menu;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.shaper.StandardButtonShaper;

/**
 *
 * @author Pat
 */
public class Ven_registrocita extends javax.swing.JFrame {

    /**
     * Creates new form Ven_registrocita
     */
    
    Object[] arreglo_datos;
    String sday;
    int day;
    int moth; 
    int year;
    String fechahoraG;
    
   
    public Ven_registrocita(String fecha_hora) {
        this.fechahoraG = fecha_hora;

        initComponents();


        
        this.BotonCrear.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.BotonCancelar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.BotonLimpiar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.JBback.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
    }

        


 public Ven_registrocita(Object[][] arreglo_datos, String sday,int day, int moth, int year, String fecha_hora) {
       
     
     
     this.fechahoraG = fecha_hora;  
     this.arreglo_datos=arreglo_datos;  
     this.sday=sday;
     this.day=day;
     this.moth=moth; 
     this.year=year;
        
        initComponents();

        JFrame.setDefaultLookAndFeelDecorated(true);
        
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
        
        this.BotonCrear.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.BotonCancelar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        this.BotonLimpiar.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new StandardButtonShaper());
        System.out.println("llego al construcotr");
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
        jPanel1 = new javax.swing.JPanel();
        JTapellido = new javax.swing.JTextField();
        JTtelefono = new javax.swing.JTextField();
        JTemail = new javax.swing.JTextField();
        BotonCancelar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BotonCrear = new javax.swing.JButton();
        JLci = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLapellido = new javax.swing.JLabel();
        JLtelefono = new javax.swing.JLabel();
        JLemail = new javax.swing.JLabel();
        JTci = new javax.swing.JTextField();
        JTnombre = new javax.swing.JTextField();
        JBback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("formulariopaciente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Datos Paciente");

        JTapellido.setText("asdsd");

        JTtelefono.setText("3454653");

        JTemail.setText("dghfgjgfnjh");
        JTemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTemailActionPerformed(evt);
            }
        });

        BotonCancelar.setText("Cancelar");
        BotonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelarActionPerformed(evt);
            }
        });

        BotonLimpiar.setText("Limpiar");
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });

        BotonCrear.setText("Crear");
        BotonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }
        });

        JLci.setText("C.I:");

        JLnombre.setText("Nombre:");

        JLapellido.setText("Apellido:");

        JLtelefono.setText("Télefono:");

        JLemail.setText("Email:");

        JTci.setText("2020020");
        JTci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTciActionPerformed(evt);
            }
        });

        JTnombre.setText("wasd");
        JTnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTnombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JLnombre)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLapellido)
                            .addComponent(JLtelefono)
                            .addComponent(JLemail)
                            .addComponent(JLci))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JTci)
                    .addComponent(JTtelefono, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTemail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTapellido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTnombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLci)
                    .addComponent(JTci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLnombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLapellido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLtelefono))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLemail))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelar)
                    .addComponent(BotonLimpiar)
                    .addComponent(BotonCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBback.setFont(new java.awt.Font("Gisha", 0, 12)); // NOI18N
        JBback.setText("Back");
        JBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBback)
                        .addGap(132, 132, 132)
                        .addComponent(JLtitulo))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLtitulo)
                    .addComponent(JBback))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void JTnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnombreActionPerformed

    private void JTemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTemailActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Fondo_Formulariopaciente AplicarFondo = new Fondo_Formulariopaciente();

        this.add(AplicarFondo, BorderLayout.SOUTH);
        AplicarFondo.repaint();

    }//GEN-LAST:event_formWindowOpened

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
        // TODO add your handling code here:        
        this.dispose();
    }//GEN-LAST:event_BotonCancelarActionPerformed

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        JTnombre.setText("");
        JTci.setText("");
        JTapellido.setText("");
        JTtelefono.setText("");
        JTemail.setText("");
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed

        String datos[] = new String[7];

        if (JTci.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese cedula del paciente");
        } else {
            datos[0] = JTci.getText();
        }

        if (JTnombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese Nombre del paciente");
        } else {
            datos[1] = JTnombre.getText();
        }

        if (JTapellido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese Apellido del paciente");
        } else {
            datos[2] = JTapellido.getText();
        }

        if (JTtelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese Telefono del paciente");
        } else {
            datos[3] = JTtelefono.getText();
        }
        if (JTemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese Email del paciente");
        } else {
            datos[4] = JTemail.getText();
        }

        datos[5] = "25620021";
        datos[6] = fechahoraG; //dd-mm-aaaa 24:00   

        new Cod_registrocita(datos);


    }//GEN-LAST:event_BotonCrearActionPerformed

    private void JTciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTciActionPerformed

    private void JBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbackActionPerformed
        // TODO add your handling code here:
        
      //  Llamada a Carlos;
      // Proyecto.Switch.cambiar_vent(new Menu());
        
    }//GEN-LAST:event_JBbackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ven_registrocita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ven_registrocita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ven_registrocita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ven_registrocita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Date fecha = new Date();

                new Ven_registrocita(null,null,0, 0,0, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonCrear;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton JBback;
    private javax.swing.JLabel JLapellido;
    private javax.swing.JLabel JLci;
    private javax.swing.JLabel JLemail;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLtelefono;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JTextField JTapellido;
    private javax.swing.JTextField JTci;
    private javax.swing.JTextField JTemail;
    private javax.swing.JTextField JTnombre;
    private javax.swing.JTextField JTtelefono;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
