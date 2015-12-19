/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Simulacion {

    static Home VentanaPrincipal = new Home();
    
    
    
       public static void fread_aleatorios() {
               
        String content = null;//contenido del fichero
        File file = new File("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Lecturaarchivos\\src\\lecturaarchivos\\aleatorios.txt"); //ruta completa al fichero que deseamos leer
        try {
            //Abrir el archivo
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            //Lectura del archivo
            reader.read(chars);
            content = new String(chars);                       
            //Cerrardel archivo
            reader.close();
            //eEliminar espacios en blanco (opcional)
            content = content.replaceAll("\\s","");
           //Asignación de cada valor al nuevo vector                        
            String[] array_string = content.split(",");

            double[] array_num = new double[array_string.length];

            for(int i = 0; i < array_string.length;i++){
                array_num[i] = Double.parseDouble(array_string[i]);
                //System.out.println(array_num[i]);
             }
                        
        } catch (IOException e) {
                e.printStackTrace();
        }
        
    }
    
    public static void fcompare(double aleatorio, double[][] compare){
            
        for (int i=0; i< compare.length; i++) {          
            if (i==0){
                if (aleatorio<=compare[i][1])
                    System.out.println((int)compare[i][0]);
            }
            else{
                if ((aleatorio>compare[i-1][1]) &&  (aleatorio<=compare[i][1]))
                    System.out.println((int)compare[i][0]);
            }
       }
    }  
    
    
    
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());  
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        VentanaPrincipal.setVisible(true);
    }
    
}
