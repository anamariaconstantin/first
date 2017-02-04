/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.Timer;

/**
 *
 * @author ana-maria.constantin
 */
public class Meniu extends JMenuBar implements ActionListener {

    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem exit = new JMenuItem("Exit");

    private JMenuItem adauga = new JMenuItem("Agauga");
    private JMenuItem sterge = new JMenuItem("Sterge");
    private JMenuItem modifica = new JMenuItem("Modifica");
    private JMenuItem cauta = new JMenuItem("Cauta");

    private JMenuItem inregistrare = new JMenuItem("Inregistrare");
    private JMenuItem about = new JMenuItem("About");

    JLabel pic;
    Timer tm;
    int x = 0;
    String[] list = {
        "C:/Users/ana-maria.constantin/Documents/NetBeansProjects/proiect/src/rec1.jpg",
        "C:/Users/ana-maria.constantin/Documents/NetBeansProjects/proiect/src/rec3.jpg",
        "C:/Users/ana-maria.constantin/Documents/NetBeansProjects/proiect/src/rec2.jpg"

    };

    private void setDefaultClodeOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Meniu() {

        super();

        pic = new JLabel();
        pic.setBounds(200, 300, 450, 100);

        SetImageSize(2);
        tm = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }

            }
        });

        tm.start();
        setLayout(null);
        setSize(100, 120);

        setVisible(true);

        JFrame f = new JFrame("Meniu principal");

        f.add(pic);

        f.setSize(600, 500);
        f.setVisible(true);

    }

    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    @Override
    public void actionPerformed(ActionEvent E) {

        if (E.getSource() == open) {
            JFileChooser F = new JFileChooser(".");
            F.showOpenDialog(null);
        }

        if (E.getSource() == save) {
            JFileChooser F = new JFileChooser(".");
            F.showOpenDialog(null);
        }
        if (E.getSource() == exit) {

            JFrame f = new JFrame();
            Object[] options = {"Da",
                "Nu",};
            int n = JOptionPane.showOptionDialog(f,
                    "Sigur"
                    + "Doriti sa parasiti aplicatia ?",
                    "Intrebare ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == 0) {
                System.exit(0);
            }

        }

    }
}
