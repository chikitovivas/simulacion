/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Nico
 */
public class Crearjsoncalendario {
        
    public int fil;
    public int col;
    public Object[][] tuplas;
    public Crearjsoncalendario(int ci){
        this.tuplas = null;
        this.col = 0;
        this.fil = 0;
        
        this.Peticion_Citas(ci);
        
    
    }
    
    public void Peticion_Citas(int ci){
    
        // para prueba 
        ci=25620021;
        
        HttpClient client = new DefaultHttpClient();
        int id=1;
        String dirLAN=
                //"169.254.105.188";// con router nico NO WIFI
                "miconsultoriocal.no-ip.org"; //Router remoto rafa
 
        
          HttpGet get = new HttpGet("http://"+dirLAN+":8000/cita/"+ci);
        //          
        
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);
            
             JSONArray json = new JSONArray(content);      //JSON                       
             this.tuplas=crear_matriz(json);
             
        } catch (Exception ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
    }
    
    private Date crear_date(Object fechahora){
        Date aux=null;
        String fech=fechahora.toString();

        aux=new Date(Integer.parseInt(fech.substring(0, 4))-1900 //año
                    ,Integer.parseInt(fech.substring(5, 7))-1    //mes
                    ,Integer.parseInt(fech.substring(8, 10))     //dia
                    ,Integer.parseInt(fech.substring(11, 13))   //hora
                    ,Integer.parseInt(fech.substring(14, 16))   //minutos  
                    ,Integer.parseInt(fech.substring(17, 19))); //segundos
       
        
    return aux;
    }
       
    private JSONArray ordenar_json(JSONArray aux) throws JSONException{
        JSONArray keys=aux;
            for(int i=0;i<aux.length();i++){
                switch (aux.getString(i)){
                    case "fechahora": keys.put(0, aux.get(i)); break;
                    case "ciPaciente": keys.put(1, aux.get(i)); break;
                    case "nombrePaciente": keys.put(2, aux.get(i)); break;
                    case "apellidoPaciente": keys.put(3, aux.get(i)); break;
                    case "numero": keys.put(4, aux.get(i)); break;
                    case "correo": keys.put(5, aux.get(i)); break;
                    case "fecha_nac": keys.put(6, aux.get(i)); break;
                    default : break;
                }
            
            }
        
        
        return keys;
    }
    
    public Object[][] crear_matriz(JSONArray json) throws JSONException{
        if (json==null)
            return null;       
        Object[][] aux=null;

        /* EJEMPLO DEL JSON DEL SERVIDOR
        [
        {"fecha_nac":"1995-12-12","nombrePaciente":"Pato","ciPaciente":8990721,"fechahora":"2015-12-08 21:23:54","apellidoPaciente":"Mendoza","numero":"0321221"},
        {"fecha_nac":null,"nombrePaciente":"Yolanda","ciPaciente":121442,"fechahora":"2015-12-19 12:00:00","apellidoPaciente":"Fernandez","numero":"0286961212"},
        {"fecha_nac":"1989-12-06","nombrePaciente":"Marilu","ciPaciente":12144908,"fechahora":"2015-12-24 12:00:00","apellidoPaciente":"Machado","numero":"04140944678"}
        ]        
        */
            this.fil=json.length();
            this.col=json.getJSONObject(0).length();
        aux=new Object[fil][col];
        JSONArray keys=json.getJSONObject(0).names();        
        keys=ordenar_json(keys);
        
        
        for(int i=0;i<fil;i++){
            for(int j=0;j<col;j++){
                switch(j){
                    case 0:aux[i][j]=crear_date(json.getJSONObject(i).get(keys.getString(j)));break;
                    default: aux[i][j]=json.getJSONObject(i).get(keys.getString(j));break;                
                }
                //System.out.print(aux[i][j]+" ");
            }                           
           //System.out.println();
        }
                                                                                
        return aux;
    }
    
    
    public void imprimir_datos(){
        System.out.println("filas "+this.fil+" columnas "+this.col);
        for(int i=0;i<this.fil;i++){
            for(int j=0;j<this.col;j++){
                System.out.print(this.tuplas[i][j]+" ");            
            }
            System.out.println();
        }
    
    }
    
    
    public static void main(String args[]) {
        Crearjsoncalendario pru=new Crearjsoncalendario(25620021);
        pru.Peticion_Citas(0);
        
    }
    
    
    
    
}
