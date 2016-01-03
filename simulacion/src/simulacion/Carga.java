/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Administrador
 */


public class Carga extends JPanel{

    static JProgressBar pbar;
    static final int MINIMUM = 0;
    static final int MAXIMUM = 100;
    static String nombreachivo;
    
    public Carga() {
      pbar = new JProgressBar();
      pbar.setMinimum(MINIMUM);
      pbar.setMaximum(MAXIMUM);
      add(pbar);
    }
    
    public void updateBar(int newValue) {
      pbar.setValue(newValue);
    }
    public static void llamada(String archivo) {
        
        final PantallaCarga it = new PantallaCarga();
                    
                    JFrame frame = new JFrame("Cargando archivo...");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    frame.setLocationRelativeTo(null);
                    
                    frame.setContentPane(it);
                   // frame.pack();
                    frame.setVisible(true);
                    TitledBorder border = BorderFactory.createTitledBorder(archivo); //Titulo del borde
                          
                    for (int i = MINIMUM; i <= MAXIMUM; i++) {
                      final int percent = i;
                      try {
                          pbar.setValue(i);    //Porcentaje a mostrar de la barra  
                          pbar.setStringPainted(true); //String del porcentaje                          
                          frame.setSize(300, 100); //tamaño del frame
                          pbar.setBorder(border); //borde
                         // pbar.setSize(200, 50);//tamaño de la barra
                          SwingUtilities.invokeLater(new Runnable() {
                            public void run() {  
                              it.updateBar(percent);
                            }
                          });
                        java.lang.Thread.sleep(50);
                      
                      } catch (InterruptedException e) {
                        ;
                      }
                    }
            
                    frame.dispose();
        
        
                
    }
    
       
}