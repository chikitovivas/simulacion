/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import static jdk.nashorn.internal.objects.NativeString.split;

/**
 *
 * @author Administrador
 */
public class Ventana_costo extends javax.swing.JFrame { 
    /* IMPORTAAAAAAAAAAAAAAANTE
        LEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER  
    
    1. Realizas la inicializacion de Ventana_costo al iniciar home
    2. inmediatamente llamas a Añadir_columnas ();
    3. cuando estes haciendo el recorrido de q y r, antes de terminar el for para pasar a la siguiente numero, 
       llamas a Añadir_filas (int Q, int R, double costo_inventario, double costo_orden, double costo_faltante, double costototal); 
       con todos sus atributos
    
    AL FINAL DE TOOOOOOOOOOOOOOOOOOODO, de terminar todas las q y las r
    4. Llamas a Modelo_table ();
    
    ESTO SIRVE PERFECTO, YA LO PROBE en otro proyecto, si no te sirve es pq estas haciendo las llamas mal.
    
    
    
    EJ: esto es una version mini de lo que deberia ser Home
    
    
            Ventana_costo ventana = new Ventana_costo();
                ventana.Añadir_columnas();
                for (int i=0; i<10; i++){
                    ventana.Añadir_filas(i, i+1, i+0.5, i+0.6, i+0.7, i+0.8);
                }
            
                ventana.Modelo_table();
    
    
    */

    static DefaultTableModel tabla = new DefaultTableModel();
    static List fila = new ArrayList();
    static JTable tbl = new JTable();
    
    static JPanel pantalla;
    static Ventana_costo mostrar;
    static DecimalFormat format =new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
    public Ventana_costo() {
        super("Variacion de Q y R");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(100, 200);
        this.setSize(600, 500);
        //this.setVisible(true);
                
    }
    
    public static void Añadir_columnas (){
      
            tabla.addColumn("Q");
            tabla.addColumn("R");
            tabla.addColumn("Costo Inventario");
            tabla.addColumn("Costo Orden");
            tabla.addColumn("Costo Faltante");
            tabla.addColumn("Costo Total");
            
    }
    
    public static void Añadir_filas (int Q, int R, double costo_inventario, double costo_orden, double costo_faltante, double costototal){
    
            fila.add(Integer.toString(Q)); 
            fila.add(Integer.toString(R)); 
            fila.add(format.format(costo_inventario));
            fila.add(format.format(costo_orden));
            fila.add(format.format(costo_faltante));            
            fila.add(format.format(costototal));
            tabla.addRow(fila.toArray());
            fila.clear();
    
    }
    
    public static void Modelo_table (){
            tbl.setModel(tabla);
            
            /* Para centrar las celdas*/
            DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
            modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i=0; i<6; i++){ 
                tbl.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
            }
            
            JScrollPane panel =new JScrollPane(tbl);
             
            JLabel Ltitulo, Ltitulo2;
            
             JPanel paneltitulos = new JPanel();
                paneltitulos.setLayout(null);
                Ltitulo = new JLabel("Variación De Costos para Q y R");
                Ltitulo.setBounds(800,20,300,30);
                Ltitulo.setFont(new java.awt.Font("Arial", 1, 20));
                Ltitulo.setForeground(white);
                Ltitulo.setLocation(450, 10);

                Ltitulo2 = new JLabel("Simulación de Inventario");
                Ltitulo2.setFont(new java.awt.Font("Arial", 1, 14));
                Ltitulo2.setBounds(900,200,350,50); 
                Ltitulo2.setForeground(white);
                Ltitulo2.setLocation(510, 20);
                
                
                paneltitulos.add(Ltitulo);
                paneltitulos.add(Ltitulo2);
            Color azul =new Color(1, 28, 82);
            paneltitulos.setBackground(azul);
            panel.setBackground(azul);
            JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JScrollPane(),new JScrollPane(panel));
            
            split.setTopComponent(paneltitulos);
            
            split.setDividerLocation(90);
            split.setEnabled(false);
            
            
            
            Ventana_costo venprincipal = new Ventana_costo ();
            venprincipal.getContentPane().add(split);
            
            pantalla = (JPanel) venprincipal.getContentPane();
            mostrar = venprincipal;
    }
    
    public JPanel getComponent(){
        
        return this.pantalla;
        
    }
    
    public void visible(){
            this.mostrar.setVisible(true);
    }
    
    public void limpiarmodelo(){
     
        tabla.setColumnCount(0);
        tabla.setRowCount(0);
       
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
        setBackground(new java.awt.Color(1, 55, 167));

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
