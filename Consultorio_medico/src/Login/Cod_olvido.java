/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import JSON.JSON;
import JSON.LoginJSON;
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
        LoginJSON ljson=new LoginJSON();
        
        HttpResponse response=ljson.JSON_agregar(titulo_datos, datos, numDatos, url);
        switch(response.toString()){
            case "true": return true;
            case "True": return true;
            case "false": return false;
            case "False": return false;    
        }
        
        return false;
    }                      
            
}
