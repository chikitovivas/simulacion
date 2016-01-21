/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

//import consultorio_medico.Proyecto;

import JSON.LoginJSON;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.json.JSONException;



/**
 *
 * @author Nico
 */
public class Cod_login {
    public String username,password;   
    
    Cod_login(String nick, String pass) {        
        username=nick;
        password=pass;        
    }
    
     
    
    public Boolean comprobar_user() throws IOException, JSONException {
        String[] titulo_datos={"ci","pass"};
        String[] datos={this.username,this.password};
        int numDatos=2;
        
        String url=  Ven_login.url;
        
        url=url+"iniciarsesion/"+this.username;
        
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
