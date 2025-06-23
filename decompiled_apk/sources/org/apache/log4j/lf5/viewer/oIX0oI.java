package org.apache.log4j.lf5.viewer;

import XXO0.oIX0oI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.lf5.LogRecord;

/* loaded from: classes6.dex */
public class oIX0oI extends AbstractTableModel {

    /* renamed from: I0Io, reason: collision with root package name */
    public List f33421I0Io;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public org.apache.log4j.lf5.oxoX f33424oIX0oI = new org.apache.log4j.lf5.X0o0xo();

    /* renamed from: II0xO0, reason: collision with root package name */
    public List f33422II0xO0 = new ArrayList();

    /* renamed from: oxoX, reason: collision with root package name */
    public int f33425oxoX = 5000;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public String[] f33423X0o0xo = {"Date", "Thread", "Message #", "Level", "NDC", "Category", "Message", "Location", "Thrown"};

    public List I0Io() {
        ArrayList arrayList = new ArrayList();
        for (LogRecord logRecord : this.f33422II0xO0) {
            if (this.f33424oIX0oI.oIX0oI(logRecord)) {
                arrayList.add(logRecord);
            }
        }
        return arrayList;
    }

    public LogRecord II0XooXoX(int i) {
        List xxIXOIIO2 = xxIXOIIO();
        int size = xxIXOIIO2.size();
        if (i < size) {
            return (LogRecord) xxIXOIIO2.get(i);
        }
        return (LogRecord) xxIXOIIO2.get(size - 1);
    }

    public synchronized void II0xO0() {
        this.f33422II0xO0.clear();
        this.f33421I0Io.clear();
        fireTableDataChanged();
    }

    public void IXxxXO(int i) {
        if (i > 0) {
            this.f33425oxoX = i;
        }
    }

    public int OOXIXo() {
        return xxIXOIIO().size();
    }

    public void Oo(org.apache.log4j.lf5.oxoX oxox) {
        this.f33424oIX0oI = oxox;
    }

    public String Oxx0IOOO(int i) {
        return this.f33423X0o0xo[i];
    }

    public void Oxx0xo() {
        synchronized (this.f33422II0xO0) {
            try {
                int oO2 = oO();
                if (oO2 > 1) {
                    this.f33422II0xO0.subList(0, oO2).clear();
                    x0xO0oo();
                } else {
                    this.f33422II0xO0.remove(0);
                    oxoX();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object X0o0xo(int i, LogRecord logRecord) {
        if (logRecord == null) {
            return "NULL Column";
        }
        String date = new Date(logRecord.getMillis()).toString();
        switch (i) {
            case 0:
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(date);
                stringBuffer.append(" (");
                stringBuffer.append(logRecord.getMillis());
                stringBuffer.append(oIX0oI.I0Io.f4095I0Io);
                return stringBuffer.toString();
            case 1:
                return logRecord.getThreadDescription();
            case 2:
                return new Long(logRecord.getSequenceNumber());
            case 3:
                return logRecord.getLevel();
            case 4:
                return logRecord.getNDC();
            case 5:
                return logRecord.getCategory();
            case 6:
                return logRecord.getMessage();
            case 7:
                return logRecord.getLocation();
            case 8:
                return logRecord.getThrownStackTrace();
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("The column number ");
                stringBuffer2.append(i);
                stringBuffer2.append("must be between 0 and 8");
                throw new IllegalArgumentException(stringBuffer2.toString());
        }
    }

    public int XO() {
        return this.f33423X0o0xo.length;
    }

    public void oI0IIXIo() {
        if (x0XOIxOo()) {
            Oxx0xo();
        }
    }

    public synchronized boolean oIX0oI(LogRecord logRecord) {
        this.f33422II0xO0.add(logRecord);
        if (!this.f33424oIX0oI.oIX0oI(logRecord)) {
            return false;
        }
        xxIXOIIO().add(logRecord);
        fireTableRowsInserted(OOXIXo(), OOXIXo());
        oI0IIXIo();
        return true;
    }

    public final int oO() {
        return this.f33422II0xO0.size() - this.f33425oxoX;
    }

    public int oOoXoXO() {
        return this.f33422II0xO0.size();
    }

    public Object ooOOo0oXI(int i, int i2) {
        return X0o0xo(i2, II0XooXoX(i));
    }

    public synchronized void oxoX() {
        this.f33421I0Io.remove(0);
        fireTableRowsDeleted(0, 0);
    }

    public boolean x0XOIxOo() {
        if (this.f33422II0xO0.size() > this.f33425oxoX) {
            return true;
        }
        return false;
    }

    public synchronized void x0xO0oo() {
        this.f33421I0Io = I0Io();
        fireTableDataChanged();
    }

    public org.apache.log4j.lf5.oxoX xoIox() {
        return this.f33424oIX0oI;
    }

    public List xxIXOIIO() {
        if (this.f33421I0Io == null) {
            x0xO0oo();
        }
        return this.f33421I0Io;
    }
}
