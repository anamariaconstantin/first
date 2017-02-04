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
public class Comanda {

    ProcessId client;
    int req_id;
    Object op;

    public Comanda(ProcessId client, int req_id, Object op) {
        this.client = client;
        this.req_id = req_id;
        this.op = op;
    }

    public boolean equals(Object o) {
        Comanda other = (Comanda) o;
        return client.equals(other.client) && req_id == other.req_id && op.equals(other.op);
    }

    public String toString() {
        return " Comanda (" + client + " , " + req_id + " , " + op + ") ";
    }
}
