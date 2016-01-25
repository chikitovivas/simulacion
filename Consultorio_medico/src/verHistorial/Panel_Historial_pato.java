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
public class Panel_Historial_pato extends javax.swing.JPanel {
   Object[][] arreglo_datos;
    String sday;
    int day;
    int moth; 
    int year;
    Date fechahoraG;
    JSON json;
    JSONArray arreglopaciente=null, arreglocita=null;
       
    public Panel_Historial_pato(){
         initComponents();
         this.jTcipaciente.setEditable(false);
         this.jTnombrepaciente.setEditable(false);
         this.jTapellidopaciente.setEditable(false);
         this.jFfnacpaciente.setEditable(false);
         this.jTtelefonopaciente.setEditable(false);
         this.jTsangrepaciente.setEditable(false);
         this.jTemailpaciente.setEditable(false);
         this.jTAdireccionpaciente.setEditable(false);
         this.jTidcita.setEditable(false);
         this.jFfcita.setEditable(false);
         this.jTmedico.setEditable(false);
         this.jTAmotivo.setEditable(false);
         this.jTAdescripcion.setEditable(false);
         this.jTAtratamiento.setEditable(false);
    }
    


public Panel_Historial_pato(String cedula, int idcita) throws JSONException {
    String[]titulo_pacientes = {"ciPaciente","nombrePaciente","apellidoPaciente","tlfpaciente","fecha_nac","tipoSangre","direPaciente"};
    String[]titulo_cita = {"id","fcita","medico","porque","diagnostico","tratamiento"}; //arreglar este orden
    json= new JSON();
   
    arreglopaciente= json.JSON_view_general(cedula,"consulta/");
    arreglopaciente = json.ordenar_json(arreglopaciente, titulo_pacientes);
    arreglocita = json.JSON_view_general(cedula,"cita/"); //no es cedula, es idcita
    arreglocita = json.ordenar_json(arreglocita, titulo_cita);
    this.jBback.setVisible(false);
    
    /*hacer la llamada del paciente con los datos*/
    
        this.jTcipaciente.setText(arreglopaciente.get(0).toString());
        
         this.jTcipaciente.setText(arreglopaciente.get(0).toString());
         this.jTnombrepaciente.setText(arreglopaciente.get(1).toString());
         this.jTapellidopaciente.setText(arreglopaciente.get(2).toString());
         this.jFfnacpaciente.setText(arreglopaciente.get(3).toString());
         this.jTtelefonopaciente.setText(arreglopaciente.get(4).toString());
         this.jTsangrepaciente.setText(arreglopaciente.get(5).toString());
         this.jTemailpaciente.setText(arreglopaciente.get(6).toString());
         this.jTAdireccionpaciente.setText(arreglopaciente.get(0).toString());
         
         this.jTidcita.setText(arreglocita.get(0).toString());
         this.jFfcita.setText(arreglocita.get(1).toString());
         this.jTmedico.setText(arreglocita.get(2).toString());
         this.jTAmotivo.setText(arreglocita.get(3).toString());
         this.jTAdescripcion.setText(arreglocita.get(4).toString());
         this.jTAtratamiento.setText(arreglocita.get(5).toString());
 
         

    
//    for(int k=0;k<arreglopaciente.length();k++){ // Aqui agarras todos los porque, diagnostico y tratamiento de cada consulta que haya 
//                                         // ido el paciente de la cedula
//        arreglopaciente.getJSONObject(k).get("medico");
//        arreglopaciente.getJSONObject(k).get("porque");
//        arreglopaciente.getJSONObject(k).get("diagnostico");
//        arreglopaciente.getJSONObject(k).get("tratamiento");
//    }
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        List fila = new ArrayList();
         for(int k=0;k<arreglopaciente.length();k++){
            fila.add(arreglopaciente.getJSONObject(k).get("id")); 
            fila.add(arreglopaciente.getJSONObject(k).get("fecha"));
            fila.add(arreglopaciente.getJSONObject(k).get("porque"));
            modelo.addRow(fila.toArray());
            fila.clear();
        }
        
        this.jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
         
        initComponents();

        
        
        int i=0;
        if (i==0){ //si se hace click en una fila del jtable
        //hacer la peticion de la cita nuevamente y editar los campos de motivo,diagnostico,etcetc
        
            arreglocita = json.JSON_view_general(cedula,"cita/"); //no es cedula, es idcita
            arreglocita = json.ordenar_json(arreglocita, titulo_cita);

             this.jTidcita.setText(arreglocita.get(0).toString());
             this.jFfcita.setText(arreglocita.get(1).toString());
             this.jTmedico.setText(arreglocita.get(2).toString());
             this.jTAmotivo.setText(arreglocita.get(3).toString());
             this.jTAdescripcion.setText(arreglocita.get(4).toString());
             this.jTAtratamiento.setText(arreglocita.get(5).toString());
        
        }
                
                
                
        
        this.jTable = new JTable(modelo){
        public boolean isCellEditable(int row, int columnn) {
            return false;
        }};//return false: Desabilitar edición de celdas.
         this.jTcipaciente.setEditable(false);
         this.jTnombrepaciente.setEditable(false);
         this.jTapellidopaciente.setEditable(false);
         this.jFfnacpaciente.setEditable(false);
         this.jTtelefonopaciente.setEditable(false);
         this.jTsangrepaciente.setEditable(false);
         this.jTemailpaciente.setEditable(false);
         this.jTAdireccionpaciente.setEditable(false);
         this.jTidcita.setEditable(false);
         this.jFfcita.setEditable(false);
         this.jTmedico.setEditable(false);
         this.jTAmotivo.setEditable(false);
         this.jTAdescripcion.setEditable(false);
         this.jTAtratamiento.setEditable(false);
    }

