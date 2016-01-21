/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import simulacion.Clase_retorno;

/**
 *
 * @author Administrador
 */
public class Funciones {
    //cantSE: cantidad de faltante sin espera de cliente
    //cantCE: cantidad de faltante con espera de cliente
    public static double cantSE = 0, cantCE = 0;

    
    
    /*
        fwrite_aleatorio()
        permite la creacion de un arreglo de numeros aleatorios
        retorna: un arreglo tipo double
    
    *///PRIMER EJEMPLO
  /* public static double [] fwrite_aleatorio(int semilla){
        double[] aleatorios = new double[1200];
        Random rnd = new Random(semilla);
        
        aleatorios[0] = .69; aleatorios[1] = .22 ;aleatorios[2] = .37;aleatorios[3] = .64;aleatorios[4] = .75;aleatorios[5] = .06;
        aleatorios[6] = .60;aleatorios[7] = .43;aleatorios[8] = .54;aleatorios[9] = .47;aleatorios[10] = .79;aleatorios[11] = .10; 
        aleatorios[12] = .96;
        aleatorios[13] = .42;aleatorios[14] = .98;aleatorios[15] = .29;aleatorios[16] = .15;aleatorios[17] = .59;aleatorios[18] = .37;
        aleatorios[19] = .25;aleatorios[20] = .76;aleatorios[21] = .14;
        
        
        DecimalFormat format =new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
                
        for (int i = 21; i < 1200; i++) {
            aleatorios[i] = Double.valueOf(format.format((rnd.nextDouble() * 100)/100));
            //System.out.println(aleatorios[i]);
        }
        return aleatorios;
} *//* //SEGUNDO EJEMPLO
        public static double [] fwrite_aleatorio(int semilla){
        double[] aleatorios = new double[1200];
        Random rnd = new Random(semilla);
        
        aleatorios[0] = .69; aleatorios[1] = .22 ;aleatorios[2] = .37;aleatorios[3] = .64;aleatorios[4] = .75;aleatorios[5] = .06;
        aleatorios[6] = .60;aleatorios[7] = .43;aleatorios[8] = .99;aleatorios[9] = .38;aleatorios[10] = .29;aleatorios[11] = .47; aleatorios[12] = .42;
        aleatorios[13] = .79;aleatorios[14] = .90;aleatorios[15] = .96;aleatorios[16] = .15;aleatorios[17] = .42;aleatorios[18] = .83;
        aleatorios[19] = .98;aleatorios[20] = .80;aleatorios[21] = .15;aleatorios[22] = .50;aleatorios[23] = .59;aleatorios[24] = .37;
        aleatorios[25] = .37;aleatorios[26] = .96;aleatorios[27] = .25;aleatorios[28] = .26;aleatorios[29] = .14;aleatorios[30] = .15;

        
        DecimalFormat format =new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
                
        for (int i = 30; i < 1200; i++) {
            aleatorios[i] = Double.valueOf(format.format((rnd.nextDouble() * 100)/100));
            //System.out.println(aleatorios[i]);
        }
        return aleatorios;
}   */
    
