/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.Vector;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Administrador
 */
public class tablasimulacion extends javax.swing.JFrame {
    int demanda_diaria;
    int tiempo_espera;
    int dia_orden=0;
    int faltante;
    int inventario_fin;
    Clase_retorno clase;
    Funciones func = new Funciones();
    int inventario_promedio;
    int numero_orden=0;
    
    /**
     * Creates new form tablasimulacion
     */
    public tablasimulacion(int q, int r, 
                            double[][] matriz_acum_demanda, double[][] matriz_acum_entrega,double[][] matriz_acum_espera, 
                            double costoInventario, double costoOrden, double costo_sin_espera, double costo_con_espera, 
                            int inventario_ini, double[] aleatorios) {
        
        super("Simulación");
        //this.setLocationRelativeTo(null);
        this.setLocation(200, 150);
        this.setSize(1200,600);
         
        /* Creo una instancia de la clase Vector llamada 'columnas' */
        Vector columnas = new Vector();
        /* 
            A ese vector le agrego datos, estos datos vendrán a ser las
            columnas de la tabla.
        */
        
            columnas.add("Dia");
            columnas.add("Inv. Ini");
            columnas.add("No. Alea. demanda");
            columnas.add("Demanda");
            columnas.add("Inv Final");
            columnas.add("Inv Prom.");
            columnas.add("Faltante");
            columnas.add("No. Orden");
            columnas.add("No. Alea. tiempo entrega");
            columnas.add("Tiempo de entrega");
            columnas.add("No. Alea. tiempo espera");
            columnas.add("Tiempo Espera");
        
            /* 
            Creo una instancia de la clase Vector llamada 'filas' , este vector
            tendrá todas las filas de la tabla.
        */
        Vector filas = new Vector();
         
        /*
            Creo otro objeto de la clase Vector llamado 'fila', esto representará a
            una fila en particular y cada elemento que agregue a este vector
            será una celda.
         */
        Vector fila = new Vector();
        
        
        
        java.util.List<double[]> lista_clientes = new ArrayList<>();    
           
         /* dias de simulacion*/
                for(int i = 1, ale = 0 ; i <= 365; i++){  
                    /* if para ver si ya la orden llego*/                    
                    if(tiempo_espera + dia_orden < i && dia_orden != 0){
                        inventario_ini =  inventario_ini + q;
                        clase = func.fllegada_pedidos(lista_clientes,inventario_ini);
                        inventario_ini = clase.getQ();
                        lista_clientes = clase.getList();
                        dia_orden = 0;
                    }
                    /* aleatorio demanda*/
                    demanda_diaria = Funciones.fcompare(aleatorios[ale],matriz_acum_demanda);
                    ale++;
                    /* demanda_diaria */
                    //demanda_diaria = Funciones.fcompare(array[i-1],matriz_acum_demanda);
                    /* inventario final */
                    inventario_fin = (int)inventario_ini - demanda_diaria;
                    /* si inventario es negativo, es decir, hay faltante */
                    if(inventario_fin < 0){
                        faltante = Math.abs(inventario_fin);
                        lista_clientes.add(new double[] {Funciones.fcompare(aleatorios[ale],matriz_acum_espera) , faltante});
                        ale++;
                        inventario_fin = 0;
                        /* inventario_promedio */
                        inventario_promedio = (inventario_ini + inventario_fin) / 2;
                        costoInventario = costoInventario + inventario_promedio;
                        /* si el inventario final es menor al punto de Reorden y no hay una orden puesta, pide una orden y muestra */
                        if(inventario_fin <= r && dia_orden == 0){
                            /* pide el tiempo de espera de la proxima orden */
                            tiempo_espera = Funciones.fcompare(aleatorios[ale], matriz_acum_entrega);
                            ale++;
                            /* la cantidad de ordenes*/
                            numero_orden++;
                            /* dia en el que se pidio la orden */
                            dia_orden = i;

                            lista_clientes = func.fespera_clientes(lista_clientes);

                            //System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|%d\t|%.2f\t|%d\t|%.2f\t|%d\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,numero_orden,aleatorio_demanda,tiempo_espera,aleatorio_demanda,Funciones.fcompare(aleatorio_demanda,matriz_acum_espera));

                        }else{
                           // System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|\t|\t|\t| %.2f\t| %d\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,aleatorio_demanda,Funciones.fcompare(aleatorio_demanda,matriz_acum_espera));
                        }
                    }else{
                        /* inventario_promedio */
                        inventario_promedio = (inventario_ini + inventario_fin) / 2;
                        costoInventario = costoInventario + inventario_promedio;
                        /* si el inventario final es menor al punto de Reorden y no hay una orden puesta, pide una orden y muestra */
                        if(inventario_fin <= r && dia_orden == 0){
                            /* pide el tiempo de espera de la proxima orden */
                            tiempo_espera = Funciones.fcompare(aleatorios[ale], matriz_acum_entrega);
                            ale++;
                            /* la cantidad de ordenes*/
                            numero_orden++;
                            /* dia en el que se pidio la orden */
                            dia_orden = i;

                            lista_clientes = func.fespera_clientes(lista_clientes);

                           // System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|%d\t|%.2f\t|%d\t|\t|\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,numero_orden,aleatorio_demanda,tiempo_espera);

                        }else{
                            //System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|\t|\t|\t|\t|\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante);
                        }
                    }

                    /* inventario inicial del proximo dia */
                    inventario_ini = inventario_fin;
                }   
            
            
            
            
         
        fila.add("X");
        fila.add("Y");
        fila.add("Z");
   
        /* Agrego la fila al vector que contiene todas las filas */
        //aqui se añade todas las filas
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila); filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila); filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);filas.add(fila);
        /* 
            Creo una instancia de JTable y le paso como parametro los dos Vectores:
                -filas
                -columnas   
         */
        JTable tbl = new JTable(filas,columnas);
        /* Creo una instancia de JScrollPane y le paso como parametro la tabla */
        JScrollPane panel =new JScrollPane(tbl);
        
        /* Se coloca un tamaño a cada columna*/        
                tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
                tbl.getColumnModel().getColumn(1).setPreferredWidth(50);
                tbl.getColumnModel().getColumn(2).setPreferredWidth(120);
                tbl.getColumnModel().getColumn(3).setPreferredWidth(60);
                tbl.getColumnModel().getColumn(4).setPreferredWidth(50);
                tbl.getColumnModel().getColumn(5).setPreferredWidth(60);
                tbl.getColumnModel().getColumn(6).setPreferredWidth(50);
                tbl.getColumnModel().getColumn(7).setPreferredWidth(60);
                tbl.getColumnModel().getColumn(8).setPreferredWidth(160);
                tbl.getColumnModel().getColumn(9).setPreferredWidth(120);
                tbl.getColumnModel().getColumn(10).setPreferredWidth(160);
                tbl.getColumnModel().getColumn(11).setPreferredWidth(120);
        
                
                /* Para centrar las celdas*/        
                DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
                modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
                for (int i=0; i<12; i++){
                    tbl.getColumnModel().getColumn(i).setCellRenderer(modelocentrar); 
                    
                }
                
        /* Por ultimo agrego ese objeto de JScrollPane al contenedor de la ventana */
        this.getContentPane().add(panel);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(tablasimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablasimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablasimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablasimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new tablasimulacion().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
