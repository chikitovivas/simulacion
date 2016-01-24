/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import JSON.LoginJSON;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author Nico
 */
class Cod_registro {
    String ci,nom,pass,mail,tipo;
    String hini,hfin;

    public Cod_registro(String ci, String nom, String ape, String pass, String mail,String hini,String hfin) {
        this.ci = ci;
        
        this.nom = nom+" "+ape;
        
        this.pass = pass;

        this.mail = mail;

        this.hini=hini;
        this.hfin=hfin;
    }

    Cod_registro(String ci, String nom, String ape, String pass, String mail,String tipo,String hini,String hfin) {
        this.ci = ci;
        
        this.nom = nom+" "+ape;
        
        this.pass = pass;

        this.mail = mail;
        this.tipo=tipo;
        
        this.hini=hini;
        this.hfin=hfin;
    }
    
    public void lanzar_registro(){
        switch(this.tipo){
            case "medico": this.enviar_registro_medicos();break;
            case "asistente": this.enviar_registro_medicos();break;
            default: return;
        }        
        
    }
    
    

   public void enviar_registro_medicos() {
        try {
            String[] titulo_datos={"ci","nombre","password",
                                    "email",
                                    "horaini","horafin"};
            String[] datos={this.ci,this.nom,this.pass,
                            this.mail,
                            this.hini,this.hfin};
            int numDatos=datos.length;     
            
            String url=Ven_login.url+"registrarM/";
            System.out.println(url);
             LoginJSON ljson=new LoginJSON();
             
             //ljson.JSON_agregar(titulo_datos, datos, numDatos, url);
             
             
             
            System.out.println(ljson.JSON_agregar(titulo_datos, datos, numDatos, url));
            
        } catch (IOException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                   
    
    
    
    
}
