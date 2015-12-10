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
public class PruebaJsonNico {
        
    PruebaJsonNico(){
    
    
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

        
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);
            
             JSONArray json = new JSONArray(content);      //JSON                       
             crear_matriz(json);
             
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
                    //System.out.println("primer keys");
                    //System.out.println(keys);
        Object jaux=keys.get(0);// guardo fecha nac
        keys.put(0, keys.get(4));// muevo fecha hora       
        keys.put(4, keys.get(6));// //muevo numero
        keys.put(6, jaux);// muevo fecha nac del aux        
        jaux=keys.get(1); //guardo nombre paciente                
        keys.put(1, keys.get(2)); //muevo cedula
        keys.put(2, jaux);//muevo nombre paciente del aux
        jaux=keys.get(5);//guardo apellido
        keys.put(5, keys.get(3)); //muevo correo
        keys.put(3, jaux);// muevo apellido paciente del aux
        
                    //System.out.println("segundo keys");
                    //System.out.println(keys);
        
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
        int fil=json.length()
           ,col=json.getJSONObject(0).length();
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
    
    
    
    
    
    public static void main(String args[]) {
        PruebaJsonNico pru=new PruebaJsonNico();
        pru.Peticion_Citas(0);
        
    }
    
    
    
    
}
