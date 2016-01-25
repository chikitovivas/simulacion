package Ejemplos_parte_consultayverhistorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class TestLeer {
    public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {
  HttpClient client = new DefaultHttpClient();
  int id=1;
  
  
  //Ejemplo para recibir respuestas con mensaje adelante
  
  HttpGet get = new HttpGet("http://miconsultoriocal.no-ip.org:8000/historial/8990721");
   // HttpGet get = new HttpGet("http://localhost:8000/usuario");
  
 HttpResponse response = client.execute(get);
  HttpEntity entity= response.getEntity();
  String content = EntityUtils.toString(entity);
  //12144908
  //89
  //8990721
   System.out.println(response.toString());
   //Imprimo lo que me traigo
   System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaa:"+content);
   
   //Agarro la primera posicion del json de respuesta que es la de mensaje
   JSONObject json = new JSONObject(content);
   // ASi se si el mensaje es si o no..
   System.out.println(json.get("mensaje").toString());
   
   if(json.get("mensaje").toString().equals("no")){
   // Codigo de que no este registrado el cliente
   System.out.println("no esta registrado");
   }
   
    if(json.get("mensaje").toString().equals("historial")){
   // codigo de cuando el cliente si ha ido a consulta
    JSONArray arreglo=new JSONArray();
   Object arr=json.get("datos1");
   arreglo=(JSONArray)arr;
   //Lo imprimo para verlo
   System.out.println(arreglo);
   }
    
        if(json.get("mensaje").toString().equals("cita")){
   // codigo de cuando el cliente no ha ido a consulta pero tiene citas para ir a consulta
    JSONArray arreglo=new JSONArray();
   Object arr=json.get("datos2");
   arreglo=(JSONArray)arr;
   //Lo imprimo para verlo
   System.out.println(arreglo);
   }


  
   
/*   
  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  String line = "";
  while ((line = rd.readLine()) != null) {
   System.out.println(line);
  }
  */
 }
}
