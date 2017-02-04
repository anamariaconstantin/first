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
import java.util.*;

public class Replica extends Process {

    ProcessId[] leaders;
    int slot_num = 1;
    Map< Integer /* slot number */, Comanda> proposals = new HashMap< Integer, Comanda>();
    Map< Integer /* slot number */, Comanda> decisions = new HashMap< Integer, Comanda>();

    public Replica(EnvMain env, ProcessId me, ProcessId[] leaders) {
        this.env = env;
        this.me = me;
        this.leaders = leaders;
        env.addProc(me, this);
    }

    void propose(Comanda c) {
        if (!decisions.containsValue(c)) {
            for (int s = 1;; s++) {
                if (!proposals.containsKey(s) && !decisions.containsKey(s)) {
                    proposals.put(s, c);
                    for (ProcessId ldr : leaders) {
                        sendMessage(ldr, new ProposeMessage(me, s, c));
                    }
                    break;
                }
            }
        }
    }

    void perform(Comanda c) {
        for (int s = 1; s < slot_num; s++) {
            if (c.equals(decisions.get(s))) {
                slot_num++;
                return;
            }
        }
        System.out.println("" + me + " : executa " + c);
        slot_num++;
    }

    public void body() {
        //System.out.println("Eu sunt replica: " + me);
        System.out.println( me);
        for (;;) {
            PaxosMessage msg = getNextMessage();
            if (msg instanceof RequestMessage) {
                RequestMessage m = (RequestMessage) msg;
                propose(m.command);
            } else if (msg instanceof DecisionMessage) {
                DecisionMessage m = (DecisionMessage) msg;
                decisions.put(m.slot_number, m.command);
                for (;;) {
                    Comanda c = decisions.get(slot_num);
                    if (c == null) {
                        break;
                    }
                    Comanda c2 = proposals.get(slot_num);
                    if (c2 != null && !c2.equals(c)) {
                        propose(c2);
                    }
                    perform(c);
                }
            } else {
                System.err.println(" Replica : mesaj err ");
            }
        }
    }
}
