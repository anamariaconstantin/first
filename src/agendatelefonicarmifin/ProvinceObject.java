/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana-maria.constantin
 */
class ProvinceObject extends UnicastRemoteObject
        implements Interface {

    public ProvinceObject() throws RemoteException {
        super();
    }

    @Override
    public void adaugaAbonat(Abonat abonat) throws RemoteException {
        try {
            System.out.println("Invoke adauga from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
//    return ProvinceRepository.save(p);

    }

    @Override
    public void stergereAbonat(Abonat abonat) throws RemoteException {
        try {
            System.out.println("Invoke sterge from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
    }

    @Override
    public void modificaAbonat(Abonat abonat) throws RemoteException {
        try {
            System.out.println("Invoke modifica from " + getClientHost());
        } catch (ServerNotActiveException snae) {
            snae.printStackTrace();
        }
    }

    @Override
    public List<Abonat> getAllAbonati() throws RemoteException {
        try {
            try {
                System.out.println("Invoke get from " + getClientHost());
            } catch (ServerNotActiveException snae) {
                snae.printStackTrace();
            }
            return  CarteDeTelefon.getAllAbonati();
        } catch (Exception ex) {
            Logger.getLogger(ProvinceObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}