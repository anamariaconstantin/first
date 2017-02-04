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

public class Commander extends Process {

    ProcessId leader;
    ProcessId[] acceptors, replicas;
    BallotNumber ballot_number;
    int slot_number;
    Comanda command;

    public Commander(EnvMain env, ProcessId me, ProcessId leader, ProcessId[] acceptors,
            ProcessId[] replicas, BallotNumber ballot_number, int slot_number, Comanda command) {
        this.env = env;
        this.me = me;
        this.acceptors = acceptors;
        this.replicas = replicas;
        this.leader = leader;
        this.ballot_number = ballot_number;
        this.slot_number = slot_number;
        this.command = command;
        env.addProc(me, this);
    }

    public void body() {
        P2aMessage m2 = new P2aMessage(me, ballot_number, slot_number, command);
        Set< ProcessId> waitfor = new HashSet< ProcessId>();
        for (ProcessId a : acceptors) {
            sendMessage(a, m2);
            waitfor.add(a);
        }
        while (2 * waitfor.size() >= acceptors.length) {
            PaxosMessage msg = getNextMessage();
            if (msg instanceof P2bMessage) {
                P2bMessage m = (P2bMessage) msg;
                if (ballot_number.equals(m.ballot_number)) {
                    if (waitfor.contains(m.src)) {
                        waitfor.remove(m.src);
                    }
                } else {
                    sendMessage(leader, new PreemptedMessage(me, m.ballot_number));
                    return;
                }
            }
        }
        for (ProcessId r : replicas) {
            sendMessage(r, new DecisionMessage(me, slot_number, command));
        }
    }
}
