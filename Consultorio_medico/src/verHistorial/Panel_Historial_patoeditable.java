/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verHistorial;

import JSON.JSON;
import JSON.JSONpato;
import static JSON.JSONpato.agregar_pato;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Rafael
 */
public class Panel_Historial_patoeditable extends javax.swing.JPanel {
   Object[][] arreglo_datos;
    String sday;
    int day;
    int moth; 
    int year;
    Date fechahoraG;
    JSON json;
    JSONArray arreglo=null;
    JSONpato jsonpato = new JSONpato();
    /**
     * Creates new form Ven_VerHistorial
     * @param arreglo_datos
     */
    
    
    
    
    public Panel_Historial_patoeditable(){
            initComponents();
            jTcipaciente.setText("");
            jTnombrepaciente.setText("");
            jTemailpaciente.setText("");
            jTtelefonopaciente.setText("");
    }
    

public Panel_Historial_patoeditable(String cedula) throws JSONException, IOException {
    Object[] objeto = new Object[3];
    
    this.jBback.setVisible(false);
    
    JSONArray[] arreglo = new JSONArray[2];
    
    arreglo = jsonpato.solicitar_pato(cedula);
    
    // POSICION 0 TIENE CONSULTAS POSICION 1 TIENE CITAS
        JSONArray consulta=arreglo[0],citas=arreglo[1];        
        Object[] mierda={"","","","","","","","",null,null};
        
        if((consulta==null) && (citas==null))
             arreglo= null;
        
        Object[][] consul=null,cit=null;
        if(consulta!=null){
            mierda[0]=consulta.getJSONObject(0).get("ciPaciente").toString();
            mierda[1]=consulta.getJSONObject(0).get("nombrePaciente").toString();
            mierda[2]=consulta.getJSONObject(0).get("apellidoPaciente").toString();
            mierda[3]=consulta.getJSONObject(0).get("tlfpaciente").toString();
            mierda[4]=consulta.getJSONObject(0).get("fecha_nac").toString();
            mierda[5]=consulta.getJSONObject(0).get("tipoSangre").toString();
            mierda[6]=consulta.getJSONObject(0).get("direPaciente").toString();                    
            mierda[7]=consulta.getJSONObject(0).get("correo").toString();                    
            
            
           consul=new Object[consulta.length()][6];
           for(int i=0;i<consulta.length();i++){               
                    consul[i][0]=consulta.getJSONObject(i).getJSONObject("idCita");
                    consul[i][1]=consulta.getJSONObject(i).getJSONObject("fecha");
                    consul[i][2]=consulta.getJSONObject(i).getJSONObject("hora");
                    consul[i][3]=consulta.getJSONObject(i).getJSONObject("motivo");
                    consul[i][4]=consulta.getJSONObject(i).getJSONObject("diagnostico");
                    consul[i][5]=consulta.getJSONObject(i).getJSONObject("tratamiento");
                    
           }//fin for consulta.length()
            
            
        }//fin if (consulta!=null)
        else{
        if(citas!=null){
            mierda[0]=citas.getJSONObject(0).get("ciPaciente").toString();
            mierda[1]=citas.getJSONObject(0).get("nombrePaciente").toString();
            mierda[2]=citas.getJSONObject(0).get("apellidoPaciente").toString();
            mierda[3]=citas.getJSONObject(0).get("tlfpaciente").toString();
            mierda[4]=citas.getJSONObject(0).get("fecha_nac").toString();
            mierda[5]=citas.getJSONObject(0).get("tipoSangre").toString();
            mierda[6]=citas.getJSONObject(0).get("direPaciente").toString();                  
            mierda[7]=consulta.getJSONObject(0).get("correo").toString();         
            
            cit=new Object[citas.length()][6];
            for(int i=0;i<citas.length();i++){               
                    cit[i][0]=citas.getJSONObject(i).getJSONObject("idCita");
                    cit[i][1]=citas.getJSONObject(i).getJSONObject("fecha");
                    cit[i][2]=citas.getJSONObject(i).getJSONObject("hora");
                    cit[i][3]=citas.getJSONObject(i).getJSONObject("motivo");
                    cit[i][4]=citas.getJSONObject(i).getJSONObject("diagnostico");
                    cit[i][5]=citas.getJSONObject(i).getJSONObject("tratamiento");
                    
            }//fin for citas.length()

        } //finn if (citas!=null)
        }// fin else
        
        
         this.jTcipaciente.setText(mierda[0].toString());
         this.jTnombrepaciente.setText(mierda[1].toString());
         this.jTapellidopaciente.setText(mierda[2].toString());
         this.jTtelefonopaciente.setText(mierda[3].toString());
         this.jFfnacpaciente.setText(mierda[4].toString());
         this.jTsangrepaciente.setText(mierda[5].toString());
         this.jTAdireccionpaciente.setText(mierda[6].toString());
         this.jTemailpaciente.setText(mierda[7].toString());
         
    
    
    initComponents();
 
        

         
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTcipaciente = new javax.swing.JTextField();
        jTnombrepaciente = new javax.swing.JTextField();
        jTemailpaciente = new javax.swing.JTextField();
        jTtelefonopaciente = new javax.swing.JTextField();
        jPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTidcita = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAdiagnostico = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAmotivo = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTAtratamiento = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jFfcita = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFhoracita = new javax.swing.JFormattedTextField();
        JLtitulo1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jBguardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTsangrepaciente = new javax.swing.JTextField();
        jBback = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAdireccionpaciente = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTapellidopaciente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jFfnacpaciente = new javax.swing.JFormattedTextField();

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Datos Paciente");

        JLci.setText("C.I:");

        JLnombre.setText("Nombre:");

        JLtelefono.setText("Télefono:");

        JLemail.setText("Email:");

        jTcipaciente.setText("jTextField1");

        jTnombrepaciente.setText("jTextField2");

        jTemailpaciente.setText("jTextField3");

        jTtelefonopaciente.setText("jTextField4");

        jLabel2.setText("ID cita: ");

        jLabel3.setText("Fecha: ");

        jTidcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTidcitaActionPerformed(evt);
            }
        });

        jLabel4.setText("Motivo:");

        jLabel6.setText("Diagnóstico:");

        jLabel7.setText("Tratamiento:");

        jTAdiagnostico.setColumns(20);
        jTAdiagnostico.setRows(5);
        jScrollPane2.setViewportView(jTAdiagnostico);

        jTAmotivo.setColumns(20);
        jTAmotivo.setRows(5);
        jScrollPane3.setViewportView(jTAmotivo);

        jTAtratamiento.setColumns(20);
        jTAtratamiento.setRows(5);
        jScrollPane4.setViewportView(jTAtratamiento);

        jFfcita.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFfcita.setText("2016/01/24");
        jFfcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFfcitaActionPerformed(evt);
            }
        });

        jLabel12.setText("Hora:");

        jFhoracita.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        jFhoracita.setText("08:15 PM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTidcita, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFfcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFhoracita, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(220, 220, 220))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4)))))
            .addComponent(jSeparator3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTidcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFfcita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jFhoracita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel7)
                        .addGap(24, 24, 24))))
        );

        JLtitulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo1.setText("Historial");

        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(JLtitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jBguardar))
        );

        jLabel8.setText("T. Sangre: ");

        jTsangrepaciente.setText("jTextField1");

        jBback.setText("Atrás");
        jBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbackActionPerformed(evt);
            }
        });

        jLabel9.setText("Dirección:");

        jTAdireccionpaciente.setColumns(20);
        jTAdireccionpaciente.setRows(5);
        jScrollPane1.setViewportView(jTAdireccionpaciente);

        jLabel10.setText("Apellido: ");

        jTapellidopaciente.setText("jTextField2");
        jTapellidopaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTapellidopacienteActionPerformed(evt);
            }
        });

        jLabel11.setText("F. Nac:");

        jFfnacpaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFfnacpaciente.setText("2016/01/24");
        jFfnacpaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFfnacpacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLemail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTemailpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(JLci))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTcipaciente)
                            .addComponent(jFfnacpaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLnombre)
                            .addComponent(JLtelefono))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTtelefonopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTsangrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addComponent(jTapellidopaciente)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBback)
                                .addGap(182, 182, 182)
                                .addComponent(JLtitulo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(JLnombre)
                    .addComponent(jTnombrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLci)
                    .addComponent(jTcipaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTapellidopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jFfnacpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLtelefono)
                            .addComponent(jTtelefonopaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTsangrepaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLemail)
                            .addComponent(jTemailpaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTidcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTidcitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTidcitaActionPerformed

    private void jBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBbackActionPerformed

    private void jTapellidopacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTapellidopacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTapellidopacienteActionPerformed

    private void jFfnacpacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFfnacpacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFfnacpacienteActionPerformed

    private void jFfcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFfcitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFfcitaActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
       String[] datospaciente = new String[13];
       
       
     // condicion de si la consulta la consulta ya existe
     // if (tal)
     
         datospaciente[0] = this.jTcipaciente.getText();
         datospaciente[1] = this.jTnombrepaciente.getText();
         datospaciente[2] = this.jTapellidopaciente.getText();
         datospaciente[3] = this.jTtelefonopaciente.getText();
         datospaciente[4] = this.jFfnacpaciente.getText();
         datospaciente[5] = this.jTsangrepaciente.getText();
         datospaciente[6] = this.jTAdireccionpaciente.getText();
         datospaciente[7] = this.jTemailpaciente.getText();
         datospaciente[8] = this.jTidcita.getText();
         datospaciente[9] = this.jFfcita.getText();
         datospaciente[10] = this.jFhoracita.getText();
         datospaciente[11] = this.jTAmotivo.getText();
         datospaciente[12] = this.jTAdiagnostico.getText();
         datospaciente[13] = this.jTAtratamiento.getText();
        
       try {
           jsonpato.agregar_pato(datospaciente);
           
       } catch (JSONException ex) {
           Logger.getLogger(Panel_Historial_patoeditable.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Panel_Historial_patoeditable.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jBguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLci;
    private javax.swing.JLabel JLemail;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JLabel JLtelefono;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel JLtitulo1;
    private javax.swing.JButton jBback;
    private javax.swing.JButton jBguardar;
    private javax.swing.JFormattedTextField jFfcita;
    private javax.swing.JFormattedTextField jFfnacpaciente;
    private javax.swing.JFormattedTextField jFhoracita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTAdiagnostico;
    private javax.swing.JTextArea jTAdireccionpaciente;
    private javax.swing.JTextArea jTAmotivo;
    private javax.swing.JTextArea jTAtratamiento;
    private javax.swing.JTextField jTapellidopaciente;
    private javax.swing.JTextField jTcipaciente;
    private javax.swing.JTextField jTemailpaciente;
    private javax.swing.JTextField jTidcita;
    private javax.swing.JTextField jTnombrepaciente;
    private javax.swing.JTextField jTsangrepaciente;
    private javax.swing.JTextField jTtelefonopaciente;
    // End of variables declaration//GEN-END:variables
}
