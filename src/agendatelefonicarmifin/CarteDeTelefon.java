/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ana-maria.constantin
 */
package agendatelefonicarmifin;
 
import java.rmi.RemoteException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//This is a singleton - one intance per application
public class CarteDeTelefon {

    private static CarteDeTelefon instance = null;

    public static CarteDeTelefon getInstance() {
        if (instance == null) {
            instance = new CarteDeTelefon();
        }
        return instance;
    }

    public static void adaugaAbonat(Abonat abonat) throws RemoteException, Exception {
        if (abonat == null) {
            return;
        }
        String sqlStatement = null;
        Connection con = DatabaseHelper.getConnection();
        PreparedStatement stmt = null;
        try {
            sqlStatement = "INSERT INTO abonat (nume, prenume, cnp,sex, nrFix, nrMobil ) VALUES (?, ?, ?, ?, ?, ?);";
            stmt = con.prepareStatement(sqlStatement);
            stmt.setString(1, abonat.getNume());
            stmt.setString(2, abonat.getPrenume());
            stmt.setString(3, abonat.getCnp());
            stmt.setString(4, String.valueOf(abonat.getSex()));
            stmt.setString(5, String.valueOf(abonat.getFix() != null ? abonat.getFix().getNumar() : ""));
            stmt.setString(6, String.valueOf(abonat.getMobil() != null ? abonat.getMobil().getNumar() : ""));

            stmt.executeUpdate();
        } catch (Exception db) {
            throw new Exception("Eroare la inserare abonat");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception ex) {
                throw new Exception("Eroare la inserare abonat");
            }
        }
    }

    public static void stergereAbonat(Abonat abonat) throws Exception {
        //delete 
        if (abonat == null) {
            return;
        }
        String sqlStatement = null;
        Connection con = DatabaseHelper.getConnection();
        PreparedStatement stmt = null;
        try {
            sqlStatement = "DELETE from abonat where id=? ";
            stmt = con.prepareStatement(sqlStatement);
            stmt.setInt(1, abonat.getId());

            stmt.executeUpdate();

            //  stmt.execute();
        } catch (Exception e) {
            throw new Exception("Eroare la stergere abonat");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception ex) {
                throw new Exception("Eroare la stergere abonat");
            }
        }

    }

    public static void modificaAbonat(Abonat abonat) throws Exception {

        Connection con = DatabaseHelper.getConnection();
        String query = "update abonat set nume = ? ,prenume=? ,sex=?, cnp =? ,nrfix=?,nrmobil=?where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        try {
            preparedStmt.setString(1, abonat.getNume());
            preparedStmt.setString(2, abonat.getPrenume());
            preparedStmt.setString(3, String.valueOf(abonat.getSex()));
            preparedStmt.setString(4, abonat.getCnp());
            preparedStmt.setString(5, String.valueOf(abonat.getFix() != null ? abonat.getFix().getNumar() : ""));
            preparedStmt.setString(6, String.valueOf(abonat.getMobil() != null ? abonat.getMobil().getNumar() : ""));
            preparedStmt.setInt(7, abonat.getId());

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Eroare la modificare abonat");
        } finally {
            try {
                if (preparedStmt != null) {
                    preparedStmt.close();
                }
            } catch (Exception ex) {
                throw new Exception("Eroare la modificare abonat");
            }
        }
    }

    public static List<Abonat> getAllAbonati() throws Exception {
        List<Abonat> abonati = null;

        Connection con = DatabaseHelper.getConnection();
        PreparedStatement stmt = null;
        String sqlString = "SELECT id, nume,prenume,sex, cnp, nrfix, nrmobil  FROM abonat";
        stmt = con.prepareStatement(sqlString);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            char sex = rs.getString("sex").charAt(0);
            String cnp = rs.getString("cnp");
            String nrFix = rs.getString("nrfix");
            String nrMobil = rs.getString("nrmobil");
            if (abonati == null) {
                abonati = new ArrayList<Abonat>();
            }

            Abonat abonat = new Abonat(nume, prenume, cnp, sex, new NrFix(nrFix), new NrMobil(nrMobil));
            abonat.setId(id);
            abonati.add(abonat);

        }
        return abonati;
    }

    void getAllAbonati(List listaAbonati) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
