/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ana-maria
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ClientBackup {

    public static void main(String[] args) {

        FereatraPrincipala f = new FereatraPrincipala();

        f.setVisible(true);
        f.pack();
        try {
            //Get reference to rmi registry server
            String ip = generateServerIP();
            System.out.println("Noul ip random al serverului de backup  " + ip);

            // Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            Registry registry = LocateRegistry.getRegistry(ip, 1099);
            //Lookup server object
            Remote rp = registry.lookup("Interface");
        } catch (Exception e) {
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

    public static String generateServerIP() {
        ArrayList<String> al = new ArrayList<>();
        al.add("172.62.22.103");
        al.add("172.62.22.123");
        al.add("172.62.22.15");
        al.add("172.62.22.187");
        al.add("172.62.22.110");

        int ip = new Random().nextInt(al.size());
        return al.get(ip);
    }
}
