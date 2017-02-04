/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;
 
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana-maria.constantin
 */
public class AbonatTableModel extends AbstractTableModel {

    private List<Abonat> abonati;

    public AbonatTableModel(List<Abonat> abonati) {
        this.abonati = abonati;
    }

    @Override
    public int getRowCount() {
        return abonati.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "Nume";
                break;
            case 1:
                name = "Prenume";
                break;
            case 2:
                name = "CNP";
                break;
            case 3:
                name = "Sex";
                break;
            case 4:
                name = "Fix";
                break;
            case 5:
                name = "Mobil";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
                type = String.class;
                break;
            case 1:
                type = String.class;
                break;
            case 2:
                type = String.class;
                break;
            case 3:
                type = Character.class;
                break;
            case 4:
                type = String.class;
                break;
            case 5:
                type = String.class;
                break;

        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abonat abonat = abonati.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = abonat.getNume();
                break;
            case 1:
                value = abonat.getPrenume();
                break;
            case 2:
                value = abonat.getCnp();
                break;
            case 3:
                value = abonat.getSex();
                break;
            case 4:
                value = abonat.getFix() != null ? abonat.getFix().getNumar() : "";
                break;
            case 5:
                value = abonat.getMobil() != null ? abonat.getMobil().getNumar() : "";
                break;
        }
        return value;
    }

    public List<Abonat> getAbonati() {
        return abonati;
    }

    public void setAbonati(List<Abonat> abonati) {
        this.abonati = abonati;
    }

}
