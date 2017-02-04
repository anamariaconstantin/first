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
public abstract class Process extends Thread {

    ProcessId me;
    Queue< PaxosMessage> inbox = new Queue< PaxosMessage>();
    EnvMain env;

    abstract void body();

    public void run() {
        body();
        env.removeProc(me);
    }

    PaxosMessage getNextMessage() {
        return inbox.bdequeue();
    }

    void sendMessage(ProcessId dst, PaxosMessage msg) {
        env.sendMessage(dst, msg);
    }

    void deliver(PaxosMessage msg) {
        inbox.enqueue(msg);
    }
}
