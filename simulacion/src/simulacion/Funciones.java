/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Administrador
 */
public class Funciones {
    

public static double[] fread_aleatorios() {
               
        String content = null;//contenido del fichero
       // File file = new File("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Lecturaarchivos\\src\\lecturaarchivos\\aleatorios.txt"); //ruta completa al fichero que deseamos leer
        File file = new File("C:\\xampp\\htdocs\\simulacion\\simulacion\\src\\simulacion\\aleatorios.txt");
        try {
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
             return array_num;           
        } catch (IOException e) {
                e.printStackTrace();
        }
        return null;
    }
    
    public static int fcompare(double aleatorio, double[][] compare){
            
        for (int i=0; i< compare.length; i++) {          
            if (i==0){
                if (aleatorio<=compare[i][1]){
                   // System.out.println((int)compare[i][0]);
                    return (int) compare[i][0];
                }
            }
            else{
                if ((aleatorio>compare[i-1][1]) &&  (aleatorio<=compare[i][1])){
                   // System.out.println((int)compare[i][0]);
                    return (int)compare[i][0];
                }
            }
       }
        return -1;
    }  
    
    public static double[][] fnumacumulado(double[][] compare){
        for (int i=1; i<compare.length; i++){
            compare[i][1]=compare[i][1]+compare[i-1][1];
        }
        return compare;
    
    }  
    
    public static double fsalida(double cfaltante_CE, double cfaltante_SE, double corden, double cinventarioD, int cantfaltante_CE, int cantfaltante_SE, int cantordenes){
          /*double cfaltante_CE: costo faltante con espera de cliente (Dato ingresado por el usuario)
            double cfaltante_SE:  costo faltante sin espera de cliente
            double corden: costo de orden
            double cinventarioD:  costo de inventario diario por unidad
            int cantfaltante_CE: cantidad de faltantes con espera de clientes
            int cantfaltante_SE: cantidad de flantantes sin espera de clientes
            int cantordenes: cantidad de ordenes realizadas
          */
          
        double cfaltante=0, ctotalorden=0, ctotal=0, ctotalinventario=0; 
                
        cfaltante = (cantfaltante_CE*cfaltante_CE) + (cantfaltante_SE*cfaltante_SE);
        ctotalorden = cantordenes * corden;
	//ctotalinventario= SInv.Prom.diariodia=15dia=1 * cinventarioD;
	ctotal= cfaltante+ctotalorden+ctotalinventario;
    
        return ctotal;
    }

 }  
