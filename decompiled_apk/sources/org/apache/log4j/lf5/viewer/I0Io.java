package org.apache.log4j.lf5.viewer;

import java.awt.Adjustable;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

/* loaded from: classes6.dex */
public class I0Io {
    public static void I0Io(JScrollPane jScrollPane) {
        if (jScrollPane == null) {
            return;
        }
        II0xO0(jScrollPane.getVerticalScrollBar());
    }

    public static void II0xO0(Adjustable adjustable) {
        if (adjustable == null) {
            return;
        }
        adjustable.addAdjustmentListener(new oxxXoxO());
    }

    public static void Oxx0IOOO(int i, ListSelectionModel listSelectionModel) {
        if (listSelectionModel == null) {
            return;
        }
        listSelectionModel.setSelectionInterval(i, i);
    }

    public static void X0o0xo(JComponent jComponent) {
        SwingUtilities.invokeLater(new II0xO0(jComponent));
    }

    public static void XO(int i, JTable jTable, JScrollPane jScrollPane) {
        if (jTable == null || jScrollPane == null || !oIX0oI(i, jTable.getModel())) {
            return;
        }
        oxoX(jTable.getRowHeight() * i, jScrollPane.getVerticalScrollBar());
        Oxx0IOOO(i, jTable.getSelectionModel());
        X0o0xo(jTable);
    }

    public static boolean oIX0oI(int i, TableModel tableModel) {
        if (tableModel == null || i < 0 || i >= tableModel.getRowCount()) {
            return false;
        }
        return true;
    }

    public static void oxoX(int i, Adjustable adjustable) {
        if (adjustable == null) {
            return;
        }
        adjustable.setValue(i);
    }
}
