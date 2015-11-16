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
public class ConexionBD {
    
    public Connection connection = null;
    public ResultSet rs = null;
    public Statement s = null;
    
    public Connection Conexion(String bd,String user,String pass)
    {
        
        if (connection != null) {
            return null;
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://localhost/"+bd;
            //String BD= bd;
            String usuarioBD=user;
            String passwordBD=pass;
            connection= DriverManager.getConnection(servidor,usuarioBD,passwordBD);             
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            connection=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            connection=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            connection=null;
        }
        finally
        {
            return connection;
        }
    }
    
    
    public void reiniciar_statement(){
        try {
            s=connection.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
          
        }    
    }
    
    
    public int select_user(String nick,String pass){
        try {
            s=connection.createStatement();
            rs=s.executeQuery("select buscar_usuarios('"+nick+"','"+pass+"');");
            rs.next();
            System.out.println(rs.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
}
