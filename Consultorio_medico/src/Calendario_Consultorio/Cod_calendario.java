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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */

public class Cod_calendario {
    ResultSet rs;    
    Object[] puntos;
    Date[] diccionario;
    
    /**
     * inicializando variables... el resultset a trabajar y el arreglo de resultset ordenado
     * @param citas resultado de la base de datos .... las citas acotadas
     */
    Cod_calendario(Object citas){    //constructor
        rs=(ResultSet)citas;
        puntos=set_puntos(rs);
        diccionario=(Date[])ordenar_puntos(rs);        
               
    }
    
    
    
    
    
   
    
    /**
     * procesa los resultados de la base de datos en un arreglo ordenado
     * @param x tabla resultado con las fechas a procesar
     * @return arreglo de fechas en las cuales hay citas
     */
    Object[] set_puntos(ResultSet x){
        Object aux[]=null;
        if(x==null)
          return null;
        
        aux= new Object[Proyecto.con.contar_filas(x)];
        try {
            x.next();
            for(int i=0; x.next();i++){
                aux[i]=x.getObject(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cod_calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    return aux;
    }
    
    
     Object[] ordenar_puntos(ResultSet x){
         if(x==null)
             return null;         
        Object[] aux= new Object[Proyecto.con.contar_filas(x)];
        Object[] aux2=null;
        
        String columna="fechas"; //nombre del atributo con las fechas en el resultset
               
        
        try {
            
            if(aux.length<=1) // si el resultset tiene solo 1 tupla retorna
                return null;
            
            x.next();
            aux[0]=x.getObject(columna);
            
            int fechas_distintas=0;
            for(int i=1;x.next();i++){
                if(aux[i-1]!=x.getObject(columna)){
                    aux[i]=x.getObject(columna); //columna con las fechas                  
                    fechas_distintas++;
                }             
            }
           
            
            aux2=new Object[fechas_distintas]; 
            for(int i=0;i<fechas_distintas;i++)
                aux2[i]=aux[i];
            
 
        } catch (SQLException ex) {
            Logger.getLogger(Cod_calendario.class.getName()).log(Level.SEVERE, null, ex);
        }       
           
        
        
        return aux2;
    }
             
    
}
