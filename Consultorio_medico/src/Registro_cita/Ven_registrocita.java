/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_cita;
import JSON.JSON;
import consultorio_medico.Proyecto;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import Registro_cita.Cod_registrocita;
/**
 *
 * @author Pat
 */
public class Ven_registrocita extends javax.swing.JFrame {

    /**
     * Creates new form Ven_registrocita
     */
    Date fechahoraG;
    
    public Ven_registrocita(Date fecha_hora) {
       
        fechahoraG=fecha_hora;
        
        initComponents(); 
    }
    
     /*  public Ven_registrocita(Date fecha_hora, String[] datos ) {
        Date jk = new Date();
                jk=fecha_hora;
        
        initComponents();     
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLtitulo = new javax.swing.JLabel();
        JLci = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLapellido = new javax.swing.JLabel();
        JLtelefono = new javax.swing.JLabel();
        JLemail = new javax.swing.JLabel();
        JTci = new javax.swing.JTextField();
        JTnombre = new javax.swing.JTextField();
        JTapellido = new javax.swing.JTextField();
        JTtelefono = new javax.swing.JTextField();
        JTemail = new javax.swing.JTextField();
        BotonCancelar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BotonCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("formulariopaciente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Datos Paciente");

        JLci.setText("C.I:");

        JLnombre.setText("Nombre:");

        JLapellido.setText("Apellido:");

        JLtelefono.setText("Télefono:");

        JLemail.setText("Email:");

        JTci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTciActionPerformed(evt);
            }
        });

        JTnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTnombreActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(JLtitulo)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonCancelar)
                        .addGap(41, 41, 41)
                        .addComponent(BotonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(BotonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLtelefono)
                            .addComponent(JLemail)
                            .addComponent(JLnombre)
                            .addComponent(JLci)
                            .addComponent(JLapellido))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTnombre)
                            .addComponent(JTci)
                            .addComponent(JTtelefono)
                            .addComponent(JTemail, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(JTapellido))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(JLtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLci)
                    .addComponent(JTci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLnombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLapellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLtelefono))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLemail)
                    .addComponent(JTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelar)
                    .addComponent(BotonLimpiar)
                    .addComponent(BotonCrear))
                .addGap(37, 37, 37))
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
        
        this.add (AplicarFondo, BorderLayout.SOUTH);
        AplicarFondo.repaint();
   
    }//GEN-LAST:event_formWindowOpened

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose ( ) ;
    }//GEN-LAST:event_BotonCancelarActionPerformed

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        JTnombre.setText("") ; 
        JTci.setText("");
        JTapellido.setText("");
        JTtelefono.setText("") ; 
        JTemail.setText("") ; 
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed
                        
            String datos[] = new String [6];
            
            
            if (JTci.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese cedula del paciente");
            }else{
                datos[0] = JTci.getText();
            }
            
            if (JTnombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese Nombre del paciente");
            }else{
                datos[1] = JTnombre.getText();
            }
            
            if (JTapellido.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese Apellido del paciente");
            }else{
                datos[2] = JTapellido.getText();
            }
            
            if (JTtelefono.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor ingrese Telefono del paciente");
            }else{
                datos[3]= JTtelefono.getText();
            }
            
            datos[4]= "25620021";
            datos[5]= fechahoraG.toString(); //dd-mm-aaaa 24:00   
            
            Cod_registrocita(datos);
        
        
    }//GEN-LAST:event_BotonCrearActionPerformed

    private void JTciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTciActionPerformed

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
               
                new Ven_registrocita(fecha).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonCrear;
    private javax.swing.JButton BotonLimpiar;
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
    // End of variables declaration//GEN-END:variables

    private void Cod_registrocita(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

