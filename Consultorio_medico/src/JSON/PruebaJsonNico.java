/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import Calendario_Consultorio.Ven_calendario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

/**
 *
 * @author Nico
 */
public class PruebaJsonNico {
        
    PruebaJsonNico(){
    
    
    }
    
    public void Peticion_nico(int ci){
    
        // para prueba 
        ci=25620021;
        
        HttpClient client = new DefaultHttpClient();
        int id=1;
        String dirLAN="169.254.105.188";// con router nico NO WIFI
          //HttpGet get = new HttpGet("http://miconsultoriocal.no-ip.org:8000/cita/"+ci);
          //HttpGet get = new HttpGet("http://localhost:8000/cita");   //para pedir toda la tabla cita
          HttpGet get = new HttpGet("http://"+dirLAN+":8000/cita/"+ci);

        
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);

            System.out.println(response.toString());
                System.out.println();System.out.println();
             System.out.println(content);
             JSONArray json = new JSONArray(content);
                System.out.println();System.out.println();
             System.out.println(json);
          /*   
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
             System.out.println(line);
            }
            */
                      
            
             
             //PROBANDO PARA TRAER CADA TUPLA
             System.out.println();System.out.println();
             System.out.println(json.getJSONObject(0));
             System.out.println(json.getJSONObject(0).get("nombrePaciente")); //para traer atributos
             System.out.println(json.length());
             
             
             
        } catch (Exception ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
      
    }
    
    
    public static void main(String args[]) {
        PruebaJsonNico pru=new PruebaJsonNico();
        pru.Peticion_nico(0);
        
    }
    
    
    
    
}
