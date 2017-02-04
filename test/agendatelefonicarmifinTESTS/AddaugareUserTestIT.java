/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifinTESTS;

import agendatelefonicarmifin.Abonat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ana-maria.constantin
 */
public class AddaugareUserTestIT {
    
    public AddaugareUserTestIT() {
    }
  
   
    @Test
    public void testAbonatCnpSucces() {
        Abonat abonat = new Abonat("Dana","Maria", "2940906078956", 'F');
        
        String cnp = abonat.getCnp();
        assertEquals(13,cnp.length());
      
    }
    
    @Test
    public void testAbonatCnpFail() {
        Abonat abonat = new Abonat("Dana","Maria", "29409060789565", 'F');
        
        String cnp = abonat.getCnp();
        assertFalse( cnp.length()==13);
      
    }
}
