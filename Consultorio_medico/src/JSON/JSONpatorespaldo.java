package JSON;

import Login.Ven_login;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
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
public class JSONpatorespaldo {
    
    //public static JSONArray[] solicitar_pato(String ci) throws IOException, JSONException{
    public static Object[] solicitar_pato(String ci) throws IOException, JSONException{
            
            HttpClient client = new DefaultHttpClient();
            
            //Ejemplo para recibir respuestas con mensaje adelante

             HttpGet get = new HttpGet(Ven_login.url+"historial/"+ci);


            HttpResponse response = client.execute(get);
            HttpEntity entity= response.getEntity();
            String content = EntityUtils.toString(entity);

            System.out.println(response.toString());
             //Imprimo lo que me traigo
             System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaa:"+content);

             //Agarro la primera posicion del json de respuesta que es la de mensaje
             JSONObject json = new JSONObject(content);
             // ASi se si el mensaje es si o no..
             System.out.println(json.get("mensaje").toString());

             JSONArray[] arreglo=null;
             Object[] arr={null,null};
             switch(json.get("mensaje").toString()){
                 case "no":System.out.println("no esta registrado"); return null;
                 case "historia": 
                          arreglo[0]=new JSONArray();//ASIGNANDO CONSULTAS
                          arr[0]=json.get("datos1");
                          arreglo[0]=(JSONArray)arr[0];
                          
                          arreglo[1]=new JSONArray();//ASIGNANDO CITAS
                          arr[1]=json.get("datos2");
                          arreglo[1]=(JSONArray)arr[1];
                      
                  break;
                 case "cita":
                      arreglo[1]=new JSONArray();
                      arr[1]=json.get("datos2");
                      arreglo[1]=(JSONArray)arr[1];
                      break;
                 default:     break;
             }

             
             
            

             /*
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
          */



          /*   
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
             System.out.println(line);
            }
            */
    
          
          return diseccionar_pato(arreglo);
          
          
          //return arreglo;
    }//FIN

    private static Object[] diseccionar_pato(JSONArray[] arreglo) throws JSONException {
        // POSICION 0 TIENE CONSULTAS POSICION 1 TIENE CITAS
        JSONArray consulta=arreglo[0]
                ,citas=arreglo[1];        
        String[]titulo_pacientes = {"ciPaciente","nombrePaciente","apellidoPaciente","tlfpaciente","fecha_nac","tipoSangre","direPaciente","correo"};
        Object[] mierda={"","","","","","","","",null,null};
        
        if((consulta==null) && (citas==null))
             return null;
        Object[][] consul=null,cit=null;
        
        if(consulta!=null){
            mierda[0]=consulta.getJSONObject(0).get("ciPaciente").toString();
            mierda[1]=consulta.getJSONObject(0).get("nombrePaciente").toString();
            mierda[2]=consulta.getJSONObject(0).get("apellidoPaciente").toString();
            mierda[3]=consulta.getJSONObject(0).get("tlfpaciente").toString();
            mierda[4]=consulta.getJSONObject(0).get("fecha_nac").toString();
            mierda[5]=consulta.getJSONObject(0).get("tipoSangre").toString();
            mierda[6]=consulta.getJSONObject(0).get("direPaciente").toString();                    
            mierda[7]=consulta.getJSONObject(0).get("correo").toString();                    
            
            
           consul=new Object[consulta.length()][6];
           for(int i=0;i<consulta.length();i++){               
                    consul[i][0]=consulta.getJSONObject(i).getJSONObject("idCita");
                    consul[i][1]=consulta.getJSONObject(i).getJSONObject("fecha");
                    consul[i][2]=consulta.getJSONObject(i).getJSONObject("hora");
                    consul[i][3]=consulta.getJSONObject(i).getJSONObject("motivo");
                    consul[i][4]=consulta.getJSONObject(i).getJSONObject("diagnostico");
                    consul[i][5]=consulta.getJSONObject(i).getJSONObject("tratamiento");
                    
           }
            
            
        }else
        if(citas!=null){
            mierda[0]=citas.getJSONObject(0).get("ciPaciente").toString();
            mierda[1]=citas.getJSONObject(0).get("nombrePaciente").toString();
            mierda[2]=citas.getJSONObject(0).get("apellidoPaciente").toString();
            mierda[3]=citas.getJSONObject(0).get("tlfpaciente").toString();
            mierda[4]=citas.getJSONObject(0).get("fecha_nac").toString();
            mierda[5]=citas.getJSONObject(0).get("tipoSangre").toString();
            mierda[6]=citas.getJSONObject(0).get("direPaciente").toString(); 
            
            cit=new Object[citas.length()][6];
            for(int i=0;i<consulta.length();i++){               
                    cit[i][0]=citas.getJSONObject(i).getJSONObject("idCita");
                    cit[i][1]=citas.getJSONObject(i).getJSONObject("fecha");
                    cit[i][2]=citas.getJSONObject(i).getJSONObject("hora");
                    cit[i][3]=citas.getJSONObject(i).getJSONObject("motivo");
                    cit[i][4]=citas.getJSONObject(i).getJSONObject("diagnostico");
                    cit[i][5]=citas.getJSONObject(i).getJSONObject("tratamiento");
                    
            }

            }
        
        
        Object[] supermierda={mierda,consul,cit};
        
        return supermierda;
    }
    
    
    
    
    
}
