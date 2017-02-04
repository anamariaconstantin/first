/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import javax.swing.JButton;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

 
 
public class FereatraPrincipala extends JFrame implements ActionListener {

    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem adaugaMenuItem = new JMenuItem("Adauga");
    private JMenuItem stergeMenuItem = new JMenuItem("Sterge");
    private JMenuItem modificaMenuItem = new JMenuItem("Modifica");

    private JMenuItem about = new JMenuItem("About");

    Container contentPane = getContentPane();
    private JPanel jpfiltrare = new JPanel();
    private JPanel jpreclame = new JPanel();
    private JPanel jpbutoane = new JPanel();
    private JButton adaugaBtn = new JButton(), stergereBtn = new JButton(), modificareBtn = new JButton(), Filtrare = new JButton();
    private JPanel jpadauga = new JPanel(), jpStergere = new JPanel(), jpModificare = new JPanel();

    private JPanel jpbuttongroup = new JPanel();

    int x = 0;
    private Abonat lastSelectedAbonat = null;
    private FereatraPrincipala thisFrame;
    private AbonatTable table;
    private AbonatTableModel model;
    private List<Abonat> listaAbonati;

    public FereatraPrincipala() {
        thisFrame = this;
        initializareMeniu();
        initializareReclame();
        initializareTabel();
        initializareButoane();
        setTitle("Fereastra Abonati ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setDefaultClodeOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initializareButonFiltrare() {

        Filtrare.setBackground(new java.awt.Color(102, 102, 102));
        Filtrare.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        Filtrare.setForeground(new java.awt.Color(0, 0, 153));
        Filtrare.setText("Filtrare");
        Filtrare.setName(""); // NOI18N
        jpfiltrare.add(Filtrare);
        jpfiltrare.setVisible(true);

        contentPane.add(jpfiltrare, BorderLayout.AFTER_LAST_LINE);

    }

    private void initializareButonAdauga() {
        adaugaBtn.setBackground(new java.awt.Color(102, 102, 102));
        adaugaBtn.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        adaugaBtn.setForeground(new java.awt.Color(0, 0, 153));
        adaugaBtn.setText("Adauga");
        adaugaBtn.setName(""); // NOI18N
        jpadauga.add(adaugaBtn);
        jpadauga.setVisible(true);
        contentPane.add(jpadauga, BorderLayout.AFTER_LAST_LINE);

        adaugaBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deschideFereastraAdaugare(lastSelectedAbonat);
            }
        });
    }

    private void initializareButonStergere() {
        stergereBtn.setBackground(new java.awt.Color(102, 102, 102));
        stergereBtn.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        stergereBtn.setForeground(new java.awt.Color(0, 0, 153));
        stergereBtn.setText("Stergere");
        stergereBtn.setName(""); // NOI18N
        jpStergere.add(stergereBtn);
        jpStergere.setVisible(true);
        contentPane.add(jpStergere, BorderLayout.EAST);

        if (lastSelectedAbonat != null) {
            stergereBtn.setEnabled(true);
        } else {
            stergereBtn.setEnabled(false);
        }

        stergereBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stergeAbonat();
            }
        });

    }

    private void initializareButonModificare() {
        modificareBtn.setBackground(new java.awt.Color(102, 102, 102));
        modificareBtn.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        modificareBtn.setForeground(new java.awt.Color(0, 0, 153));
        modificareBtn.setText("Modifica");
        modificareBtn.setName(""); // NOI18N
        jpModificare.add(modificareBtn);
        jpModificare.setVisible(true);
        contentPane.add(jpModificare, BorderLayout.WEST);

        if (lastSelectedAbonat != null) {
            modificareBtn.setEnabled(true);
        } else {
            modificareBtn.setEnabled(false);
        }

        modificareBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deschideFereastraModificare(lastSelectedAbonat);
            }
        });
    }

    private void initializareButoane() {
        this.initializareButonAdauga();
        this.initializareButonStergere();
        this.initializareButonModificare();
        this.initializareButonFiltrare();

        jpbuttongroup.add(jpadauga);
        jpbuttongroup.add(jpStergere);
        jpbuttongroup.add(jpModificare);
        jpbuttongroup.add(jpfiltrare);
        contentPane.add(jpbuttongroup, BorderLayout.CENTER);

    }

    private void initializareMeniu() {
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Abonati");
        JMenu menu3 = new JMenu("Help");

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser(".");
                fileChooser.showOpenDialog(null);
            }
        });
        save.addActionListener(this);
        exit.addActionListener(this);

        about.addActionListener(this);

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame("Informatii despre aplicatie");
                frame.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                JTextArea textArea = new JTextArea(6, 35);
                textArea.setText(
                        "Acest proiect este realizat de Constantin Ana-Maria, Dumitru Cristiana si Iordache Marius "
                        + "Agenda de telefoane electronica contine interfata grafica si ofera facilitati de cautare dupa nume, prenume, CNP, telefon cat  si afisare ordonata dupa oricare dintre aceste criterii."
                       +" Algoritmii: Cristian, Lamport, Paxos, RingElection si Testare Junit"
                        
                );
                textArea.setFont(new Font("Serif", Font.ITALIC, 16));
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                panel.add(textArea);

                // panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
                frame.add(panel, BorderLayout.CENTER);
                // frame.setSize(400, 400);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });

        adaugaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deschideFereastraAdaugare(lastSelectedAbonat);
            }
        });
        // adaugaMenuItem.setEnabled(false);

        stergeMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                stergeAbonat();
            }
        });
        stergeMenuItem.setEnabled(false);

        modificaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deschideFereastraModificare(lastSelectedAbonat);
            }
        });
        modificaMenuItem.setEnabled(false);

        //cauta.addActionListener(this);
        menu1.add(open);
        menu1.add(save);
        menu1.addSeparator();
        menu1.add(exit);
        // menu2.add(inregistrare);

        menu2.add(adaugaMenuItem);
        menu2.add(stergeMenuItem);
        menu2.add(modificaMenuItem);
        menu3.add(about);
        // menu3.add(cauta);

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);

        this.setJMenuBar(menubar);
    }

    private void initializareTabel() {
        //  Create table with database data   
        table = new AbonatTable();
        try {
            listaAbonati = CarteDeTelefon.getInstance().getAllAbonati();
        } catch (Exception ex) {
            Logger.getLogger(FereatraPrincipala.class.getName()).log(Level.SEVERE, null, ex);
        }
        model = new AbonatTableModel(listaAbonati);
        table.setModel(model);
        try {
            table.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    //Setare last Abonat selectat
                    if (e.getClickCount() == 1) {
                        AbonatTable target = (AbonatTable) e.getSource();
                        int rowIndex = target.getSelectedRow();
                        int columnIndex = target.getSelectedColumn();

                        if (listaAbonati != null && listaAbonati.size() > 0) {
                            lastSelectedAbonat = listaAbonati.get(rowIndex);
                            adaugaMenuItem.setEnabled(true);
                            stergereBtn.setEnabled(true);
                            modificareBtn.setEnabled(true);
                            stergeMenuItem.setEnabled(true);
                            modificaMenuItem.setEnabled(true);

                        }
                    }
                    //Deschide fereastra in Modify Mode
                    if (e.getClickCount() == 2) {
                        AbonatTable target = (AbonatTable) e.getSource();
                        int rowIndex = target.getSelectedRow();
                        int columnIndex = target.getSelectedColumn();
                        lastSelectedAbonat = listaAbonati.get(rowIndex);
                        deschideFereastraModificare(lastSelectedAbonat);
                    }
                }
            });

            //sortare pe cap de tabel(teable header)
            table.setRowSorter(new TableRowSorter(model));

            final TableRowSorter<TableModel> sorter
                    = new TableRowSorter<TableModel>(model);
            table.setRowSorter(sorter);
            final JTextField filterText = new JTextField("Cautati pentru filtrare");
            jpfiltrare.add(filterText, BorderLayout.CENTER);
            String text = filterText.getText();

            Filtrare.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String text = filterText.getText();
                    if (text.length() == 0) {
                        sorter.setRowFilter(null);
                    } else {
                        try {
                            sorter.setRowFilter(
                                    RowFilter.regexFilter(text));
                        } catch (PatternSyntaxException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "EROARE", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "EROARE", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane()
                .add(scrollPane, BorderLayout.NORTH);

    }

    private void initializareReclame() {
        String[] list = {
            "C:/Users/ana-maria/Documents/NetBeansProjects/AgendaTelefonicaRmiFin/src/rec1.jpg",
            "C:/Users/ana-maria/Documents/NetBeansProjects/AgendaTelefonicaRmiFin/src/rec2.jpg",
            "C:/Users/ana-maria/Documents/NetBeansProjects/AgendaTelefonicaRmiFin/src/rec3.jpg"

        };
        JLabel pic = new JLabel();

        pic.setBounds(0, 0, 200, 200);

        SetImageSize(2, pic, list);
        Timer tm = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                SetImageSize(x, pic, list);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }
            }
        });
        tm.start();
        jpreclame.add(pic);
        contentPane.add(jpreclame, BorderLayout.AFTER_LINE_ENDS);

    }

    public void SetImageSize(int i, JLabel pic, String[] list) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);

        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    @Override
    public void actionPerformed(ActionEvent E) {

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
                    + " doriti sa parasiti aplicatia ?",
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

    public void deschideFereastraModificare(Abonat abonatSelectat) {
        FereastraAbonatAdaugareModificare fModif = new FereastraAbonatAdaugareModificare(thisFrame, abonatSelectat);
        fModif.setVisible(true);
        fModif.pack();
    }

    public void deschideFereastraAdaugare(Abonat abonatSelectat) {
        FereastraAbonatAdaugareModificare fAdaugare = new FereastraAbonatAdaugareModificare(thisFrame);
        fAdaugare.setVisible(true);
        fAdaugare.pack();
    }

    private void stergeAbonat() {
        //Intrebare 
        Object[] options = {"Da",
            "Nu",};
        int n = JOptionPane.showOptionDialog(thisFrame,
                "Sigur"
                + "Doriti sa stergeti abonatul selectat ?",
                "Intrebare ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == 0) {
            try {
                CarteDeTelefon.getInstance().stergereAbonat(lastSelectedAbonat);
                refreshTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "EROARE", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void refreshTable() {

        try {
            listaAbonati = CarteDeTelefon.getInstance().getAllAbonati();
        } catch (Exception ex) {
            Logger.getLogger(FereatraPrincipala.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.setAbonati(listaAbonati);
        model.fireTableDataChanged();

    }
}
