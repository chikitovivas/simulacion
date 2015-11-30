/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario_Consultorio;

import consultorio_medico.Proyecto;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class Cod_calendario {
    
    
    
    
    
    
    
    
   
    
    /**
     * procesa los resultados de la base de datos en un arreglo ordenado
     * @param x tabla resultado con las fechas a procesar
     * @return arreglo de fechas en las cuales hay citas
     */
    Object[] set_puntos(ResultSet x){
        Object aux[]=null;
        if(x==null)
          return null;
        
        aux= new Object[Proyecto.con.contar_filas(x)];
        try {
            x.next();
            for(int i=0; x.next();i++){
                aux[i]=x.getObject(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cod_calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    return aux;
    }
    
    
    
    
}
