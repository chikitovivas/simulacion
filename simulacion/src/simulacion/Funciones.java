/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import simulacion.Clase_retorno;

/**
 *
 * @author Administrador
 */
public class Funciones {
    //cantSE: cantidad de faltante sin espera de cliente
    //cantCE: cantidad de faltante con espera de cliente
    public static double cantSE, cantCE;

    
    
    
    
    
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
    
    
    /*fnumacumulado(double[][] compare)
      permite realizar el acumulado de las probabilidades,
      recibe: una matriz de double
      retorna: la matriz con las probabilidades acumuladas
    */
    public static double[][] fnumacumulado(double[][] compare){
        for (int i=1; i<compare.length; i++){
            compare[i][1]=compare[i][1]+compare[i-1][1];
        }
        return compare;
    
    }  
    
  
    /*
    
    
    */
    public static Clase_retorno fllegada_pedidos (List<double[]> lista_clientes, int q){
        double[] var= new double[2];
        int i=0;
        
        while (i < lista_clientes.size()) {
            //Se obtiene en var el arreglo que se encuentra en la posicion i de la lista
            var = lista_clientes.get(i);
            
            if ((var[0]>0) &&(q>=var[1])){
                q=q-(int)var[1];
                cantCE=cantCE+var[1];
                lista_clientes.remove(i);
            }else if ((var[0]>0) &&(q<var[1])){
                cantSE=cantSE+(var[1]-q);
                cantCE=cantCE+q;
                q=0;
                lista_clientes.remove(i);
            }  
            //incremento el indice de ubicacion de la lista
            
            i++;
        }
        return new Clase_retorno(lista_clientes, q);
        
    }
  
    
    /* fespera_clientes  
        metodo que permite revisar a diario el tiempo de espera de los clientes, si su tiempo llega a 0, se remueve de la lista de clientes.
            recibe: lista de clientes (List<double[]> lista_clientes)
            salida: lista de clientes modificada List<double[]>
    */
    public static List<double[]> fespera_clientes (List<double[]> lista_clientes){
        
        double[] var= new double[2];
        int i=0;
        
        while (i < lista_clientes.size()) {
            //Se obtiene en var el arreglo que se encuentra en la posicion i de la lista
            var = lista_clientes.get(i);
            
            /*si en la posicion 0 de var (el tiempo de espera del cliente), es igual que 1,se resta un 
              dia, por lo que el tiempo de espera queda en 0, lo que nos lleva a remover el elemento, 
              tomando su faltante y sumando al costo por faltate sin espera del cliente (costoSE)
            */
            if (var[0]==0){
                cantSE=cantSE+var[1];
                lista_clientes.remove(i);
            
           /* Si la posicion 0 del arreglo es diferente a 1, le resto -1 al tiempo de espera 
              y reemplazo el elemento de la lista por el elemento -1
           */     
            }else if (var[0]>0){
                var[0]=var[0]-1;
                lista_clientes.set(i, var);
            }  
            //incremento el indice de ubicacion de la lista
            i++;
                
        }
        return lista_clientes;
    } 
    
    
    
    /*
        fcalculo_q_r (double k, double d, double h, double s)
        metodo que permite el calculo de la cantidad de articulos por pedido (q) y
        el punto de reorden (r)
        
            recibe: k: costo por ordenar, d: demanda, h: costo de inventario, s: costo de faltante sin espera de cliente
            retorna: un arreglo double, donde en la posicion 0 se encuentra q y en la 1 r
    */
    public static double[] fcalculo_q_r (double k, int d, double h, double s, int l){
        double[] valor_retorno = new double[2];
        double q=0,r=0,aux=0;
        
        //calculo de q por la formula del modelo estatico con escasez
            aux =((2*k*d*(h+s))/(h*s));
            q = Math.sqrt(aux);
           
        //calculo del punto de reorden
            r=l*d;
        
        valor_retorno[0] = q;
        valor_retorno[1] = r;
        
        return valor_retorno;
    
    }
    
    
    /*
        fcosto_faltante (double costoSE, double costoCE):
            permite calcular el costo faltante total de la simulacion
            recibe: costo sin espera del cliente y el costo con espera del cliente
            retorno: retorna el valor total del costo faltante, la multiplicacion del 
                    costo sin espera por la cantidad + el costo con espera por la cantidad
    */
    public static double fcosto_faltante (double costoSE, double costoCE){
        return ((costoSE*cantSE)+(costoCE*cantCE));
    }
    

 }  
