/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paxos;

/**
 *
 * @author ana-maria
 */
/*
Paxos implică adăugarea secvențială de înregistrări la log( inreg. A la index 1, 
inreg. B la index 2,etc), iar toate nodurile participă în algoritmul Paxos 
vor sti că fiecare înregistrare a fost adăugată si indexul actualizat.

Roluri : Client- proces care realizeaza cererea

Acceptor: Orice mesaj trimis catre un Acceptor trebuie transferat Cvorumului de acceptori.

Propunator: Acționează în numele clientului. Incearcă să formeze o majoritate a Acceptorilor.

Leader: Un caz particular de Propunător Multe procese se pot ”auevalua” drept Lideri dar orice Lider trebuie confirmat de Cvorum.

Discipol(Learner) asigură replicarea.


/*




*/
import java.util.*;

public class EnvMain {

    Map< ProcessId, Process> procs = new HashMap< ProcessId, Process>();
    public final static int nAcceptors = 4, nReplicas = 3, nLeaders = 2, nRequests = 5;

    synchronized void sendMessage(ProcessId dst, PaxosMessage msg) {
        Process p = procs.get(dst);
        if (p != null) {
            p.deliver(msg);
        }
    }

    synchronized void addProc(ProcessId pid, Process proc) {
        procs.put(pid, proc);
        proc.start();
    }

    synchronized void removeProc(ProcessId pid) {
        procs.remove(pid);
    }

    void run(String[] args) {
        ProcessId[] acceptors = new ProcessId[nAcceptors];
        ProcessId[] replicas = new ProcessId[nReplicas];
        ProcessId[] leaders = new ProcessId[nLeaders];
        for (int i = 0; i < nAcceptors; i++) {
            acceptors[i] = new ProcessId(" acceptor id : " + i);
            Acceptor acc = new Acceptor(this, acceptors[i]);
        }
        for (int i = 0; i < nReplicas; i++) {
            replicas[i] = new ProcessId(" replica id : " + i);
            Replica repl = new Replica(this, replicas[i], leaders);
        }
        for (int i = 0; i < nLeaders; i++) {
            leaders[i] = new ProcessId(" leader id:" + i);
            Leader leader = new Leader(this, leaders[i], acceptors, replicas);
        }
        for (int i = 1; i < nRequests; i++) {
            ProcessId pid = new ProcessId(" client id:" + i);
            for (int r = 0; r < nReplicas; r++) {
                sendMessage(replicas[r],
                        new RequestMessage(pid, new Comanda(pid, 0, " numar operatie request " + i)));
                //0- request id.
                //pid - ProcessId client
                //operatia i -nRequests
            }
        }
    }

    public static void main(String[] args) {
        new EnvMain().run(args);
    }
}
