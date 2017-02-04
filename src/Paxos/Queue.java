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

public class Queue<T> {

    LinkedList<T> ll = new LinkedList<T>();

    public synchronized void enqueue(T obj) {
        ll.add(obj);
        notify();
    }

    public synchronized T bdequeue() {
        while (ll.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        return ll.removeFirst();
    }
}
