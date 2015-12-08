/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nico
 */
public class Clase_resultset {
    
    
    public ResultSet rs = null;
    public Statement s = null;
    
    
    
    public int contar_filas(ResultSet rs){
        int i=0;
    
        try {            
            while(rs.next()){
            i++;  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clase_resultset.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {          
                rs.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Clase_resultset.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    return i;
    };
}
