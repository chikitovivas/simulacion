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
             LoginJSON ljson=new LoginJSON();
             
            ljson.JSON_agregar(titulo_datos, datos, numDatos, url);
            
        } catch (IOException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Cod_registro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                   
    
    
    
    
}
