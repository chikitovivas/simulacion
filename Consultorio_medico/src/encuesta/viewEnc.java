/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta;

import Login.Ven_login;
import encuesta.conection.MYJSON;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author carlo
 */
public class viewEnc extends javax.swing.JPanel {

    /**
     * Creates new form viewEnc
     */
    
    String[] tipos= null;
    comboItem[] citas= null;
    String ciAct=null;
    String tipoAct=null;
    comboItem[] preg=null;
    comboItem[] resp=null;
    DefaultTableModel modelX;
    MYJSON jsonchan= new MYJSON();
    String ciMedic= null;
    
    public viewEnc(int ci) {
        ciMedic=Integer.toString(ci);
        initComponents();
        
      // String medico= Ven_login.url;
               //Carga los tipos
        modelX = (DefaultTableModel) jTable1.getModel();
        initDataType();
        addElementstoComboboxtoStart(jComboBox1,tipos);
        startBox3();
        
    }

    void startBox3() {
        comboItem[] selects= new comboItem[5];
        String[][] a= {{"1","Muy Bueno"},{"2","Bueno"},{"3","Regular"},{"4","Malo"},{"5","Muy Malo"}};
        for (int i=0; i< selects.length; i++) {
            selects[i]= new comboItem(a[i],a[i][1]);
        }
        addElementstoComboboxtoStart(jComboBox3,selects);
    }
    
    void initDataType() {
          String[] auxS= null;        //Aqui finjo que creo el arreglo de tipos con datos de la base de datos :c
          /*auxS= new String[] {"hueso","cabeza","pierna","coxi","prostata"};*/
          
        JSONArray aux= 
          jsonchan.JSON_view_general( "tipos",ciMedic );  //Mando medico
          auxS= new String[aux.length()]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            auxS[xi]= aux.getJSONObject(xi).get("nombre").toString();
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
          
          tipos=auxS;
    }
    
    void addElementstoComboboxtoStart(javax.swing.JComboBox combobox, Object[] arreglo) {
        for (Object dato : arreglo) {
            combobox.addItem(dato);
        }
    }
    
    void buscarCitasBD (String ciPaciente) {
        //Codigo a implementar que me devuelva esas citas de los pacientes desdde la BD
        comboItem[] a=null;
        /*if (ci.equals("24.533.420")) {
        a= new String [] {"martes, 15, 2015","jueves, 26, 2015","sabado, 15, nunca"};}
        else {a= new String [] {"qeq, 62, 2015","asdas, 43, 2015","asdas, 32, nunca"};}
        if (ci.equals("1")) {
        a= new String [] {"miercoles, 1, 2015","nunca, 6, 2015","sabado, 23, quiza"};}
        if (ci.equals("2")) {
        a= new String [] {"jueves, 6, 2015","lunes, 3, 2015","domingo, 13, nunca"};}
        if (ci.equals("3")) {
        a= new String [] {};}*/
        
        JSONArray aux= 
          jsonchan.JSON_view_general( "consultas",( ciPaciente+"/"+ciMedic) );  //Mando medico
          a= new comboItem[aux.length()]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            a[xi]= new comboItem (new String [] {aux.getJSONObject(xi).get("consulta").toString(),
                                                 aux.getJSONObject(xi).get("fecha").toString()},
                                  aux.getJSONObject(xi).get("fecha").toString()               
                                 );
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
        
        citas= a;
    }
    
