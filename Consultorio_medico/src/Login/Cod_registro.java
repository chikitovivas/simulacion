/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import JSON.JSON;
import java.io.IOException;
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
class Cod_registro {
    String ci,nom,ape,dir,tlf,tlf2,mail,mail2;
    String hini,hfin;

    public Cod_registro(String ci, String nom, String ape, String dir, String tlf, String tlf2, String mail, String mail2,String hini,String hfin) {
        this.ci = ci;
        this.nom = nom;
        this.ape = ape;
        this.dir = dir;
        this.tlf = tlf;
        this.tlf2 = tlf2;
        this.mail = mail;
        this.mail2 = mail2;
        this.hini=hini;
        this.hfin=hfin;
    }

   public void enviar_registro() {
        try {
            String[] titulo_datos={"ci","nombre","apellido","direccion",
                                    "telefono","telefono2","email","email2",
                                    "horaini","horafin"};
            String[] datos={this.ci,this.nom,this.ape,this.dir,
                            this.tlf,this.tlf2,this.mail,this.mail2,
                            this.hini,this.hfin};
            int numDatos=datos.length;     
            
            String url=Ven_login.url+"registro_usuario";
            
            this.JSON_agregar(titulo_datos, datos, numDatos, url);
            
        } catch (IOException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    private void JSON_agregar(String[] titulo_datos, String[] datos,int numDatos, String url) throws ClientProtocolException, IOException, JSONException{
              
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
                
                /*
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); 
                String line = "";
                while ((line = rd.readLine()) != null) {
                 System.out.println(line);
                }
                  */              
                
                
            } catch (Exception ex) {
                Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);               
            }
        
            
    }
    
    
    
    
}
