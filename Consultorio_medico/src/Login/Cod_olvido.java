/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import JSON.JSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Nico
 */
public class Cod_olvido {
    String ci="",email="";
    
    
    Cod_olvido(String ci, String email) {
        this.ci=ci;
        this.email=email;
    }

    Boolean comprobar_correo() throws IOException, ClientProtocolException, JSONException {
        String[] titulo_datos={"ci","email"};
        String[] datos={this.ci,this.email};
        int numDatos=2;
        
        String url=  Ven_login.url;
        
        url=url+"comprobarcorreo/"+ci;
        
        HttpResponse response=JSON_agregar(titulo_datos, datos, numDatos, url);
        switch(response.toString()){
            case "true": return true;
            case "True": return true;
            case "false": return false;
            case "False": return false;    
        }
        
        return false;
    }
    
    
    
    
    
    
    
    
     public HttpResponse JSON_agregar(String[] titulo_datos, String[] datos,int numDatos, String url) throws ClientProtocolException, IOException, JSONException{
              
        HttpClient client = new DefaultHttpClient(); // cliente

        //HttpPost post = new HttpPost("http://169.254.105.188:8000/"+url);// aqui ponen el url que necesiten lo unico que tiene que cambiar es el /notes ponen el que quieran por ejemplo /crearusuario
        
        HttpPost post= new HttpPost(url); //con el servidor remoto

        JSONObject json = new JSONObject(); // crean el objeto json
        JSONObject json2 = new JSONObject(); 
        HttpResponse response=null;
        // ponen el nombre del campo en la bd con lo que quieren que lleve
                    
            try {
                for ( int i=0; i<numDatos; i++) {
                    json.put(titulo_datos[i],datos[i]);
                }
                
                
                System.out.println(json); // imprimo a ver si esta bien
                StringEntity se = new StringEntity( json.toString()); //convierte el json en este tipo para poder pasarlo
                 se.setContentType("application/json;charset=UTF-8"); // especificamos que es un json
                 post.setHeader("Accept", "application/json");              // acceptamos el json    
                post.setEntity(se); // lo agregamos al post
                response = client.execute(post); // hacemos la peticion

                System.out.println(response.toString()); // imprimo la respuesta

                // de aqui para abajo sirve para ver errores, 
                // por ejemplo s hay algun error con el servidor esto te manda la pagina de respuesta del servidor 
                // y te la escribe en la consola
                // pero en texto al final se puede ver el tipo de error y eso..
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); 
                String line = "";
                while ((line = rd.readLine()) != null) {
                 System.out.println(line);
                }
                                
                
                
            } catch (Exception ex) {
                Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        
            return response;
    }
    
    
    
}
