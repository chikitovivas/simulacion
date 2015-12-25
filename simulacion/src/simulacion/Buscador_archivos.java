/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrador
 */
public class Buscador_archivos {
    static Menu menu = new Menu();
    
    public static void archivo(){

            String adr= new String("");
            
            //nos creamos el JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("*.TXT", "txt"));
            
            int seleccion = fileChooser.showSaveDialog(fileChooser);
                
            //analizamos la respuesta
            switch(seleccion) {
            case JFileChooser.APPROVE_OPTION:
             //seleccionó abrir
                 File fichero = fileChooser.getSelectedFile();
                //obtenemos la ruta
                adr = fichero.getAbsolutePath();
                System.out.println(adr);
             break;

            case JFileChooser.CANCEL_OPTION:
             //dio click en cancelar o cerro la ventana
                menu.setVisible(true);
             break;

            case JFileChooser.ERROR_OPTION:
             //llega aqui si sucede un error 
                menu.setVisible(true);
             break;
            }
    }
}
