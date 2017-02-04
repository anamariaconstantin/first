package Algoritmi;

 //Ring Election algorithm
/**
 *
 * @author ana-maria
 */
/*

vezi desen documentatie!
Pas1
Vom incepe cu 6 procese conectate intr-un inel logic. 
Procesul 6 este lider deoarece are cel mai mere numar.

Pas2:
Procesul 6 a esuat.

Pas3:
Procesul 3 observa ca 6 nu raspunde asa ca incepe alegerea trimitand un mesajce contine id 
sau catre urmatorul nod din inel.


Pas4: 
Procesul 5 trimite mai departe mesajul la care a adaugat propriul id. La fel vor proceda si procesele :0,1,4.
Pas5:
 
Atunci cand procesul 3 primeste mesajul inapoi stie ca acesta a parcurs tot inelul si alege cel mai mare id din lista, transmitand mesajul mai departe,
la fel procedand si celelalte noduri.*/
 
import java.util.Scanner; 

class Process { 

    int procesId; 
    boolean activ; 

    public Process(int processId) { 
        this.procesId = processId; 
        activ = true; 
    } 
} 

public class RingElection { 
     
    private Scanner in; 
    private Process[] proces; 
    private int nrProcese; 

    public RingElection() { 
        System.out.println("\n\t\t----> Ring Algoritm <------\n"); 
        in = new Scanner(System.in); 
    } 

    public void getInput() { 
        System.out.println("Dati numarul de procese din inel: "); 
        nrProcese = in.nextInt(); 
        proces = new Process[nrProcese]; 

        for (int i = 0; i < nrProcese; i++) { 
            System.out.print("Dati Id procesului lui p" + i + ": "); 
            int pid = in.nextInt(); 
            initializeProcess(i, pid); 
        } 
        sortare(); 
        putOutput(); 
    } 

    private void initializeProcess(int i, int pid) { 
        proces[i] = new Process(pid); 
    } 

    public void conductElection() { 
                 
        try{ 
            Thread.sleep(2000); 
        }catch(Exception e ){ 
            System.out.println(e); 
        } 
        System.out.println("procesul "+ proces[getMaxim()].procesId +" a esuat"); 
        proces[nrProcese-1].activ = false; 
         
        while(true){ 
            System.out.print("Conduct Election?\n da sau exit: "); 
            String choice = in.next(); 
            if("yes".equals(choice) || "da".equals(choice) || "Da".equals(choice) || "DA".equals(choice)){ 
                System.out.println("Election initiata de catre : "); 
                int initiatorProcess = in.nextInt(); 
                for(int i = 0; i< nrProcese; i++){ 
                    if(proces[i].procesId == initiatorProcess){ 
                        initiatorProcess = i; 
                        break; 
                    } 
                } 
                int prev = initiatorProcess; 
                int next = prev+1; 
                
                while(true){ 
                    if(proces[next].activ) { 
                        System.out.println("Procesul "+ proces[prev].procesId +" a transmis mesajul procesului "+proces[next].procesId ); 
                        prev = next; 
                    } 
                    next = (next+1) % nrProcese; 
                     
                    if(next == initiatorProcess) { 
                        break; 
                    } 
                } 
                System.out.println("Procesul "+ proces[getMaxim()].procesId +" a devenit coordonator "); 
            } else { 
                System.exit(0);             
            } 
        } 
    } 
     
    public void putOutput(){ 
        System.out.println(" Procesele din inel : ");    
        for(int i = 0; i < nrProcese; i++){ 
            System.out.print(proces[i].procesId +", activ: "+ proces[i].activ); 
            if(i == getMaxim()){ 
                System.out.print(", Coordonator\n"); 
            }else { 
                System.out.print("\n"); 
            } 
             
        } 
    } 
     
    private void sortare() { 
        for (int i = 0; i < nrProcese - 1; i++) { 
            for (int j = 0; j < (nrProcese - i) -1; j++) { 
                if (proces[j].procesId > proces[j + 1].procesId) { 
                    int temp = proces[j].procesId; 
                    proces[j].procesId = proces[j + 1].procesId; 
                    proces[j + 1].procesId = temp; 

                } 
            } 
        } 
    } 
     
    private int getMaxim(){ 
        int max = 0, indexMaxi = 0; 
        for(int i = 0; i < nrProcese; i++){ 
            if(proces[i].activ && max <= proces[i].procesId ) { 
                max = proces[i].procesId; 
                indexMaxi = i; 
            } 
        } 
        return indexMaxi; 
    } 

    public static void main(String arg[]) { 
       
        RingElection ringElection = new RingElection(); 
        ringElection.getInput(); 
        ringElection.conductElection(); 
     
    } 
} 
     