    //recibe la cita seleccionada de una persona
    void buscarPreguntasBD() {
        //Buscar las preguntas de una persona en una cita particular, estas preguntas ya tienen una respuesta claro esta...
        
        comboItem[] a=null;
        String[] b=null;
        
        /*a=  new String[] {"Q1","Q2","Q3","Q4","Q5","Q6","Q7"};
        b= new String[] {"1","2","1","3","5","4","4"};*/
        
        //Buscar las preguntas
        
        
        
        //Busca las preguntas si ya estan en la BD sino asigna 0 a todo eso
        JSONArray aux= 
          jsonchan.JSON_view_general( "respuestas",
                                      ((comboItem)jComboBox2.getSelectedItem()).elements[0] 
                                    );  //Mando cita
          b= new String[aux.length()]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            b[xi]= aux.getJSONObject(xi).get("respuesta").toString();
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
        
        aux= 
          jsonchan.JSON_view_general( "preguntas",
                                      ( ciMedic+"/"+tipoAct) 
                                    );  //Mando tipo y el medico para que me devuelva las preguntas
          a= new comboItem[aux.length()]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            a[xi]= new comboItem(new String[] {aux.getJSONObject(xi).get("idPregunta").toString()
                                              ,aux.getJSONObject(xi).get("pregunta").toString()} 
                                 ,aux.getJSONObject(xi).get("pregunta").toString()
                       );
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
          
        //Aqui es donde asigna 0 porque el arreglo b sera menor que la cantidad de preguntas
        if (b.length<a.length) { 
            b= new String[a.length];
            for (int xii=0; xii<a.length; xii++) {
                b[xii]="0";
            }
        }  
          
        comboItem[] auxt=new comboItem[b.length];
        String yx;
        for (int gg=0; gg<b.length; gg++) {
            
            switch (b[gg].toString()) {
            case "1":  yx = "Muy Bueno";
                     break;
            case "2":  yx = "Bueno";
                     break;
            case "3":  yx = "Regular";
                     break;
            case "4":  yx = "Malo";
                     break;
            case "5":  yx = "Muy Malo";
                     break;
            default: yx = "No Asignado";
                     break;
            }
            
        auxt[gg]= new comboItem((new String[] {b[gg],yx}), yx);
        }
        
        preg=a;
        resp=auxt;
    }
    
    void addQtoTable(){
        modelX.setRowCount(0);
        for (int t=0; t<preg.length; t++) {
            modelX.insertRow(modelX.getRowCount(), new Object[] {preg[t],resp[t]});
        }
    }
    
    String[] getNumbersinTable(int xx) {
        comboItem[] i=new comboItem[jTable1.getRowCount()];
        String[] ii=new String[jTable1.getRowCount()];
        
        for (int t=0; t<jTable1.getRowCount(); t++) {
            i[t]=(comboItem) modelX.getValueAt(t, xx);   
            ii[t]=i[t].elements[0];            //System.out.print(ii[t]);
        }
        return ii;
    }
    
    void sendDataEditedBD() {
        String[] respuestas;
        respuestas=getNumbersinTable(1);                      //Los numeros a guardar en la base de datos correspondientes a las respuestas del tipo, persona y cita
        String[] preguntas;
        preguntas=getNumbersinTable(0);
        
        String consultaAct;
        consultaAct= ((comboItem)jComboBox2.getSelectedItem() ).elements[0];     //La cita en donde se guardara       
        
        String[] a1={"idCita","idPregunta","resp"};
        String[][] auxA= new String[preguntas.length][]; //Creando el JSONArray
        
            //Agregando los datos al JSONArray
            for (int ti=0; ti<preguntas.length; ti++) {  
                auxA[ti]= new String[] {consultaAct,preguntas[ti],respuestas[ti]};
            
            }
            
            JSONArray auxJ=null;
            
            for ( int ixx=0; ixx<auxA.length; ixx++) {
                  JSONObject jsonchin= new JSONObject();
                    
                    for ( int ix=0; ix<3; ix++) {
                        try {
                      jsonchin.put(a1[ix],auxA[ixx][ix]);
                        } catch (JSONException ex) {
                            Logger.getLogger(viewEnc.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }    
                  auxJ.put(jsonchin);
            }
           
            try {
                jsonchan.JSON_agregarArray(auxJ,"respuesta/pregunta");
            } catch (IOException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //manda los datos de la tabla a la base de datos segun lo que sea que sea
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox3.setToolTipText("");
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Respuesta:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pregunta", "Respuesta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel3.setText("Buscar Tipo:");

        jComboBox1.setToolTipText("");

        jTextField1.setText("24.533.420");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox2.setToolTipText("");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("CI del Paciente:");

        jLabel5.setText("Cita del Paciente:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Encuestas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(47, 47, 47))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ( jComboBox2.getSelectedIndex()>(-1) ) {
        sendDataEditedBD();
        } else {System.out.println("selecciona maldito");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jComboBox2.removeAllItems();
        tipoAct=jComboBox1.getSelectedItem().toString();
        ciAct=jTextField1.getText();
        buscarCitasBD(ciAct);
        addElementstoComboboxtoStart(jComboBox2,citas);
        
        //Eliminar toda verga si llegan a darle a este boton despues
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
      if ( jComboBox2.getSelectedIndex()<0 ) {
      } else {
             buscarPreguntasBD();    //Busca las preguntas
             addQtoTable();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i= jTable1.getSelectedRow();
        jTextArea1.setText(modelX.getValueAt(i,0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        int g=jTable1.getSelectedRow();  
        if ( g<(0) ) {
        } else {
             jTable1.setValueAt(jComboBox3.getSelectedItem(), g, 1);
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
