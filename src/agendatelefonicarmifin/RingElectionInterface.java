/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ana-maria
 */
 
  interface RingElectionInterface extends Remote {

    public void adaugaAbonat(Abonat abonat) throws RemoteException;
  
}
