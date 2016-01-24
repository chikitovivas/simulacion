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
import org.apache.http.util.EntityUtils;
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
    
     
    
    public int comprobar_user() throws IOException, JSONException {
        String[] titulo_datos={"ci","password"};
        String[] datos={this.username,this.password};
        int numDatos=2;
        
        String url=  Ven_login.url;
        
        //url=url+"login/"+this.username;
        
       // url="http://miconsultoriocal.no-ip.org:8000/"; //mientras tanto
        
        url=url+"login/";
        System.out.println(url);
        LoginJSON ljson=new LoginJSON();
        
        HttpResponse response=ljson.JSON_agregar(titulo_datos, datos, numDatos, url);
        String content=ljson.JSON_respuesta(response);
        
        
        
        System.out.println(content);
        
        
        switch(content){
            case "{\"mensaje\":\"secretaria\"}": return 1;
            case "{\"mensaje\":\"medico\"}": return 0;
            case "{\"mensaje\":\"no\"}": return 2;  
            
        }
        
        return 3;
    }
    
    
    
   
    
    
    
    
}
