/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_cita;
import JSON.JSON;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
/**
 *
 * @author Pat
 */
public class Cod_registrocita {
    
    Cod_registrocita(String[] datos) throws IOException, ClientProtocolException, JSONException{
        String titulo_datos[] = new String [4];
            
            titulo_datos[0]= "ci";
            titulo_datos[1]= "nombre";                     
            titulo_datos[2]= "apellido";
            titulo_datos[3]= "telefono";

            JSON.JSON_agregar(titulo_datos, datos, 4, "http://miconsultoriocal.no-ip.org:8000/hacercita");
    
    }
    
    
}
