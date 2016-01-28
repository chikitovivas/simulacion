/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta.pruebasall;
import Lista_citas.*;
import JSON.JSON;
import Registro_cita.Fondo_Formulariopaciente;
import Registro_cita.Panel_cita;
import Registro_cita.Ven_registrocita;
import consultorio_medico.Proyecto;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import verHistorial.Panel_Historial;
import verHistorial.Ven_VerHistorial;
/**
 *
 * @author Rafael
 */
public class My_Panel_1 extends javax.swing.JPanel {
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
        public My_Panel_1() {
            
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
    
    
    public My_Panel_1(String sday, int day, int moth, int year, String llae) {
        
        dday=day; dmouth=moth; dyear=year; this.cass=sday;
        
        fecha_mostrar= sday + "  " + Integer.toString(day) +  "/" + Integer.toString(moth) + "/" + Integer.toString(year);
        fecha_pato= Integer.toString(year) + "-" + Integer.toString(moth) + "-" + Integer.toString(day) + " ";
      
        horario= new String[] {"08:00","09:33","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
          
        imprimir= new String [horario.length];
        for(int zi=0; zi<horario.length; zi++) {
            imprimir[zi]= esp+horario[zi];
        }
        
        casita= imprimir;
        initComponents();
        System.out.println("Pase por aca");
    }   
    
    
    
    
    
    
    //Segundo Constructor y es el que se va a usar "normalmente"                        sigh :c
    public My_Panel_1(String sday, int day, int moth, int year, Object[][] ocus_pocus) {
         
//                 if (ocus_pocus.length==0) {new My_Panel_1 ( sday,  day,  moth,  year); 
//                               return;}
                 
        ocus_magnus=ocus_pocus;
        dday=day; dmouth=moth; dyear=year; this.cass=sday;
        horario= new String[] {"08:00","09:00","09:33","09:51","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
        
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
           if (Integer.valueOf( ((Date)ocus_pocus[zi][0]).getMinutes())<=9 ) {
               casex[zi][0]= casex[zi][0]+"0"+String.valueOf(((Date)ocus_pocus[zi][0]).getMinutes());
           }   else {
               casex[zi][0]= casex[zi][0]+String.valueOf(((Date)ocus_pocus[zi][0]).getMinutes());
               }
              for(int zxz=1; zxz<=ocus_pocus[zi].length-2; zxz++) {                //   No llego hasta la fecha de nacimiento
                  casex[zi][zxz]=(ocus_pocus[zi][zxz].toString()); 
                 // System.out.printf(casex[zi][zxz]);
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

        JLtitulo1 = new javax.swing.JLabel();
        JLtitulo = new javax.swing.JLabel();
        JLtitulo2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setPreferredSize(new java.awt.Dimension(589, 350));

        JLtitulo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo1.setText(fecha_mostrar);

        JLtitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo.setText("Horas");

        JLtitulo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JLtitulo2.setText("Personas");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLtitulo1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLtitulo)
                                .addGap(52, 52, 52)
                                .addComponent(JLtitulo2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLtitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLtitulo)
                    .addComponent(JLtitulo2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents


    public Object[] jListChange(){
         //set text on right here
        String liststring = (String) jList1.getSelectedValue();
         char[] s = new char[5+esp.length()];
        liststring.getChars(esp.length(), 5, s, 0);
        String hora_min=new String(s);
        dhour=  Integer.valueOf(hora_min.substring(0, 2));
      Object retorno[];
      retorno = new Object[2];
        
        fecha_pato= String.valueOf(dyear)+"-"+String.valueOf(dmouth)+"-"+String.valueOf(dday)+" "+hora_min+":00";
        System.out.println("hola1");
        if ((esp.length()+7)<=liststring.length()){
                   Panel_Historial rafa = new Panel_Historial (ocus_magnus, dhour, cass, dday, dmouth, dyear);
                   int aux=0;
                   System.out.println("hola2");
                   retorno[0]=aux;
                   retorno[1]=rafa;
                   return retorno;
                  
                   
        }  else {  //System.out.print("penemalditoansias");
                   Ven_registrocita pato = new Ven_registrocita(ocus_magnus, cass, dday, dmouth, dyear, fecha_pato);
                   // Panel_cita pato = new Panel_cita(fecha_pato);
                    System.out.println("hola3");
                   int aux=1;
                   retorno[0]=aux;
                   retorno[1]=pato;
                   return retorno;
                  // Proyecto.Switch.cambiar_vent(pato);
                   //System.out.println(fecha_pato);   //fecha_pato
           }
    }
    

        private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
           // aqui se puede hacer otra cosa si cambia la lista
           //System.out.println("jLsit");
    }
    
        public JList getList(){
            return jList1;
        }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLtitulo;
    private javax.swing.JLabel JLtitulo1;
    private javax.swing.JLabel JLtitulo2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
