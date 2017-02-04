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

public class PaxosMessage {

    ProcessId src;
}

class P1aMessage extends PaxosMessage {

    BallotNumber ballot_number;

    P1aMessage(ProcessId src, BallotNumber ballot_number) {
        this.src = src;
        this.ballot_number = ballot_number;
    }
}

class P1bMessage extends PaxosMessage {

    BallotNumber ballot_number;
    Set< PValue> accepted;

    P1bMessage(ProcessId src, BallotNumber ballot_number, Set< PValue> accepted) {
        this.src = src;
        this.ballot_number = ballot_number;
        this.accepted = accepted;
    }
}

class P2aMessage extends PaxosMessage {

    BallotNumber ballot_number;
    int slot_number;
    Comanda command;

    P2aMessage(ProcessId src, BallotNumber ballot_number, int slot_number, Comanda command) {
        this.src = src;
        this.ballot_number = ballot_number;
        this.slot_number = slot_number;
        this.command = command;
    }
}

class P2bMessage extends PaxosMessage {

    BallotNumber ballot_number;
    int slot_number;

    P2bMessage(ProcessId src, BallotNumber ballot_number, int slot_number) {
        this.src = src;
        this.ballot_number = ballot_number;
        this.slot_number = slot_number;
    }
}

class PreemptedMessage extends PaxosMessage {

    BallotNumber ballot_number;

    PreemptedMessage(ProcessId src, BallotNumber ballot_number) {
        this.src = src;
        this.ballot_number = ballot_number;
    }
}

class AdoptedMessage extends PaxosMessage {

    BallotNumber ballot_number;
    Set< PValue> accepted;

    AdoptedMessage(ProcessId src, BallotNumber ballot_number, Set< PValue> accepted) {
        this.src = src;
        this.ballot_number = ballot_number;
        this.accepted = accepted;
    }
}

class DecisionMessage extends PaxosMessage {

    ProcessId src;
    int slot_number;
    Comanda command;

    public DecisionMessage(ProcessId src, int slot_number, Comanda command) {
        this.src = src;
        this.slot_number = slot_number;
        this.command = command;
    }
}

class RequestMessage extends PaxosMessage {

    Comanda command;

    public RequestMessage(ProcessId src, Comanda command) {
        this.src = src;
        this.command = command;
    }
}

class ProposeMessage extends PaxosMessage {

    int slot_number;
    Comanda command;

    public ProposeMessage(ProcessId src, int slot_number, Comanda command) {
        this.src = src;
        this.slot_number = slot_number;
        this.command = command;
    }
}
