/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import static jdk.nashorn.internal.objects.NativeString.split;

/**
 *
 * @author Administrador
 */
public class Ventana_costo extends javax.swing.JFrame {
       // JScrollPane pan = new JScrollPane();
     
     /* Creates new form Ventana_costo
        
     */
    public Ventana_costo() {
        initComponents();
       
        //JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JPanel(),new JPanel(),new JPanel());
        this.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLUE);
        leftPanel.setSize(100, 100);
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.CYAN);
        centerPanel.setSize(100, 100);
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.GREEN);
        rightPanel.setSize(100, 100);

        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
        sp.setSize(100, 100);
        JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, rightPanel);
        sp.setSize(100, 100);
        sp.setDividerLocation(100);
        sp2.setDividerLocation(200);
        sp.setEnabled(false);
        sp2.setEnabled(false);
        
        sp.setDividerSize(0);
        sp2.setDividerSize(0);
        
        JScrollPane pan = new JScrollPane(sp2);
       // this.setLayout ( new  BorderLayout ()); 
        this.add ( pan ,  BorderLayout . CENTER ); 
        //this.add(pan);
        //pan.add(sp);
        //pan.add(sp2);
        
        //this.add(sp2,BorderLayout.CENTER);
        
        
        
        
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setVisible(true);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 184, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ventana_costo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_costo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_costo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_costo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_costo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
