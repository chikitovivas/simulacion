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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */

public class Cod_calendario {
 
    Date[] puntos;
    int[] Diccionario;
    int col,fil;    
    Object[][] tuplas;
    
    
/**
 * Inicializando variables para la logica del calendario y poder ordenar puntos
 *  inicializa los puntos y el diccionario
 * @param tam_col numero de columnas de las tuplas
 * @param tam_fil numero de filas de las tuplas
 * @param tuplas vector bidimensional con las tuplas
 */
    Cod_calendario(int tam_col,int tam_fil,Object[][] tuplas){    //constructor
        this.tuplas=tuplas;
        this.col=tam_col;
        this.fil=tam_fil;
        puntos=(Date[])set_puntos(col,fil,this.tuplas);
    }

    /**
     * procesa los resultados del servidor en un arreglo ordenado y crea el diccionario index para busquedas rapidas
     * @param x tabla resultado con las fechas a procesar
     * @return arreglo de fechas en las cuales hay citas
     */
    Object[] set_puntos(int col,int fil,Object[][] citas){
        if (col<=0)
            return null;
        if (fil<=0)
            return null;
        if (citas==null)
            return null;
        int dist=0;
        Object[] aux=new Object[fil];
        
        aux[dist++]=citas[0][0];
        Diccionario[0]=dist++;
        
        for(int i=1;i<fil;i++){
            if(aux[i-1]!=citas[0][i]){
                aux[dist++]=citas[0][i]; //moviendo filas
                Diccionario[dist++]=i;
            }                         
        }
          
        
        
    return aux;
    }
        

    
    public Object[][] procesar_cita(int dia,int mes, int anyo){
        int max=puntos.length;
        int pos_ini; //posicion incial de la fecha requerida
        int aaaaaja=-1;
        for(pos_ini=0;pos_ini<max;pos_ini++){
            if(puntos[pos_ini].getDate()==dia){
                if(puntos[pos_ini].getMonth()==mes){
                    if(puntos[pos_ini].getYear()==anyo){
                        aaaaaja=1;    
                        break; //cortar la iteracion
                    }            
                }            
            }                                
        }
        
        Object[][] aux=null;
            
        if  (aaaaaja!=1)    // no consiguio la fecha
            return null;
            
        if (pos_ini+1==max){ // si estas parado en la ult tupla
            aux=new Object[0][col];//solo guarda una tupla
            for(int j=1;j<col;j++)//empezando despues de las fechas
                aux[0][j]=tuplas[pos_ini][j];
            return aux;
        }else{ //no estas en la ult tupla
                                
            int pos_fin=Diccionario[pos_ini+1]-1; //indice de la tuplas en la posicion final
            pos_ini=Diccionario[pos_ini];   //indice de las tuplas en la posicion incial
            
            aux=new Object[pos_fin-pos_ini][col];
            
            for(int i=0;i<pos_fin-pos_ini;i++){
                for(int j=1;j<col;j++){
                    aux[i][j]=tuplas[pos_ini+i][j];                
                }                        
            }
            
            
           
        }
        
      
        return aux;
    }
    
    
   
}
