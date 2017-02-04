/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

  

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 

/**
 *
 * @author ana-maria.constantin
 */
public class FereastraAbonatAdaugareModificare extends JFrame {

    JLabel l1 = new JLabel("Nume ");
    JLabel l2 = new JLabel("Prenume ");
    JLabel l3 = new JLabel("CNP ");
    JLabel l5 = new JLabel("Fix");
    JLabel l6 = new JLabel(" Mobil");
    JLabel l4 = new JLabel("Sex");

    JTextField textNume;
    JTextField textPrenume;
    JTextField textCnp;
    JTextField textTelF;
    JTextField textTelM;
    JComboBox cbSex;

    //constructor Adaugare
    public FereastraAbonatAdaugareModificare(FereatraPrincipala fereastraParinte) {
        this(fereastraParinte, null);

    }

    //constructor Modificare
    public FereastraAbonatAdaugareModificare(final FereatraPrincipala fereastraParinte, Abonat abonatSelectat) {
        super();
        this.setTitle(abonatSelectat == null ? "Adauga Abonat" : "Modifica Abonat");

        textNume = new JTextField(20);
        textPrenume = new JTextField(20);
        textCnp = new JTextField(20);
        textTelF = new JTextField(20);
        textTelM = new JTextField(20);
        cbSex = new JComboBox();

        cbSex.addItem(Abonat.SEX_F);
        cbSex.addItem(Abonat.SEX_M);

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        if (abonatSelectat != null) {
            textNume.setText(abonatSelectat.getNume());
            textPrenume.setText(abonatSelectat.getPrenume());
            textCnp.setText(abonatSelectat.getCnp());

            cbSex.setSelectedItem(abonatSelectat.getSex());
            textTelF.setText(String.valueOf(abonatSelectat.getFix() != null ? abonatSelectat.getFix().getNumar() : ""));
            textTelM.setText(String.valueOf(abonatSelectat.getMobil() != null ? abonatSelectat.getMobil().getNumar() : ""));
        }

        JButton btnAdaugaModificaAbonat = new JButton(abonatSelectat == null ? "Adaugare" : "Modifica");

        p1.add(l1);
        p1.add(textNume);
        p2.add(l2);
        p2.add(textPrenume);
        p3.add(l3);
        p3.add(textCnp);

        p4.add(l5);
        p4.add(textTelF);

        p5.add(l6);
        p5.add(textTelM);

        p6.add(cbSex);
        p7.add(btnAdaugaModificaAbonat);

        setLayout(new GridLayout(7, 1));
        this.add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);

        btnAdaugaModificaAbonat.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                try {

                    if (textNume.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Numele este obligatoriu", "EROARE", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (textPrenume.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "Prenumele este obligatoriu", "EROARE", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String cnp = textCnp.getText();
                    if (!CnpValidator.is_valid(cnp)) {
                        JOptionPane.showMessageDialog(null, "Cnp invalid", "EROARE", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (abonatSelectat == null) {
                        String nrFix;
                        String nrMobil;

                        Abonat abonat = new Abonat(textNume.getText(), textPrenume.getText(), textCnp.getText(), (char) cbSex.getSelectedItem(), new NrFix(textTelF.getText()), new NrMobil((textTelM.getText())));
                        try {
                            CarteDeTelefon.getInstance().adaugaAbonat(abonat);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "EROARE", JOptionPane.ERROR_MESSAGE);
                        }
                    } else { //Abonatul exista, update in baza cu datele de pe ecran
                        abonatSelectat.setNume(textNume.getText().trim());
                        abonatSelectat.setPrenume(textPrenume.getText().trim());
                        abonatSelectat.setCnp(textCnp.getText().trim());
                        abonatSelectat.setSex((char) cbSex.getSelectedItem());
                        abonatSelectat.setFix(new NrFix(textTelF.getText()));
                        abonatSelectat.setMobil(new NrMobil(textTelM.getText()));

                        try {
                            CarteDeTelefon.getInstance().modificaAbonat(abonatSelectat);
                            // CarteDeTelefon.getInstance().adaugaAbonat(abonatSelectat);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "EROARE", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                    fereastraParinte.refreshTable();

                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
