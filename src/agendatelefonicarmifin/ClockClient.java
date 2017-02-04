package agendatelefonicarmifin;

/**
 *
 * @author ana-maria.constantin
 */
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author student
 */
public class ClockClient {

    /**
     * @param args the command line arguments
     */
    
    //algoritmul lui Cristian 
public static void main(String[] args) throws IOException {
        
        String port,hostName;
        BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in));
//        System.out.println("Dati portul");
       
        int portNumber = 1098;
        System.out.println("Dati hostname-ul");
        hostName=stdIn.readLine();
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            ) {
            String userInput;
            System.out.println("Clientul este on!");
            
                long T0;
                long serverTime;
                long T1;
                long finalTime;                
                out.println(T0=System.currentTimeMillis());
                serverTime = Long.parseLong(in.readLine());
                T1 =System.currentTimeMillis();
                finalTime =  serverTime + (T1-T0)/2;
                DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
                System.out.println("Timp client : " + formatter.format(new Date(T1)));
                System.out.println("Timp server : " + formatter.format(new Date(serverTime)));
                System.out.println("Timpul clientului dupa reset: " + formatter.format(new Date(finalTime)));
                out.println("Exit");
                
               
           
        } catch (UnknownHostException e) {
            System.err.println("Nu se cunoaste hostul " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Err la citire! " +
                hostName);
            System.exit(1);
        } 
    }

}
