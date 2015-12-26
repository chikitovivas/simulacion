/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrador
 */
public class Buscador_archivos {
    static Menu menu = new Menu();
    static Home home = new Home();
    
    
    
    public static void leer_archivo(String arch){
		// Fichero del que queremos leer
		File fichero = new File(arch);
		Scanner s = null;
                
                
                double[][] matriz_demanda=null;
                double[][] matriz_entrega=null; 
                double[][] matriz_espera=null;
                
                double costo_inventario=0;//Costo de inventario
                double costo_ordenar=0;//Costo de ordenar
                double costo_faltanteCE=0;//Costo de faltante con espera de cliente
                double costo_faltanteSE=0;//Costo de faltante sin espera del cliente
                double inventario_inicial=0;//Inventario inicial
                
		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);

			// Leemos linea a linea el fichero
                        int j=1;
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				//System.out.println(linea);      // Imprimimos la linea
                                String[] array_string = linea.split(" - ");
                                String[] array_string1=null;
                                String[] array_string2=null;
                                
                                //System.out.println(array_string[0]); //titulo del dato que se esta guardando
                                
                                switch ( j ) {
                                 case 1://Demanda diaria y probabilidad
                                    array_string1 = array_string[1].split(",");
                                    array_string2 = array_string[2].split(",");
                                    
                                    matriz_demanda = new double[array_string1.length][2];
                                    
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_demanda[i][0] = Double.parseDouble(array_string1[i]);
                                        //System.out.println(matriz_demanda[i][0]);
                                     }
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_demanda[i][1] = Double.parseDouble(array_string2[i]);
                                        //System.out.println(matriz_demanda[i][1]);
                                     }
                                    
                                    break;
                                    
                                 case 2://Tiempo de entrega y probabilidad
                                    
                                    array_string1 = array_string[1].split(",");
                                    array_string2 = array_string[2].split(",");
                                    matriz_entrega = new double[array_string1.length][2];
                                    
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_entrega[i][0] = Double.parseDouble(array_string1[i]);
                                        //System.out.println(matriz_entrega[i][0]);
                                     }
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_entrega[i][1] = Double.parseDouble(array_string2[i]);
                                        //System.out.println(matriz_entrega[i][1]);
                                     }
                                    
                                    break;
                                 
                                 case 3://Tiempo de espera del cliente por el artículo y probabilidad
                                    
                                    array_string1 = array_string[1].split(",");
                                    array_string2 = array_string[2].split(",");
                                    matriz_espera = new double[array_string1.length][2];
                                    
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_espera[i][0] = Double.parseDouble(array_string1[i]);
                                        //System.out.println(matriz_espera[i][0]);
                                     }
                                    for(int i = 0; i < array_string1.length;i++){
                                        matriz_espera[i][1] = Double.parseDouble(array_string2[i]);
                                        //System.out.println(matriz_espera[i][1]);
                                     }
                                    
                                      break;
                                 case 4://Costo de inventario
                                    costo_inventario= Double.parseDouble(array_string[1]);
                                    //System.out.println(costo_inventario);    
                                      break;
                                 case 5://Costo de ordenar
                                    costo_ordenar= Double.parseDouble(array_string[1]);
                                    //System.out.println(costo_ordenar);    
                                      break;
                                      
                                 case 6://Costo de faltante con espera de cliente
                                    costo_faltanteCE= Double.parseDouble(array_string[1]);
                                    //System.out.println(costo_faltanteCE);    
                                      break;
                                      
                                 case 7://Costo de faltante sin espera del cliente
                                    costo_faltanteSE= Double.parseDouble(array_string[1]);
                                    //System.out.println(costo_faltanteSE);    
                                      break;
                                      
                                 case 8:// Inventario inicial
                                    inventario_inicial= Double.parseDouble(array_string[1]);
                                    //System.out.println(inventario_inicial);     
                                      break;

                                 }              
                                
                                j++;

			}
                System.out.println("llamamos a home");
                //llamada a home al constructor con parametros
                //home (matriz_demanda,matriz_entrega,matriz_acum_demanda, matriz_acum_entrega, matriz_acum_espera,costo_inventario, 
                 //       costo_ordenar, inventario_inicial, costo_nespera, costo_espera);
                       
                        
		}//fin del try
                catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} 
                finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
                
                
                
                
	}//FIn metodo leer_archivo
    
    
    
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
                //System.out.println(adr);
                //Abrir de ventana de cargando archivo
                leer_archivo(adr);
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