    //La perfect
    public static double [] fwrite_aleatorio(int semilla){
        double[] aleatorios = new double[1200];
        Random rnd = new Random(semilla);             
                
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = Double.valueOf((rnd.nextDouble() * 100)/100);
            //System.out.println(aleatorios[i]);
        }
        return aleatorios;
    } 
   
    
    
    /*
        fread_aleatorios()
        permite la lectura del archivo de numeros aleatorios    
    */
    
    public static double[] fread_aleatorios() {
        String content = null;//contenido del fichero
        File file = new File("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Lecturaarchivos\\src\\lecturaarchivos\\aleatorios.txt"); //ruta completa al fichero que deseamos leer
       // File file = new File("C:\\xampp\\htdocs\\simulacion\\simulacion\\src\\simulacion\\aleatorios.txt");
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
    
    
    /*fcompare(double aleatorio, double[][] compare)
     * permite saber en que intervalo de la matriz se encuentra el numero aleatorio dado
       recibe: numero aleatorio y matriz a comparar
       retorna: el numero de la posicion del intervalo
     */


    public static int fcompare(double aleatorio, double[][] compare){
            
        for (int i=0; i< compare.length; i++) {          
            if (i==0){
                if (aleatorio<compare[i][1]){
                   // System.out.println((int)compare[i][0]);
                    return (int) compare[i][0];
                }
            }else{
                if ((aleatorio>=compare[i-1][1]) &&  (aleatorio<compare[i][1])){
                   // System.out.println((int)compare[i][0]);
                    return (int)compare[i][0];
                }
            }
       }
        return -1;
    }  
    
    public static int fcompare_mayor(double[][] compare){
        int mayor = 0;
        
        for(int i = 0; i < compare.length; i++ ){
            if(compare[i][0] > mayor){
                mayor = (int)compare[i][0];
            }
        }
        return mayor;
    }
    public static int fcompare_menor(double[][] compare){
        int menor = 999;
        
        for(int i = 0; i < compare.length; i++ ){
            if(compare[i][0] < menor){
                menor = (int)compare[i][0];
            }
        }
        return menor;
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
            
            if (q >= var[1]){
                
                q=q-(int)var[1];
                cantCE=cantCE+var[1];
                lista_clientes.remove(i);
                
            }else if ((q != 0) && (q < var[1])){
                
                cantSE=cantSE+(var[1]-q);
                cantCE=cantCE+q;
                q=0;
                lista_clientes.remove(i);
                
            }else{
                i++;
            }
            
            
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
            if ((int)var[0] < 0){
                cantSE=cantSE+var[1];
                lista_clientes.remove(i);
            
           /* Si la posicion 0 del arreglo es diferente a 1, le resto -1 al tiempo de espera 
              y reemplazo el elemento de la lista por el elemento -1
           */     
            }else if ((int)var[0] >= 0){
                var[0]=var[0]-1;
                lista_clientes.set(i, var);
                i++;
            }  
            //incremento el indice de ubicacion de la lista
            
                
        }
        
        return lista_clientes;
    } 
    public static void reanudar(){
        cantSE = 0;
        cantCE = 0;
    }
    
    public static void setCantSE(int faltante){
        cantSE += faltante;
    }
    /*
        fcalculo_q_r (double k, double d, double h, double s)
        metodo que permite el calculo de la cantidad de articulos por pedido (q) y
        el punto de reorden (r)
        
            recibe: k: costo por ordenar, d: demanda, h: costo de inventario, s: costo de faltante sin espera de cliente
            retorna: un arreglo double, donde en la posicion 0 se encuentra q y en la 1 r
    */
    public static int[] fcalculo_q_r (double k, double d, double h, double s, double l, int cantdias){
        int[] valor_retorno = new int[2];
        int q=0,r=0; double aux=0;
        
        //calculo de q por la formula del modelo estatico con escasez
            aux =((2*k*(d*cantdias)*(h+s))/(h*s));
            q = (int) Math.rint( Math.sqrt(aux));
           
        //calculo del punto de reorden
            r=(int) ((l/cantdias)*(d*cantdias));
        
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
    
    public static double[][] table_to_matriz(JTable table){
        
        TableModel model = table.getModel();
        
        double[][] matriz = new double[model.getColumnCount()][2];      
        int i;
        for(i=0; i < model.getColumnCount() && model.getValueAt(0, i) != null; i++){
                matriz[i][0] = Double.parseDouble(""+model.getValueAt(0, i).toString());
                matriz[i][1] = Double.parseDouble(""+model.getValueAt(1, i).toString());
        }
        
        double[][] matriz_fix = new double[i][2];
        
        for(int j=0; j < i; j++){
                matriz_fix[j][0] = matriz[j][0];
                matriz_fix[j][1] = matriz[j][1];
        }
        
        return matriz_fix;
    }
    
    public static void setSize(JTable table){
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(50);
        }     
    }
    
 }  
