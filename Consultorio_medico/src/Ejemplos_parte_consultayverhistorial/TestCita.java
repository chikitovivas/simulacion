package Ejemplos_parte_consultayverhistorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Timestamp;
import java.util.Date;
import org.apache.http.HttpResponse;
import static org.apache.http.HttpVersion.HTTP;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;
//Ejemplo de como hacer un POST lean los comentarios para que entiendan
// Tienen que importar todas estas librerias las puse en el drive
// para importarlas le dan a la carpeta librarues de su proyecto
// luego le dan a add librery le dan a create 
// Primero ingregaremos las librerias http 
// Le ponen HTTP asi en mayuscula de nombre le dan a ok y luego le dan a ADD Jar
// bucan la carpeta que les mande commons y agregan todos esos archivos comoms que salen ahi
// luego aceptan la crearon les saldra en la lista y le dan a add y listo
// despues agrega la libreria de json agarran y hacen lo mismo le ponen json de nombre
// luego buscan el archivo jar en la carpeta json lo agregan y listo..


public class TestCita {
    
    // Ejemplo de como hacer un POST
    
    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
  HttpClient client = new DefaultHttpClient(); // cliente
  
 // HttpPost post = new HttpPost("http://miconsultoriocal.no-ip.org:8000/hacerCita");// aqui ponen el url que necesiten lo unico que tiene que cambiar es el /notes ponen el que quieran por ejemplo /crearusuario
 
  HttpPost post = new HttpPost("http://miconsultoriocal.no-ip.org:8000/historial");
  
  JSONObject json = new JSONObject(); // crean el objeto json
  
  // ponen el nombre del campo en la bd con lo que quieren que lleve
 
   json.put("ci","121442");//Esta es la cedula del paciente 
   
   //Los datos del paciente que se pueden editar
   json.put("fechanac","1800-12-12");
   json.put("sangre","A+a");
   json.put("dire","Al lado");
   json.put("correo","yolandaLamacanda@gmail.com");
   
   json.put("numeroCita","2");
   json.put("porque","Dolor humbral");
   json.put("diagnostico","Falta de medicamento para la Locura");
   json.put("tratamiento","Dos veces al dia tomar prozac");


  
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
 }
}
