/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_cita;
import JSON.JSON;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
/**
 *
 * @author Pat
 */
public class Cod_registrocita {
    
    public Cod_registrocita(String[] datos) {
         String titulo_datos[] = new String [6];
        
            titulo_datos[0]= "ciPaciente";
            titulo_datos[1]= "nombrePaciente";                     
            titulo_datos[2]= "apellidoPaciente";
            titulo_datos[3]= "numero";            
            titulo_datos[4]= "correo";
            titulo_datos[5]= "ciMedico";
            titulo_datos[6]= "fechahora";

            
        try {
            //Datos para el JSON

            //JSON.JSON_agregar(titulo_datos, datos, 6, "http://miconsultoriocal.no-ip.org:8000/hacercita");
            JSON.JSON_agregar(titulo_datos, datos, 7, "hacerCita");
        } catch (IOException ex) {
            Logger.getLogger(Cod_registrocita.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Cod_registrocita.class.getName()).log(Level.SEVERE, null, ex);
        }


    
            
    }
    
    
}
