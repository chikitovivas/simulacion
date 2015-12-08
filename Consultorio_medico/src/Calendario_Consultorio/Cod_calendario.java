/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario_Consultorio;

import consultorio_medico.Proyecto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */

public class Cod_calendario {
 
    Object[] puntos;
    int[] Diccionario;
    String[] columnas;
    Object[][] tuplas;
    
    /**
     * inicializando variables... el resultset a trabajar y el arreglo de resultset ordenado
     * @param citas resultado de la base de datos .... las citas acotadas
     */
    Cod_calendario(String[] columnas,Object[][] tuplas){    //constructor
        
         
               
    }
    
  
    
    
   
    
    /**
     * procesa los resultados del servidor en un arreglo ordenado
     * @param x tabla resultado con las fechas a procesar
     * @return arreglo de fechas en las cuales hay citas
     */
    Object[] set_puntos(String[] columnas,Object[][] citas){
        if (columnas==null)
            return null;
        if (citas==null)
            return null;
        
        Object aux[]=null;
        Iterator it;
        
        
        
        
        
                    
    return aux;
    }
    
    /**
     * crea un arreglo index para el arreglo de las citas
     * @param x
     * @return 
     */
     Object[] ordenar_puntos(ResultSet x){
         if(x==null)
             return null;         
        Object[] aux= null;
       
        
       
        
        return aux;
    }
             
    
}
