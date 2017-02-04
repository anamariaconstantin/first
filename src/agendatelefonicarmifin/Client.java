/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        FereatraPrincipala f = new FereatraPrincipala();

        f.setVisible(true);
        f.pack();
        try {
      //Get reference to rmi registry server
      Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
 
      //Lookup server object
      Remote rp =    registry.lookup("Interface");
        }catch (Exception e) {
      System.out.println(e);
    }
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FereatraPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FereatraPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FereatraPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FereatraPrincipala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
        

    }
        public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
                new FereatraPrincipala().setVisible(true);

            }

}
