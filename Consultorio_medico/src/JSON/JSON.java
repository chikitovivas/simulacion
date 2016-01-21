package JSON;

import Login.Ven_login;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
//Ejemplo de como hacer un POST lean los comentarios para que entiendan
// Tienen que importar todas estas librerias las puse en el drive
// para importarlas le dan a la carpeta librarues de su proyecto
// Primero ingregaremos las librerias http 
// Le ponen HTTP asi en mayuscula de nombre le dan a ok y luego le dan a ADD Jar
// bucan la carpeta que les mande commons y agregan todos esos archivos comoms que salen ahi
// luego aceptan la crearon les saldra en la lista y le dan a add y listo
// despues agrega la libreria de json agarran y hacen lo mismo le ponen json de nombre
// luego buscan el archivo jar en la carpeta json lo agregan y listo..


public class JSON {
    
    // Ejemplo de como hacer un POST
    
        
    public static void  JSON_agregar(String[] titulo_datos, String[] datos,int numDatos, String url) throws ClientProtocolException, IOException, JSONException{
              
        HttpClient client = new DefaultHttpClient(); // cliente

        //HttpPost post = new HttpPost("http://169.254.105.188:8000/"+url);// aqui ponen el url que necesiten lo unico que tiene que cambiar es el /notes ponen el que quieran por ejemplo /crearusuario
        
        HttpPost post= new HttpPost(url); //con el servidor remoto

        JSONObject json = new JSONObject(); // crean el objeto json
        JSONObject json2 = new JSONObject(); 

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
                HttpResponse response = client.execute(post); // hacemos la peticion

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
            }
        

    }
    
    
    
    public static void  JSON_view(String[] titulo_datos, String[] datos,int numDatos, String url)throws ClientProtocolException, IOException, JSONException {
        
        HttpClient client = new DefaultHttpClient();
        int id=1;
       // HttpGet get = new HttpGet("http://miconsultoriocal.no-ip.org:8000/notes");
          HttpGet get = new HttpGet("http://localhost:8000/usuario");

        
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);

            System.out.println(response.toString());

             System.out.println(content);
             JSONArray json = new JSONArray(content);

             System.out.println(json);
          /*   
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
             System.out.println(line);
            }
            */
                      
            
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
      
    }

 
       
    
    public static JSONArray JSON_view_general (int ci,String url){
        JSONArray json=null;
        HttpClient client = new DefaultHttpClient();
              
        HttpGet get = new HttpGet(Ven_login.url+url);
        
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);

            System.out.println(response.toString());

             System.out.println(content);
             json = new JSONArray(content);
             
             System.out.println(json);
                                                            
        } catch (IOException | JSONException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return json;
    }

  
    
    

    





}
