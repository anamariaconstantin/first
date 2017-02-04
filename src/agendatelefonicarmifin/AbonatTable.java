/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicarmifin;

import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ana-maria.constantin
 */
public class AbonatTable extends JTable {

    private final String tooltipHeader = "Click pentru sortare!";
    private String[] columnToolTips = {tooltipHeader, tooltipHeader, tooltipHeader, tooltipHeader, tooltipHeader, tooltipHeader};

    protected JTableHeader createDefaultTableHeader() {
        return new JTableHeader(columnModel) {
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int index = columnModel.getColumnIndexAtX(p.x);
                int realIndex = columnModel.getColumn(index).getModelIndex();
                return columnToolTips[realIndex];
            }
        };
    }

}
