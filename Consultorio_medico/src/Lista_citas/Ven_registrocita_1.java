/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_citas;
import JSON.JSON;
import Registro_cita.Fondo_Formulariopaciente;
import Registro_cita.Ven_registrocita;
import consultorio_medico.Proyecto;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import verHistorial.Ven_VerHistorial;
/**
 *
 * @author Pat
 */



public class Ven_registrocita_1 extends javax.swing.JFrame {
     String[] casita;
     String fecha_mostrar;      String esp="";
     String fecha_pato;         String asp="      ";
     
     String [] horario;
     String [][] casex;
     String [] imprimir;
     
     Object[][] ocus_magnus;
     int dhour;
     int dday;
     int dmouth;
     int dyear;
     String cass;
     
    /**
     * Creates new form Ven_registrocita
     */
     
     
     //Primer Constructor de prueba para llorar :c
        public Ven_registrocita_1() {
            
        dday=15; dmouth=01; dyear=2024; cass="domingo";
        
        fecha_mostrar= "31-12-2015 "+cass;
        horario= new String[] {"08:00","09:33","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
        String[][] casex1;
        casex1 = new String [][] {{"12:00","29.192.559","papa","sales","9202992-0414","@jodete"}, {"11:00","30.123.333","mama","sales","0414","@sasdas"}};
        
        Object[][] ocus_pocus = new Object[casex1.length][];
        
        for(int zi=0; zi<=ocus_pocus.length-1; zi++) {
            ocus_pocus[zi] = new Object[casex1[zi].length];
            for(int zz=1; zz<=casex1[zi].length-1; zz++) {
               ocus_pocus[zi][zz]=casex1[zi][zz];
            }
        }
            ocus_pocus[0][0]= new Date(1220277800L * 1000);
            ocus_pocus[1][0]= new Date(1220278900L * 1000);
            //System.out.printf( String.valueOf( ((Date)ocus_pocus[0][0]).getHours() ) );
            
        ocus_magnus= ocus_pocus;
  
        casex = new String [ocus_pocus.length][];
        for(int zi=0; zi<=ocus_pocus.length-1; zi++) {
           casex[zi]= new String [ocus_pocus[zi].length-1];                     //No cuento la fecha de nacimiento
           if (Integer.valueOf( ((Date)ocus_pocus[zi][0]).getHours() )<=9 ) {
               casex[zi][0]= "0"+String.valueOf(((Date)ocus_pocus[zi][0]).getHours());
           }   else {
               casex[zi][0]= String.valueOf(((Date)ocus_pocus[zi][0]).getHours());
               }
           casex[zi][0]= casex[zi][0]+ ":";
           casex[zi][0]= casex[zi][0]+String.valueOf(((Date)ocus_pocus[zi][0]).getMinutes());
              for(int zxz=1; zxz<=ocus_pocus[zi].length-2; zxz++) {                //   No llego hasta la fecha de nacimiento
                  casex[zi][zxz]=((String)ocus_pocus[zi][zxz]);    
              }
        }
          
        imprimir= new String [horario.length];
        for(int zi=0; zi<=horario.length-1; zi++) {
            for(int zy=0; zy<=casex.length-1; zy++) {
               if (horario[zi].equals(casex[zy][0])) {
                    imprimir[zi]= esp+horario[zi]+asp+casex[zy][2]+" "+casex[zy][3]; 
                    zy=horario.length;
                }   else {  imprimir[zi]=esp+horario[zi];
                    } 
            }  
        }
        
        casita= imprimir;
        initComponents();
    }
    
    
    
    
    //Segundo Constructor y es el que se va a usar "normalmente"                        sigh :c
    public Ven_registrocita_1(String sday, int day, int moth, int year, Object[][] ocus_pocus) {
        ocus_magnus=ocus_pocus;
        dday=day; dmouth=moth; dyear=year; this.cass=sday;
        horario= new String[] {"08:00","09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
        
      fecha_mostrar= sday + "  " + Integer.toString(day) +  "/" + Integer.toString(moth) + "/" + Integer.toString(year);
      fecha_pato= Integer.toString(year) + "-" + Integer.toString(moth) + "-" + Integer.toString(day) + " ";
        
        casex = new String [ocus_pocus.length][];
        for(int zi=0; zi<=ocus_pocus.length-1; zi++) {
           casex[zi]= new String [ocus_pocus[zi].length-1];                     //No cuento la fecha de nacimiento
           if (Integer.valueOf( ((Date)ocus_pocus[zi][0]).getHours() )<=9 ) {
               casex[zi][0]= "0"+String.valueOf(((Date)ocus_pocus[zi][0]).getHours());
           }   else {
               casex[zi][0]= String.valueOf(((Date)ocus_pocus[zi][0]).getHours());
               }
           casex[zi][0]= casex[zi][0]+ ":";
           casex[zi][0]= casex[zi][0]+String.valueOf(((Date)ocus_pocus[zi][0]).getMinutes());
              for(int zxz=1; zxz<=ocus_pocus[zi].length-2; zxz++) {                //   No llego hasta la fecha de nacimiento
                  casex[zi][zxz]=((String)ocus_pocus[zi][zxz]);    
              }
        }
          
        imprimir= new String [horario.length];
        for(int zi=0; zi<=horario.length-1; zi++) {
            for(int zy=0; zy<=casex.length-1; zy++) {
               if (horario[zi].equals(casex[zy][0])) {
                    imprimir[zi]= esp+horario[zi]+asp+casex[zy][2]+" "+casex[zy][3]; 
                    zy=horario.length;
                }   else {  imprimir[zi]=esp+horario[zi];
                    } 
            }  
        }
        
        casita= imprimir;
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
        BotonCrear = new javax.swing.JButton();
        JLtitulo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        JLtitulo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("formulariopaciente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Horas");

        BotonCrear.setText("Crear");
        BotonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }
        });

        JLtitulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo1.setText(fecha_mostrar);

        jList1.setBackground(new java.awt.Color(0, 204, 204));
        jList1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        jList1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = casita;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);
        jList1.addListSelectionListener (
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    boolean isAdjusting = evt.getValueIsAdjusting();
                    if (!isAdjusting)         {
                        jList1ValueChanged(evt); }
                }
            }
        );

        jButton1.setText("jButton1");

        JLtitulo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo2.setText("Personas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BotonCrear))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(JLtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLtitulo2)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(JLtitulo1)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtitulo2)
                    .addComponent(JLtitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonCrear))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Fondo_Formulariopaciente AplicarFondo = new Fondo_Formulariopaciente();
        
        this.add (AplicarFondo, BorderLayout.SOUTH);
        AplicarFondo.repaint();
   
    }//GEN-LAST:event_formWindowOpened

        private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        //set text on right here
        String liststring = (String) jList1.getSelectedValue();
         char[] s = new char[5+esp.length()];
        liststring.getChars(esp.length(), 5, s, 0);
        String hora_min=new String(s);
        //dhour=  Integer.valueOf(ss.substring(0, 2));
        
        fecha_pato= String.valueOf(dyear)+"-"+String.valueOf(dmouth)+"-"+String.valueOf(dday)+" "+hora_min+":00";
        
        if ((esp.length()+7)<=liststring.length()){
                   //Ven_VerHistorial rafa = new Ven_VerHistorial (ocus_magnus, dhour, cass, dday, dmouth, dyear);
                   //Proyecto.Switch.cambiar_vent(rafa);
                   System.out.println(hora_min);    //System.out.println(dhour);
                   
        }  else {  //Ven_registrocita pato = new Ven_registrocita(ocus_magnus, cass, dday, dmouth, dyear, fecha_pato);
                  // Proyecto.Switch.cambiar_vent(pato);
                   System.out.println(fecha_pato);   //fecha_pato
           }
    }
    
    
    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed
    
    }//GEN-LAST:event_BotonCrearActionPerformed

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
            java.util.logging.Logger.getLogger(Venin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ven_registrocita_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrear;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel JLtitulo1;
    private javax.swing.JLabel JLtitulo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void Cod_registrocita(String[] datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}