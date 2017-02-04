/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ana-maria.constantin
 */
interface Interface extends Remote {

    public void adaugaAbonat(Abonat abonat) throws RemoteException;

    public void stergereAbonat(Abonat abonat) throws RemoteException;

    public void modificaAbonat(Abonat abonat) throws RemoteException;

    public List<Abonat> getAllAbonati() throws RemoteException;
}
