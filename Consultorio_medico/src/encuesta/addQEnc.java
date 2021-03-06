/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta;

import encuesta.conection.MYJSON;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author carlo
 */
public class addQEnc extends javax.swing.JPanel {

    /**
     * Creates new form addQEnc
     */
    
    String[] tipos=null;
    String[] questionsT=null;
    MYJSON jsonchan= new MYJSON();
    String ciMedic=null;
    
    public addQEnc(int ci) {
        ciMedic= Integer.toString(ci);
        initComponents();
        
        //Carga los tipos
        initDataType();
        addElementstoComboboxtoStart(jComboBox1,tipos);
    }

      void changeElementsinJTextArea (String b) {
         jTextArea1.setText(b);
      }
    
          //Agrega los elementos al combobox para poderlos visualizar
      void addElementstoComboboxtoStart(javax.swing.JComboBox combobox, String[] arreglo) {
        for (String dato : arreglo) {
            combobox.addItem(dato);
        }
      }
    
    //Trae los tipos de encuestas de la base de datos y los asigna a la variable global que los usara en el programa
    //ertipo es el tipo a buscar
     void bringQuestions(String ertipo) {
         //Busca por tipo toda las preguntas
         String[] auxQuestions=null;
         
         //Antes de crear el tamaño del auxiliar debo de preguntar de que tamaño sera y sumarle 1 para la parte de agregar nuevas preguntas
         /*if (ertipo.equals("hueso")) {
          auxQuestions= new String [] {"¿Quejeso?","¿Como se come?","¿y me van a pagar por eso?","¿Eso esparas, nurd?","¿GG?",""};   }    
         else { auxQuestions= new String [] {"¿Q?","¿C?","¿y m?","¿Eso espara?","¿GG?",""};}
           
         if (ertipo.equals("coxi")) {
         auxQuestions= new String [] {"¿Que?","¿Coe?","¿y mr eso?","¿Eso nurd?","¿GG?",""};   }    
         auxQuestions[auxQuestions.length-1]="Agregar nueva pregunta a el tipo actual";
         */ 
         
         //Aqui finjo que traigo las preguntas de un tipo y las asigno a la variable global que las usara
         JSONArray aux= 
          jsonchan.JSON_view_general( "preguntas/",( ciMedic+"/"+jComboBox1.getSelectedItem().toString()) );  //Mando medico
          auxQuestions= new String[aux.length()+1]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            auxQuestions[xi]= aux.getJSONObject(xi).get("pregunta").toString();
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
         
         auxQuestions[auxQuestions.length-1]="Agregar nueva pregunta a el tipo actual"; 
         questionsT=auxQuestions;
    }
    
     //Trae los tipos de encuestas segun el medico desde la base de datos
    void initDataType() {
          String[] auxS;
         //auxS= new String[] {"hueso","cabeza","pierna","coxi","prostata"};        //Aqui finjo que creo el arreglo de tipos con datos de la base de datos :c
          
        JSONArray aux= 
          jsonchan.JSON_view_general( "tipos/",ciMedic );  //Mando medico
          auxS= new String[aux.length()]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            auxS[xi]= aux.getJSONObject(xi).get("nombre").toString();
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
          
      tipos=auxS;  
    }
    
    
    void editData(String a, String b, int c) {
          //Agregar funcion que mande los datos a editar a la base de datos
          //questionsT[c]=b; 
        
        String[] a1={"tipo","ciMedico","pNueva","pVieja"};
        String[] b1=new String[] {jComboBox1.getSelectedItem().toString(), ciMedic, b, a};
        
            try {
                jsonchan.JSON_agregar(a1, b1, b1.length, "editar/pregunta");
            } catch (IOException | JSONException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void addData(String b, int c) {
          //Agregar codigo que agregue nuevas preguntas a la base de dato
         /* int xa=0;
                String [] aux = new String[questionsT.length+1];
                 for(int xu=0; xu<questionsT.length+1; xu++) {
                      if (xu!=questionsT.length-1) {
                          aux[xu]=questionsT[xa];
                       xa++;  
                         }  else { aux[xu]=b;  }
                  }
                questionsT=aux; */
        
        String[] a1={"tipo","ciMedico","pNueva"};
        String[] b1=new String[] {jComboBox1.getSelectedItem().toString(), ciMedic, b};
        
            try {
                jsonchan.JSON_agregar(a1, b1, b1.length, "agregar/pregunta");
            } catch (IOException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    void EraseData (String actT, int actP) {
          /*int xa=0;
                String [] aux = new String[questionsT.length-1];
                 for(int xu=0; xu<questionsT.length; xu++) {
                      if (xu!=actP) {
                          aux[xa]=questionsT[xu];
                       xa++;
                         }
                  }
            questionsT=aux;*/
        
          //Agregar codigo que mande los datos a borrar de la tabla de preguntas
        String[] a1={"tipo","ciMedico","pregunta"};
        String[] b1=new String[] {jComboBox1.getSelectedItem().toString(), ciMedic, actT};
        
            try {
                jsonchan.JSON_agregar(a1, b1, b1.length, "borrar/pregunta");
            } catch (IOException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        jLabel3.setText("Buscar Tipo:");

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Preguntas de las Encuentas");

        jLabel2.setText("Pregunta:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Buscar Pregunta:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Borrar Pregunta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addComponent(jComboBox1, 0, 212, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        bringQuestions(jComboBox1.getSelectedItem().toString());
        jComboBox2.removeAllItems();
        addElementstoComboboxtoStart(jComboBox2,questionsT);
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Object selected = jComboBox2.getSelectedItem();
          
          if (selected!=null) {
            changeElementsinJTextArea(selected.toString());
          }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int actPos= jComboBox2.getSelectedIndex();
        String actText= jComboBox2.getSelectedItem().toString();
        String newText= jTextArea1.getText();
        
        System.out.println(actPos);  //debo borrar esta linea
        if (actPos< questionsT.length-1) {
            editData (actText, newText,actPos); 
        } else { addData (newText,actPos) ;}
        
        jComboBox2.removeAllItems();
        bringQuestions( jComboBox1.getSelectedItem().toString() );
        addElementstoComboboxtoStart(jComboBox2,questionsT);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int actPos= jComboBox2.getSelectedIndex();
        if (actPos== questionsT.length-1) {
        }  else {
            
               String actText= jComboBox2.getSelectedItem().toString();
               EraseData (actText, actPos);
               jComboBox2.removeAllItems();
               bringQuestions( jComboBox1.getSelectedItem().toString() );
               addElementstoComboboxtoStart(jComboBox2,questionsT);
               
           }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
