/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verHistorial;

import JSON.JSON;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Rafael
 */
public class Panel_Historial_patosimple extends javax.swing.JPanel {
   Object[][] arreglo_datos;
    String sday;
    int day;
    int moth; 
    int year;
    Date fechahoraG;
    JSON json;
    JSONArray arreglo=null;
    /**
     * Creates new form Ven_VerHistorial
     * @param arreglo_datos
     */
    
    
    
    
    public Panel_Historial_patosimple(){
             initComponents();
              jTci.setText("");
         jTnombre.setText("");
         jTemail.setText("");
         jTtelefono.setText("");
    }
    
//    
//public Panel_Historial_pato(Object[][] arreglo_datos, int i,String sday, int day, int moth, int year) {
//        
//     this.arreglo_datos=arreglo_datos;  
//     this.sday=sday;
//     this.day=day;
//     this.moth=moth; 
//     this.year=year;
//    
//    
//        initComponents();
//        String y=Integer.toString(i); //En otra versiones hay que poner horas minutos y segundos
//        
//        for(int j=0;j<arreglo_datos.length;j++){
//            if(  Integer.valueOf(i).equals(Integer.valueOf((((Date)arreglo_datos[j][0]).getHours())))  ){
//
//                 jTci.setText(arreglo_datos[j][1].toString());
//                 jTnombre.setText(arreglo_datos[j][2].toString()+" "+ arreglo_datos[j][3].toString());
//                 jTemail.setText(arreglo_datos[j][5].toString());
//                 jTtelefono.setText(arreglo_datos[j][4].toString());
//
//            }
//        }
//         jTci.setEditable(false);
//         jTnombre.setEditable(false);
//         jTemail.setEditable(false);
//         jTtelefono.setEditable(false);
//    }

public Panel_Historial_patosimple(String cedula) throws JSONException {
        
    json= new JSON();
   
     //arreglo=   json.JSON_view("cedula","consulta/");
     
    
    for(int k=0;k<arreglo.length();k++){ // Aqui agarras todos los porque, diagnostico y tratamiento de cada consulta que haya 
                                         // ido el paciente de la cedula
        arreglo.getJSONObject(k).get("medico");
        arreglo.getJSONObject(k).get("porque");
        arreglo.getJSONObject(k).get("diagnostico");
        arreglo.getJSONObject(k).get("tratamiento");
    }
    
     this.arreglo_datos=arreglo_datos;  
     this.sday=sday;
     this.day=day;
     this.moth=moth; 
     this.year=year;
     
        initComponents();
       // String y=Integer.toString(i); //En otra versiones hay que poner horas minutos y segundos
       
        DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Fecha");
            modelo.addColumn("Descripción");
        List fila = new ArrayList();
    
        modelo.addTableModelListener(jTable1);
        
        
//        for(int i=0;i<;i++){
//            fila.add(fecha_historial);
//            fila.add(descripcion_historial);
//            modelo.addRow(fila);
//            fila.clear();
//        }
//        
      
        JTable tabla = new JTable(modelo){
        public boolean isCellEditable(int row, int columnn) {
            return false;
        }};//return false: Desabilitar edición de celdas.
        
        this.jPanel.add(tabla);
        
//        for(int j=0;j<arreglo_datos.length;j++){
//            if(  Integer.valueOf(i).equals(Integer.valueOf((((Date)arreglo_datos[j][0]).getHours())))  ){
//
//                 jTci.setText(arreglo_datos[j][1].toString());
//                 jTnombre.setText(arreglo_datos[j][2].toString()+" "+ arreglo_datos[j][3].toString());
//                 jTemail.setText(arreglo_datos[j][5].toString());
//                 jTtelefono.setText(arreglo_datos[j][4].toString());
//
//            }//fin del if
//        }//fin del for
         jTci.setEditable(false);
         jTnombre.setEditable(false);
         jTemail.setEditable(false);
         jTtelefono.setEditable(false);
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
        JLci = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLtelefono = new javax.swing.JLabel();
        JLemail = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JLtitulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTci = new javax.swing.JTextField();
        jTnombre = new javax.swing.JTextField();
        jTemail = new javax.swing.JTextField();
        jTtelefono = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Datos Paciente");

        JLci.setText("C.I:");

        JLnombre.setText("Nombre:");

        JLtelefono.setText("Télefono:");

        JLemail.setText("Email:");

        JLtitulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo1.setText("Historial");

        jTci.setText("jTextField1");

        jTnombre.setText("jTextField2");

        jTemail.setText("jTextField3");

        jTtelefono.setText("jTextField4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(JLtitulo1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(JLtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLci)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTci, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JLnombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLemail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLtelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLnombre)
                    .addComponent(jTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLtelefono)
                    .addComponent(jTtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLemail))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLci;
    private javax.swing.JLabel JLemail;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLtelefono;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel JLtitulo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTci;
    private javax.swing.JTextField jTemail;
    private javax.swing.JTextField jTnombre;
    private javax.swing.JTextField jTtelefono;
    // End of variables declaration//GEN-END:variables
}