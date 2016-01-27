/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import consultorio_medico.MenuPrincipal;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Nico
 */
public class Ven_login extends javax.swing.JFrame {
    
   
    Cod_login log;
    public static String nickname;
    public static String password;
    public final static String url=
                             //"http://192.168.153.171:8000/";
                             //"http://169.254.105.188:8000/";
                             "http://miconsultoriocal.no-ip.org:8000/";
   
    Pan_olvido polv=null;
    Pan_registro preg=null;
    
    public Ven_login() {                
        initComponents();     
        this.L_warn.setVisible(false); 
    }
    
    public void iniciar_olvido(){
        polv=new Pan_olvido(this.T_nick.getText(),this);
        polv.setVisible(true);
        this.PanelLogin.setVisible(false);
        polv.setLocation(this.PanelLogin.getLocation());
        polv.setSize(polv.getPreferredSize());
        this.setSize(polv.getPreferredSize().width+10, polv.getPreferredSize().height+80);
        this.setResizable(true);
        this.add(polv);    
    }
    
    public void iniciar_login(){
        if(polv!=null){
            polv.setVisible(false);
        }
        if(preg!=null){
            preg.setVisible(false);
        }
        this.PanelLogin.setVisible(true);        
        this.setSize(this.getPreferredSize());
        this.borrar_campos();        
        
    }
    
    public void iniciar_registro() {
        preg=new Pan_registro(this);
        preg.setVisible(true);
        this.PanelLogin.setVisible(false);
        preg.setLocation(this.PanelLogin.getLocation());
        preg.setSize(preg.getPreferredSize());
        this.setSize(preg.getPreferredSize().width+10, preg.getPreferredSize().height+80);
        this.setResizable(true);
        this.add(preg);  
    }
    
    private void borrar_campos(){
        this.L_warn.setVisible(false);
        this.T_nick.setText("");
        this.T_pass.setText("");    
    }
    
    private void Iniciar_menu_medico(String nick){
               Ven_login.nickname=nick;
               MenuPrincipal men=new MenuPrincipal(nick);
               men.setVisible(true);
               this.setVisible(false);
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogin = new javax.swing.JPanel();
        L_user = new javax.swing.JLabel();
        L_pass = new javax.swing.JLabel();
        T_nick = new javax.swing.JTextField();
        T_pass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        L_olvido = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        L_registro = new javax.swing.JLabel();
        L_warn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        L_user.setText("CI:");

        L_pass.setText("Contraseña:");

        T_nick.setText("25620021");

        T_pass.setText("1234");

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        L_olvido.setForeground(new java.awt.Color(0, 0, 255));
        L_olvido.setText("Se le olvido su password?");
        L_olvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_olvidoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L_olvidoMousePressed(evt);
            }
        });

        jButton3.setText("Borrar campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        L_registro.setForeground(new java.awt.Color(0, 0, 255));
        L_registro.setText("Registrarse");
        L_registro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L_registroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L_registroMousePressed(evt);
            }
        });

        L_warn.setForeground(new java.awt.Color(255, 0, 0));
        L_warn.setText("Error en el usuario o en la contraseña");

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_warn)
                    .addComponent(L_registro)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_pass)
                            .addComponent(L_user, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(T_nick)
                            .addComponent(T_pass, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                    .addComponent(L_olvido))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(L_warn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_user)
                    .addComponent(T_nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_pass)
                    .addComponent(T_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(L_olvido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(L_registro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nick=T_nick.getText();
       String pass=T_pass.getText();
       this.log=new Cod_login(nick,pass);
       
       
        try {
            int connect;
            
              
            //POR AHORA            
            //connect = this.log.comprobar_user(); //DESCOMENTAR                        
            connect=0; //QUITAR CUANDO EL SERVIDOR COMPRUEBE USUARIOS
            
            
            switch(connect){
                case 0: this.Iniciar_menu_medico(nick);break; //0 PARA MEDICOS
                case 1: this.Iniciar_menu_medico(nick);break;
                default: this.L_warn.setVisible(true);
            
            }

        } catch (Exception ex) {
            Logger.getLogger(Ven_login.class.getName()).log(Level.SEVERE, null, ex);
            Ven_error err=new Ven_error();
            err.setVisible(true);                   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       T_nick.setText("");
       T_pass.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void L_olvidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_olvidoMouseClicked
        this.iniciar_olvido();
    }//GEN-LAST:event_L_olvidoMouseClicked

    private void L_registroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_registroMouseClicked
        this.iniciar_registro();
    }//GEN-LAST:event_L_registroMouseClicked

    private void L_olvidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_olvidoMousePressed
        this.iniciar_olvido();
    }//GEN-LAST:event_L_olvidoMousePressed

    private void L_registroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_registroMousePressed
        this.iniciar_registro();
    }//GEN-LAST:event_L_registroMousePressed

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
            java.util.logging.Logger.getLogger(Ven_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ven_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ven_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ven_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ven_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_olvido;
    private javax.swing.JLabel L_pass;
    private javax.swing.JLabel L_registro;
    private javax.swing.JLabel L_user;
    private javax.swing.JLabel L_warn;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JTextField T_nick;
    private javax.swing.JTextField T_pass;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

    
}
