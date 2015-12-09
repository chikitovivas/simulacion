/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario_Consultorio;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nico
 */

public class Cod_calendario {
 
    public Date[] puntos;    
    public int[] Diccionario=null;
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
        Date[] aux=new Date[fil];
        Date[]aux2;
        
        int[] auxdicc=new int[fil];
        
        aux[dist]=(Date)citas[0][0];
        auxdicc[0]=dist++;
        
        
        
        for(int i=1;i<fil;i++){           
            if(aux[dist-1].compareTo((Date)citas[i][0])!=0){                
                aux[dist]=(Date)citas[i][0]; //moviendo filas                
                auxdicc[dist++]=i;                                
              }                         
        }
        
        aux2=new Date[dist];  
        Diccionario=new int[dist];
        
        for(int i=0;i<dist;i++){
            aux2[i]=aux[i];
            Diccionario[i]=auxdicc[i];
        }
        
        
    return aux2;
    }
        

    /**
     * retorna las tuplas de una fecha en especifico 
     */
    public Object[][] procesar_cita(Date fech){
        int max=puntos.length;
        //System.out.println(max+" tamano de puntos");
        if(max<=0)
            return null;
        
        int pos_ini; //posicion incial de la fecha requerida
        int aaaaaja=-1;
        for(pos_ini=0;pos_ini<max;pos_ini++){
            if(puntos[pos_ini].compareTo(fech)==0){
                        aaaaaja=1;    
                        break; //cortar la iteracion                                             
            }
        }
                          
        if  (aaaaaja!=1)    // no consiguio la fecha
            return null;
        
        
        Object[][] aux=null;            
        
        if (pos_ini+1==max){ // si estas parado en la ult tupla
            aux=new Object[0][col-1];//solo guarda una tupla
            pos_ini=Diccionario[pos_ini];
            
            System.out.println(aux[0].length); //MIERDA NO FUNK
            
            for(int j=1;j<col;j++)//empezando despues de las fechas
                aux[0][1]=tuplas[pos_ini][j];
        imprimir_prueba(fil, col, aux);
        return aux;

        }else{ //no estas en la ult tupla
                                
            int pos_fin=Diccionario[pos_ini+1]; //indice de la tuplas en la posicion final
            pos_ini=Diccionario[pos_ini];   //indice de las tuplas en la posicion incial            
            aux=new Object[pos_fin-pos_ini][col-1];
            for(int i=0;i<pos_fin-pos_ini;i++){
                for(int j=1;j<col;j++){
                    aux[i][j-1]=tuplas[pos_ini+i][j];                
                }                        
            }            
        }
                              
        return aux;
    }
        
    
    
   
            
        // PRUEBA COD CALENDARIO
         public static void main(String args[]) {
             Object[][] tuplas=null;
             int col=3,fil=7; //valores iniciales
                          
             Calendar calendario = Calendar.getInstance();
             
             Date fecha=calendario.getTime();
             Date fecha2=new Date();
             Date fecha3=new Date();
             Date fecha4=new Date();
             fecha2.setDate(5);
             fecha3.setMonth(5);
             fecha4.setYear(116);             
             
             
             //fecha.setDate(0); fecha.setHours(0); fecha.setMinutes(0); fecha.setMonth(0); fecha.setSeconds(0); fecha.setYear(0);
             
             tuplas=new Object[fil][col]; 
             
             tuplas=llenar_prueba(fil,col,tuplas,fecha,fecha2,fecha3,fecha4);             
             
             Cod_calendario calen= new Cod_calendario(col,fil,tuplas);
             imprimir_puntos_diccionario(calen.col, calen.fil, calen.puntos, calen.Diccionario);
             System.out.println();System.out.println();
             //imprimir_prueba(calen.fil, calen.col,calen.tuplas);
             
             calen.procesar_cita(fecha4);
             
             
        }
         
        private static Object[][] llenar_prueba(int fil,int col, Object[][] tuplas, Date fecha,Date fecha2,Date fecha3,Date fecha4){

                       System.out.println("Fecha 1 "+fecha+" Fecha 2 "+fecha2+" Fecha 3 "+fecha3+" Fecha 4 "+fecha4);
                       
                       int F=fil-1;
                       
            for(int i=0;i<fil;i++){
                 for(int j=0;j<col;j++){
                     //agregando fecha
                     
                     if(j==0){                        
                         switch(i){
                            case 0: tuplas[i][j]=fecha3;break;
                            case 1: tuplas[i][j]=fecha2;break;
                            case 2: tuplas[i][j]=fecha;break;                            
                            default: tuplas[i][j]=fecha; if(i==fil-1)tuplas[i][j]=fecha4;break;            
                        }       
                        // tuplas[i][j]=fecha;                                                                           
                     }else{
                         tuplas[i][j]="MIERDA";                     
                     }                                          
                 }             
             }
            
            
            return tuplas;
        }
         
        private static void imprimir_prueba(int fil,int col, Object[][] tuplas){
            for(int i=0;i<fil;i++){
                for (int j=0;j<col;j++){
                    System.out.print(tuplas[i][j]+" ");                
                }
                System.out.println();
            
            }
        
        
        
        }
         
         
        private static void imprimir_puntos_diccionario(int fil,int col,Date[] puntos, int[] diccionario){            
            System.out.println();System.out.println();
            System.out.println("Vector Diccionario");
            for(int i=0;i<diccionario.length;i++)
               System.out.println(diccionario[i]);
            
            
            System.out.println();System.out.println();
            System.out.println("Vector puntos");
            for(int i=0;i<puntos.length;i++)
               System.out.println(puntos[i]);
            /*
            if(puntos[0].compareTo(puntos[1])==-1)
                System.out.println("el anterior es menor");
            else 
                System.out.println("el anterior NO es menor "+puntos[0].compareTo(puntos[1]));
             */           
        }   
         
}



