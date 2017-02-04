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
public class PValue {

    BallotNumber ballot_number;
    int slot_number;
    Comanda command;

    public PValue(BallotNumber ballot_number, int slot_number,
            Comanda command) {
        this.ballot_number = ballot_number;
        this.slot_number = slot_number;
        this.command = command;
    }

    public String toString() {
        return " PV ( " + ballot_number + " , " + slot_number + " , " + command + " )";
    }
}