            /******************************/
            /* Constructor solo con cedula*/
            /******************************/

public Panel_Historial_pato(String cedula) throws JSONException {
    String[]titulo_pacientes = {"ciPaciente","nombrePaciente","apellidoPaciente","tlfpaciente","fecha_nac","tipoSangre","direPaciente"};
    
    json= new JSON();
   
    arreglopaciente= json.JSON_view_general(cedula,"consulta/");
    arreglopaciente = json.ordenar_json(arreglopaciente, titulo_pacientes);
    
    this.jBback.setVisible(false);
    
    /*hacer la llamada del paciente con los datos*/
    
         this.jTcipaciente.setText(arreglopaciente.get(0).toString());
        
         this.jTcipaciente.setText(arreglopaciente.get(0).toString());
         this.jTnombrepaciente.setText(arreglopaciente.get(1).toString());
         this.jTapellidopaciente.setText(arreglopaciente.get(2).toString());
         this.jFfnacpaciente.setText(arreglopaciente.get(3).toString());
         this.jTtelefonopaciente.setText(arreglopaciente.get(4).toString());
         this.jTsangrepaciente.setText(arreglopaciente.get(5).toString());
         this.jTemailpaciente.setText(arreglopaciente.get(6).toString());
         this.jTAdireccionpaciente.setText(arreglopaciente.get(0).toString());
         
         
        
        DefaultTableModel modelo = new DefaultTableModel();
        List fila = new ArrayList();
         for(int k=0;k<arreglopaciente.length();k++){
            fila.add(arreglopaciente.getJSONObject(k).get("id")); 
            fila.add(arreglopaciente.getJSONObject(k).get("fecha"));
            fila.add(arreglopaciente.getJSONObject(k).get("porque"));
            modelo.addRow(fila.toArray());
            fila.clear();
        }
        
        this.jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
         
        initComponents();

        
        
        int i=0;
        if (i==0){ //si se hace click en una fila del jtable
        //hacer la peticion de la cita nuevamente y editar los campos de motivo,diagnostico,etcetc
        
//            arreglocita = json.JSON_view_general(cedula,"cita/"); //no es cedula, es idcita
//            arreglocita = json.ordenar_json(arreglocita, titulo_cita);
//
//             this.jTidcita.setText(arreglocita.get(0).toString());
//             this.jFfcita.setText(arreglocita.get(1).toString());
//             this.jTmedico.setText(arreglocita.get(2).toString());
//             this.jTAmotivo.setText(arreglocita.get(3).toString());
//             this.jTAdescripcion.setText(arreglocita.get(4).toString());
//             this.jTAtratamiento.setText(arreglocita.get(5).toString());
        
        }
                
                
                
        
        this.jTable = new JTable(modelo){
        public boolean isCellEditable(int row, int columnn) {
            return false;
        }};//return false: Desabilitar edición de celdas.
         this.jTcipaciente.setEditable(false);
         this.jTnombrepaciente.setEditable(false);
         this.jTapellidopaciente.setEditable(false);
         this.jFfnacpaciente.setEditable(false);
         this.jTtelefonopaciente.setEditable(false);
         this.jTsangrepaciente.setEditable(false);
         this.jTemailpaciente.setEditable(false);
         this.jTAdireccionpaciente.setEditable(false);
         this.jTidcita.setEditable(false);
         this.jFfcita.setEditable(false);
         this.jTmedico.setEditable(false);
         this.jTAmotivo.setEditable(false);
         this.jTAdescripcion.setEditable(false);
         this.jTAtratamiento.setEditable(false);
    }







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLtitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JLtitulo1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTidcita = new javax.swing.JTextField();
        jTmedico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAdescripcion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAmotivo = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAtratamiento = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jFfcita = new javax.swing.JFormattedTextField();
        jFhoracita = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jBback = new javax.swing.JButton();
        jTsangrepaciente = new javax.swing.JTextField();
        JLnombre1 = new javax.swing.JLabel();
        jFfnacpaciente = new javax.swing.JFormattedTextField();
        jTemailpaciente = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTAdireccionpaciente = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTcipaciente = new javax.swing.JTextField();
        jTtelefonopaciente = new javax.swing.JTextField();
        JLtelefono1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTnombrepaciente = new javax.swing.JTextField();
        jTapellidopaciente = new javax.swing.JTextField();
        JLci1 = new javax.swing.JLabel();
        JLemail1 = new javax.swing.JLabel();

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Datos Paciente");

        JLtitulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo1.setText("Historial");

        jLabel2.setText("ID cita: ");

        jLabel3.setText("Fecha: ");

        jLabel5.setText("Médico:");

        jTidcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidcitaActionPerformed(evt);
            }
        });

        jLabel4.setText("Motivo:");

        jLabel6.setText("Descripción:");

        jLabel7.setText("Tratamiento:");

        jTAdescripcion.setColumns(20);
        jTAdescripcion.setRows(5);
        jScrollPane2.setViewportView(jTAdescripcion);

        jTAmotivo.setColumns(20);
        jTAmotivo.setRows(5);
        jScrollPane3.setViewportView(jTAmotivo);

        jTAtratamiento.setColumns(20);
        jTAtratamiento.setRows(5);
        jScrollPane4.setViewportView(jTAtratamiento);

        jLabel9.setText("Hora:");

        jFfcita.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFfcita.setText("2016/01/24");
        jFfcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFfcitaActionPerformed(evt);
            }
        });

        jFhoracita.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFhoracita.setText("08:15 PM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFfcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFhoracita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTmedico, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTidcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jFfcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFhoracita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTmedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel7)
                        .addGap(24, 24, 24))))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cita", "Fecha", "Motivo"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBback.setText("Atrás");
        jBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbackActionPerformed(evt);
            }
        });

        jTsangrepaciente.setText("jTextField1");

        JLnombre1.setText("Nombre:");

        jFfnacpaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFfnacpaciente.setText("1970/01/24");
        jFfnacpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFfnacpacienteActionPerformed(evt);
            }
        });

        jTemailpaciente.setText("jTextField3");

        jTAdireccionpaciente.setColumns(20);
        jTAdireccionpaciente.setRows(5);
        jScrollPane5.setViewportView(jTAdireccionpaciente);

        jLabel13.setText("Dirección:");

        jLabel14.setText("Tipo Sangre: ");

        jTcipaciente.setText("jTextField1");

        jTtelefonopaciente.setText("jTextField4");

        JLtelefono1.setText("Télefono:");

        jLabel15.setText("Apellido: ");

        jLabel12.setText("F. Nac:");

        jTnombrepaciente.setText("jTextField2");

        jTapellidopaciente.setText("jTextField2");
        jTapellidopaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTapellidopacienteActionPerformed(evt);
            }
        });

        JLci1.setText("C.I:");

        JLemail1.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLci1)
                                .addGap(18, 18, 18)
                                .addComponent(jTcipaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFfnacpaciente)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLnombre1)
                            .addComponent(JLtelefono1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTtelefonopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTapellidopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTsangrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLemail1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTemailpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBback)
                        .addGap(213, 213, 213)
                        .addComponent(JLtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(JLtitulo1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtitulo)
                    .addComponent(jBback))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre1)
                    .addComponent(jTnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLci1)
                    .addComponent(jTcipaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTapellidopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jFfnacpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLtelefono1)
                            .addComponent(jTtelefonopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jTsangrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLemail1)
                            .addComponent(jTemailpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTidcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidcitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidcitaActionPerformed

    private void jBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBbackActionPerformed

    private void jFfnacpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFfnacpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFfnacpacienteActionPerformed

    private void jTapellidopacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTapellidopacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTapellidopacienteActionPerformed

    private void jFfcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFfcitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFfcitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLci1;
    private javax.swing.JLabel JLemail1;
    private javax.swing.JLabel JLnombre1;
    private javax.swing.JLabel JLtelefono1;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel JLtitulo1;
    private javax.swing.JButton jBback;
    private javax.swing.JFormattedTextField jFfcita;
    private javax.swing.JFormattedTextField jFfnacpaciente;
    private javax.swing.JFormattedTextField jFhoracita;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTAdescripcion;
    private javax.swing.JTextArea jTAdireccionpaciente;
    private javax.swing.JTextArea jTAmotivo;
    private javax.swing.JTextArea jTAtratamiento;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTapellidopaciente;
    private javax.swing.JTextField jTcipaciente;
    private javax.swing.JTextField jTemailpaciente;
    private javax.swing.JTextField jTidcita;
    private javax.swing.JTextField jTmedico;
    private javax.swing.JTextField jTnombrepaciente;
    private javax.swing.JTextField jTsangrepaciente;
    private javax.swing.JTextField jTtelefonopaciente;
    // End of variables declaration//GEN-END:variables
}
