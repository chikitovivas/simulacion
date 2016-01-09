/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JButton;
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
     /* Creates new form Ventana_costo
        
     */
    JScrollPane scroll = new JScrollPane();
    JPanel panel1 = new JPanel();
    JPanel panel = new JPanel();
    
    static DefaultTableModel tabla = new DefaultTableModel();
    static List fila = new ArrayList();
    static JTable tbl = new JTable();
    
    public Ventana_costo() {
        //initComponents();
       
        //JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JPanel(),new JPanel(),new JPanel());
        this.setLayout(new BorderLayout());
/* · PANELS
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
        
        //JScrollPane pan = new JScrollPane(sp2);
        //Primer Label
        JLabel label = new JLabel("Label");
        label.setPreferredSize(new Dimension(100, 20));
        //Segundo Label
        JLabel label2 = new JLabel("Label2");
        label2.setPreferredSize(new Dimension(100, 20));

        //ScrollPane
        JScrollPane pan = new JScrollPane();
        
        //JPanel
        JPanel content = new JPanel();
        
        //A#adir los dos label a Jpanel
        content.add(label);
        content.add(label2);
        //Seteo del Viewport
        pan.setViewportView(content);
        //pan.getViewport().add(label,null);
        //pan.getViewport().add(label2,null);
        
        //pan.getViewport().add(jButton1, null);
        //pan.add(sp).setBounds(500, 500, 10, 10);
       // this.setLayout ( new  BorderLayout ()); */

       // this.add ( pan ,  BorderLayout . CENTER ); 
//
//
//        //this.add(pan);
//        //pan.add(sp);
//        //pan.add(sp2);
//        
//        //this.add(sp2,BorderLayout.CENTER);*/
//        
//        
//        
//        
//           
//            
//            JLabel Ltitulo,Ltitulo2, Tq, Tr, Tcinventario, Tcorden, Tcfaltante, Tctotal;                       
//            JLabel Valorq, Valorr, Valorcinventario, Valorcorden, Valorcfaltante, Valorctotal;
//            Font bold = new Font("Arial", 0, 14);
//            Font boldTitulo = new Font("Arial", Font.BOLD, 20);
//            Font plain = new Font("Arial", Font.PLAIN, 14);
//            
//            DecimalFormat format =new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
//                
//             /*
//                    q*          Costo Inventario        Costo Total
//                    R*          Costo de Orden
//                                Costo faltante
//                */
//            
//            /*boton.setBounds(x, y, width, height);*/
//            
//            Ltitulo = new JLabel("Variación De Costos para Q y R");
//            //Ltitulo.setSize(700, 70);
//            Ltitulo.setBounds(800,20,300,30);
//            Ltitulo.setFont(boldTitulo);
//            Ltitulo.setLocation(140, 10);
//            
//            Ltitulo2 = new JLabel("Simulación de Inventario");
//            Ltitulo2.setFont(new java.awt.Font("Arial", 1, 14));
//            Ltitulo2.setBounds(900,200,350,50);
//            Ltitulo2.setLocation(200, 20);
//            
//            panel.add(Ltitulo);
//            panel.add(Ltitulo2);
//            
//            Tq = new JLabel("Q: ");
//            Tq.setFont(new java.awt.Font("Arial", 1, 14));
//          //  Tq.setFont(bold);
//            Tq.setBounds(900,200,350,50);
//            Tq.setLocation(50, 75);
//            
////            Valorq = new JLabel(Integer.toString(q));
////           // Tq.setFont(plain);
////            Valorq.setFont(plain);
////            Valorq.setBounds(900,200,350,50);
////            Valorq.setLocation(70, 75);
//            
//            Tr = new JLabel("R: ");
//            Tr.setFont(new java.awt.Font("Arial", 1, 14));
//            Tr.setBounds(900,200,350,50);
//            Tr.setLocation(50, 90);
//            
////            Valorr = new JLabel(Integer.toString(r));
////            Valorr.setBounds(900,200,350,50);
////            Valorr.setFont(plain);
////            Valorr.setLocation(70, 90);
//            
//            Tcinventario = new JLabel("Costo de Inventario:");
//            Tcinventario.setFont(new java.awt.Font("Arial", 1, 14));
//            Tcinventario.setBounds(900,200,350,50);
//            Tcinventario.setLocation(150, 75);
//            
////            Valorcinventario = new JLabel(format.format(costoInventario));
////            Valorcinventario.setBounds(900,200,350,50);
////            Valorcinventario.setFont(plain);
////            Valorcinventario.setLocation(300, 75);
//            
//            Tcorden = new JLabel("Costo de Oden:");
//            Tcorden.setFont(new java.awt.Font("Arial", 1, 14));
//            Tcorden.setBounds(900,200,350,50);
//            Tcorden.setLocation(150, 90);
//            
////            Valorcorden = new JLabel(format.format(costoOrden));
////            Valorcorden.setBounds(900,200,350,50);
////            Valorcorden.setFont(plain);
////            Valorcorden.setLocation(300, 90);
//            
//            Tcfaltante = new JLabel("Costo Faltante:");
//            Tcfaltante.setFont(new java.awt.Font("Arial", 1, 14));
//            Tcfaltante.setBounds(900,200,350,50);
//            Tcfaltante.setLocation(150, 105);
//            
////            Valorcfaltante = new JLabel(format.format(costo_faltante));
////            Valorcfaltante.setBounds(900,200,350,50);
////            Valorcfaltante.setFont(plain);
////            Valorcfaltante.setLocation(300, 105);
//            
//            Tctotal = new JLabel("Costo Total:");
//            Tctotal.setFont(new java.awt.Font("Arial", 1, 14));
//            Tctotal.setBounds(900,200,350,50);
//            Tctotal.setLocation(390, 75);
//            
////            Valorctotal = new JLabel(format.format(costo_total));
////            Valorctotal.setBounds(900,200,350,50);
////            Valorctotal.setFont(plain);
////            Valorctotal.setLocation(480, 75);
//            
//            
//            
//            panel1.add(Tq);
//            panel1.add(Tr);
//            panel1.add(Tcinventario);
//            panel1.add(Tcorden);
//            panel1.add(Tcfaltante);
//            panel1.add(Tctotal);
////            panel1.add(Valorq);
////            panel1.add(Valorr);
////            panel1.add(Valorcinventario);
////            panel1.add(Valorcorden);
////            panel1.add(Valorcfaltante);
////            panel1.add(Valorctotal);
//            panel.setLayout(null);
//            panel1.setLayout(null);
//            //scroll.setLayout(null);
//        
//        panel1.setSize(500, 900);    
//        
//       
//        
//       
//        panel.add(panel1);
//          
//        //scroll.setAutoscrolls(true);
//        scroll.setPreferredSize(new java.awt.Dimension(800, 400));
//       // scroll.setWheelScrollingEnabled(true);
//        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        //scroll.getViewport().setViewPosition(p); // para que la barra baje automaticamente
//        scroll.setViewportView(panel);
          


//
//        //super("Simulación");
//        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        //this.setLocationRelativeTo(null);
//        this.setLocation(200, 150);
//        this.setSize(1200,700);
         
        
       
        
        
        
            tabla.addColumn("Q");
            tabla.addColumn("R");
            tabla.addColumn("Costo Inventario");
            tabla.addColumn("Costo Orden");
            tabla.addColumn("Costo Faltante");
            tabla.addColumn("Costo Total");
            
               
        

       // this.add(scroll);
        // this.add ( scroll ,  BorderLayout . CENTER );
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(900, 800);
        this.setVisible(true);
                
    }
    
    
    
    public static void Añadir_filas (int Q, int R, double costo_inventario, double costo_orden, double costo_faltante, double costototal){
    
            fila.add(Integer.toString(Q)); 
            fila.add(Integer.toString(R)); 
            fila.add(Double.toString(costo_inventario));
            fila.add(Double.toString(costo_orden));
            fila.add(Double.toString(costototal));
    
            tabla.addRow(fila.toArray());
            fila.clear();
    
    }
    
    public static void Modelo_table (){
            tbl.setModel(tabla);
            
            
            /* Para centrar las celdas*/        
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i=1; i<12; i++){
                    tbl.getColumnModel().getColumn(i).setCellRenderer(modelocentrar); 
                    
                }
                
            JScrollPane panel =new JScrollPane(tbl);
            
            
            
            Ventana_costo venprincipal = new Ventana_costo ();
            
            venprincipal.add(panel);
            venprincipal.setVisible(true);
            //this.getContentPane().add(panel);
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
