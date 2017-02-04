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
public class ProcessId implements Comparable {

    String name;

    public ProcessId(String name) {
        this.name = name;
    }

    public boolean equals(Object other) {
        return name.equals(((ProcessId) other).name);
    }

    public int compareTo(Object other) {
        return name.compareTo(((ProcessId) other).name);
    }

    public String toString() {
        return name;
    }
}
