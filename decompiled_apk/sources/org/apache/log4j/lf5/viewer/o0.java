package org.apache.log4j.lf5.viewer;

import com.sma.smartv3.view.picker.WeightPicker;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/* loaded from: classes6.dex */
public class o0 extends JTable {

    /* renamed from: II0xO0, reason: collision with root package name */
    public JTextArea f33403II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f33408oIX0oI = 30;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f33401I0Io = 9;

    /* renamed from: oxoX, reason: collision with root package name */
    public TableColumn[] f33412oxoX = new TableColumn[9];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int[] f33406X0o0xo = {40, 40, 40, 70, 70, 360, WeightPicker.f25581OxI, 200, 60};

    /* renamed from: XO, reason: collision with root package name */
    public LogTableColumn[] f33407XO = LogTableColumn.getLogTableColumnArray();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f33405Oxx0IOOO = 0;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f33402II0XooXoX = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f33416xxIXOIIO = 2;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f33415xoIox = 3;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f33404OOXIXo = 4;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f33410oOoXoXO = 5;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f33411ooOOo0oXI = 6;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f33413x0XOIxOo = 7;

    /* renamed from: oO, reason: collision with root package name */
    public int f33409oO = 8;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public xXIX0Xo.oIX0oI f33414x0xO0oo = null;

    /* loaded from: classes6.dex */
    public class oIX0oI implements ListSelectionListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public JTable f33418oIX0oI;

        public oIX0oI(JTable jTable) {
            this.f33418oIX0oI = jTable;
        }

        public void oIX0oI(ListSelectionEvent listSelectionEvent) {
            String str;
            if (listSelectionEvent.getValueIsAdjusting()) {
                return;
            }
            ListSelectionModel listSelectionModel = (ListSelectionModel) listSelectionEvent.getSource();
            if (!listSelectionModel.isSelectionEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                int minSelectionIndex = listSelectionModel.getMinSelectionIndex();
                for (int i = 0; i < o0.this.f33401I0Io - 1; i++) {
                    Object valueAt = this.f33418oIX0oI.getModel().getValueAt(minSelectionIndex, i);
                    if (valueAt != null) {
                        str = valueAt.toString();
                    } else {
                        str = "";
                    }
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(o0.this.f33407XO[i]);
                    stringBuffer2.append(":");
                    stringBuffer.append(stringBuffer2.toString());
                    stringBuffer.append("\t");
                    o0 o0Var = o0.this;
                    if (i == o0Var.f33402II0XooXoX || i == o0Var.f33411ooOOo0oXI || i == o0Var.f33415xoIox) {
                        stringBuffer.append("\t");
                    }
                    o0 o0Var2 = o0.this;
                    if (i == o0Var2.f33405Oxx0IOOO || i == o0Var2.f33404OOXIXo) {
                        stringBuffer.append("\t\t");
                    }
                    stringBuffer.append(str);
                    stringBuffer.append("\n");
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(o0.this.f33407XO[r2.f33401I0Io - 1]);
                stringBuffer3.append(":\n");
                stringBuffer.append(stringBuffer3.toString());
                Object valueAt2 = this.f33418oIX0oI.getModel().getValueAt(minSelectionIndex, o0.this.f33401I0Io - 1);
                if (valueAt2 != null) {
                    stringBuffer.append(valueAt2.toString());
                }
                o0.this.f33403II0xO0.setText(stringBuffer.toString());
            }
        }
    }

    public o0(JTextArea jTextArea) {
        int i = 0;
        X0o0xo();
        this.f33403II0xO0 = jTextArea;
        setModel(new org.apache.log4j.lf5.viewer.oIX0oI());
        Enumeration columns = getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn tableColumn = (TableColumn) columns.nextElement();
            tableColumn.setCellRenderer(new I0oOoX());
            tableColumn.setPreferredWidth(this.f33406X0o0xo[i]);
            this.f33412oxoX[i] = tableColumn;
            i++;
        }
        getSelectionModel().addListSelectionListener(new oIX0oI(this));
    }

    public xXIX0Xo.oIX0oI I0Io() {
        return this.f33414x0xO0oo;
    }

    public void II0XooXoX(Font font) {
        super/*javax.swing.JComponent*/.setFont(font);
        Graphics graphics = getGraphics();
        if (graphics != null) {
            int height = graphics.getFontMetrics(font).getHeight();
            int i = height + (height / 3);
            this.f33408oIX0oI = i;
            setRowHeight(i);
        }
    }

    public Vector II0xO0() {
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            LogTableColumn[] logTableColumnArr = this.f33407XO;
            if (i >= logTableColumnArr.length) {
                return vector;
            }
            vector.add(i, logTableColumnArr[i]);
            i++;
        }
    }

    public void Oxx0IOOO() {
        TableColumnModel columnModel = getColumnModel();
        for (int i = 0; i < this.f33401I0Io; i++) {
            columnModel.removeColumn(this.f33412oxoX[i]);
        }
        for (int i2 = 0; i2 < this.f33401I0Io; i2++) {
            columnModel.addColumn(this.f33412oxoX[i2]);
        }
        sizeColumnsToFit(-1);
    }

    public void X0o0xo() {
        setRowHeight(this.f33408oIX0oI);
        setSelectionMode(0);
    }

    public void XO(xXIX0Xo.oIX0oI oix0oi) {
        this.f33414x0xO0oo = oix0oi;
    }

    public synchronized void oIX0oI() {
        oxoX().II0xO0();
    }

    public org.apache.log4j.lf5.viewer.oIX0oI oxoX() {
        return getModel();
    }

    public void xxIXOIIO(List list) {
        TableColumnModel columnModel = getColumnModel();
        for (int i = 0; i < this.f33401I0Io; i++) {
            columnModel.removeColumn(this.f33412oxoX[i]);
        }
        Iterator it = list.iterator();
        Vector II0xO02 = II0xO0();
        while (it.hasNext()) {
            columnModel.addColumn(this.f33412oxoX[II0xO02.indexOf(it.next())]);
        }
        sizeColumnsToFit(-1);
    }
}
