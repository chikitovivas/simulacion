/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encuesta;

/**
 *
 * @author Carlos
 */
    

public class comboItem {
    
    String identifier="nada";
    String[] elements = null;
    
    
        public comboItem(String[] elemn, String ident) {
            
            identifier=ident;
            elements = new String [elemn.length];
            
            for(int zi=0; zi<elemn.length; zi++) {
                elements[zi]=elemn[zi];
            }
        }

    @Override
    public String toString()
    {
        return identifier;
    }
        
}
