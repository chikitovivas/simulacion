/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta;

import JSON.JSON;
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
public class addType extends javax.swing.JPanel {

    /**
     * Creates new form addType
     */
    
    
    comboItem[] tipos = null;         //Por fila tiene (Nombre Del Tipo, Descrp Del Tipo)
    MYJSON jsonchan= new MYJSON();
    String ciMedic;
    
    public addType(int ci) throws JSONException {
        ciMedic= Integer.toString(ci);
        initComponents();
        
        //Carga los datos
        initData();
        
        //Agrega los elementos al combo box
        addElementstoComboboxtoStart();
    }

      //Agrega los elementos al combobox para poderlos visualizar
      void addElementstoComboboxtoStart() {
          for(int inf=0; inf<tipos.length; inf++) {
           jComboBox1.addItem(tipos[inf]);
          }
          
          String[] asignadoralways= {"nuevo elemento","inserte los datos del nuevo elemento"};
          jComboBox1.addItem(new comboItem(asignadoralways, "nuevo elemento"));
      }
      
      //Cambia las Strings en el JTextField y en el JTextArea segun dos cadenas que se pasen (1ero String del Field y luego el del Area)
      void changeElementsinJText (String a, String b) {
         jTextField1.setText(a);
         jTextArea1.setText(b);
      }
      
      
      //Inicializa los datos de esta clase trayendolos desde la base de datos (en proceso)
      void initData() {
          
          JSONArray aux= 
          jsonchan.JSON_view_general( "tipos",ciMedic );  //Mando medico
          String[][] auxS= new String[aux.length()][2]; 
          
          for (int xi=0; xi<aux.length(); xi++) {
                try {
            auxS[xi][0]= aux.getJSONObject(0).get("nombre").toString();
            auxS[xi][1]= aux.getJSONObject(0).get("descripcion").toString();
                } catch (JSONException ex) {Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
                  }
          }
          //String[] asignador0= {"hueso","para los huesos"};
          //String[] asignador1= {"cabeza","para los cabeza"};
          //String[] asignador2= {"pierna","para los pierna"};
          //String [][] asignador= {asignador0, asignador1, asignador2 };
          
          String [][]asignador=auxS;
          tipos= new comboItem[asignador.length];
          //System.out.println(asignador.length);
          
          for(int xu=0; xu<asignador.length; xu++) {
                tipos[xu]=new comboItem (asignador[xu], asignador[xu][0]);
          }
      }
    
      //Manda a la base de dato los datos del elemento a modificar
      //Recibe el elemente actual posicionado y como se vera modificado     
      //"a" es actual, "b" es con los datos modificados y "c" es la posicion del viejo en el arreglo
      void editData(comboItem a, comboItem b, int c) { 
          //tipos[c]= b;  //Innecesario solo para ver actualmente como deberia de ser
        //  System.out.println(tipos[jComboBox1.getSelectedIndex()].toString());
          //Codigo para mandar cosas por JSON a la base de datos
      
        String[] a1={"ciMedico","nombre","descrp","nviejo"};
        String[] b1=new String[] {ciMedic, b.elements[0], b.elements[1], a.identifier};
        
            try {
                jsonchan.JSON_agregar(a1, b1, b1.length, "editar/tipo");
            } catch (IOException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JSONException ex) {
                Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      
      void addData(comboItem b, int c) { 
         /* int xa=0;
                comboItem [] aux = new comboItem[tipos.length+1];
                 for(int xu=0; xu<tipos.length+1; xu++) {
                      if (xu!=tipos.length) {
                          aux[xa]=tipos[xu];
                       xa++;  
                         }  else { aux[xu]=b;  }
                  }
                tipos=aux;
               // System.out.println(tipos[tipos.length-1]); */

          //Codigo para agregar cosas por JSON a la base de datos
      
          
        String[] a1={"ciMedico","nombre","descrp"};
        String[] b1=new String[] {ciMedic, b.elements[0], b.elements[1]};
        
        try {
            jsonchan.JSON_agregar(a1, b1, b1.length, "agregar/tipo");
        } catch (IOException ex) {
            Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(addType.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      
      
      //Manda a la base de dato los datos del elemento a borrar
      //Recibe el elemente actual posicionado
      //"b" es el item a borrar y "c" es la posicion en el arreglo
      void EraseData(comboItem b, int c) {
          /*int xa=0;
                comboItem [] aux = new comboItem[tipos.length-1];
                 for(int xu=0; xu<tipos.length; xu++) {
                      if (xu!=c) {
                          aux[xa]=tipos[xu];
                       xa++;
                         }
                  }
                tipos=aux;  */   
        //Codigo para borrar cosas por json a la base de datos
        
        String[] a1={"ciMedico","nombre"};
        String[] b1=new String[] {ciMedic, b.identifier};
        
            try {
                jsonchan.JSON_agregar(a1, b1, b1.length, "borrar/tipo");
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Guardar Cambios");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipos de Encuesta");

        jLabel2.setText("Nombre del Tipo:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar Tipo:");

        jLabel4.setText("Descripcion del Tipo:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("Borrar Actual");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(205, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
              javax.swing.JComboBox  comboBox = (javax.swing.JComboBox) evt.getSource();         //Metodo que aun no entiendo el porque se usa
              comboItem selected = (comboItem) comboBox.getSelectedItem();                       //Osea hay cosas mas simples ¿por que hacer esto?
              
              if (selected!=null) {
              changeElementsinJText (selected.toString(), selected.elements[1]);
              }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              comboItem selected = (comboItem) jComboBox1.getSelectedItem();
              //String [] casa =  new String [] {jTextField1.getText(),jTextArea1.getText() };
              comboItem newselected = new comboItem ( new String [] {jTextField1.getText(),jTextArea1.getText() }, jTextField1.getText());
              
              if (jComboBox1.getSelectedIndex()< tipos.length) {
                      editData (selected, newselected,jComboBox1.getSelectedIndex());
              } else { addData (newselected,jComboBox1.getSelectedIndex()) ;}
                     
              jComboBox1.removeAllItems();
              initData();
              addElementstoComboboxtoStart();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              if (jComboBox1.getSelectedIndex()== tipos.length) {
              }  else {
                     comboItem selected = (comboItem) jComboBox1.getSelectedItem();
                     EraseData (selected, jComboBox1.getSelectedIndex());
                     jComboBox1.removeAllItems();
                     initData();
                     addElementstoComboboxtoStart();
                 }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

        //jComboBox1.getSelectedIndex()= devuelve el indice actual -1 osea si estas en la cajita 1 te devolvera 0 



}
