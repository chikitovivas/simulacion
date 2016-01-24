/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio_medico;

import Calendario_Consultorio.Panel_calendario;
import Calendario_Consultorio.Ven_calendario;
import JSON.Crearjsoncalendario;
import Lista_citas.Panel_registrocita_1;
import Lista_citas.Ven_registrocita_1;
import Registro_cita.Panel_cita;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import verHistorial.Panel_Historial;

/**
 *
 * @author Rafael
 */
public class PanelPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form PanelPrincipal
     */
    Panel_calendario panelCalendario;
    Panel_registrocita_1 panelLista;
    Panel_Historial panelHistorial;
    Panel_cita panelRegistroCita;
    int ancho, largo;
    boolean bandera=true; // Bandera para saber si a la izquiera esta agregar un paciente o que..

    
    JButton botonRegis;
    
    public PanelPrincipal(Dimension d) {
        initComponents();
        
       Crearjsoncalendario prueba=new Crearjsoncalendario(25620021);     
       
                this.panelCalendario=new Panel_calendario(
                prueba.fil,
                prueba.col,
                prueba.tuplas);
        
                 panelRegistroCita=new Panel_cita();
                
     
        panelLista= new Panel_registrocita_1();
      
   
           panelCalendario.setVisible(true);
           panelLista.setVisible(true);
           panelRegistroCita.setVisible(true);
           
           ancho=d.width;
           largo=d.height;
           
           
           panelCalendario.setBounds(0, 0,ancho/2, (largo/2)+10);
          panelLista.setBounds(0, (largo/2)+11, (ancho/2), (largo/2) );
          panelRegistroCita.setBounds((ancho/2)+1, 0, (ancho/2)-1, largo);
                 
        this.add(panelRegistroCita);
        this.add(panelCalendario);
        this.add(panelLista);
        panelCalendario.getjButton1().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
         

          
        });
        
        panelLista.getList().addListSelectionListener (
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    boolean isAdjusting = evt.getValueIsAdjusting();
                    if (!isAdjusting)         {
                        jList1ValueChanged(evt); }
                }
            }
        );
     //   this.add(panelHistorial);
        //this.add(panelRegistroCita);
        
    }
// funcion que hace la logica de nicolas de llamar a cabral. no se por que me la treaje para aca jaja
         private void llamar_cabral(String day, Date aux, Object[][] mierda_para_cabral) {
             panelLista.setVisible(false);
                panelLista=new Panel_registrocita_1(  //Constructor que debemos utilizar
                                                                         day,           //el dia si te pierdes puede mirar arriba cabron
                                                                         aux.getDate(), // numero del dia
                                                                         aux.getMonth()+1, // numero del mes
                                                                         aux.getYear()+1900,// numero del año
                                                                         mierda_para_cabral// tabla con las tuplas que te importan         
                                        );
        panelLista.setVisible(true);
        panelLista.setBounds(0, (largo/2)+11, (ancho/2), (largo/2) );
         panelLista.getList().addListSelectionListener (
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    boolean isAdjusting = evt.getValueIsAdjusting();
                    if (!isAdjusting)         {
                        jList1ValueChanged(evt); }
                }
            }
        );
        this.add(panelLista);
        
        this.updateUI();
        }
 // Aqui es el listener del boton del calendario de nicolas
         // cuando lo selecciona llamo a la parte de cabral
  private void jButton1ActionPerformed(ActionEvent evt) {
           Object[] ret= panelCalendario.pruebacalen();
           String day=(String)ret[0];
           Date aux=(Date)ret[1];
           Object[][] mierda_para_cabral=(Object[][]) ret[2];
           
           llamar_cabral(day, aux,mierda_para_cabral);
 }
    
  
  // Este es el listener de la lista de cabral a la hora que cambia llama a la funcion de cabral y me traigo
  // los objetos que crea cabral como retorno en un object [2]
  // el cual es primero es un entero y el segundo es o el panel mio(rafa) o el de pato
  // despues que los tengo los agrego a la ventana y listo
   private void jList1ValueChanged(ListSelectionEvent evt) {
             Object[] retorno=panelLista.jListChange();
             if(bandera){
                 panelRegistroCita.setVisible(false);
             }else{
                 panelHistorial.setVisible(false);
             }
             if((int)retorno[0]==1){// 1 es pato
                 bandera=true;
                 panelRegistroCita=(Panel_cita)retorno[1];
                 panelRegistroCita.setBounds((ancho/2)+1, 0, (ancho/2)-1, largo);
                 panelRegistroCita.setVisible(true);
                 panelRegistroCita.getBotonCrear().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }

             
        });
                 panelRegistroCita.getBotonLimpiar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }

                    
        });
                 this.add(panelRegistroCita);
             }else{ // 0 es rafa
                 bandera=false;
                 panelHistorial=(Panel_Historial)retorno[1];
                 panelHistorial.setBounds((ancho/2)+1, 0, (ancho/2)-1, largo);
                 panelHistorial.setVisible(true);
                 this.add(panelHistorial);
             }
              this.updateUI();
   }
   
   
   
    private void BotonLimpiarActionPerformed(ActionEvent evt) {
         panelRegistroCita.limpiar();
    }
    
   private void BotonCrearActionPerformed(ActionEvent evt) {
           panelRegistroCita.crear();        
           refrescar();
   }
   
   public void refrescar(){
        Crearjsoncalendario prueba=new Crearjsoncalendario(25620021);     
          
                panelCalendario.refrescarCalendario(
                prueba.fil,
                prueba.col,
                prueba.tuplas);
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
