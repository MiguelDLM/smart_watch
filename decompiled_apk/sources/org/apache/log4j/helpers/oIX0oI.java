package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class oIX0oI implements org.apache.log4j.spi.oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Vector f33273oIX0oI;

    @Override // org.apache.log4j.spi.oIX0oI
    public org.apache.log4j.oIX0oI II0XooXoX(String str) {
        Vector vector = this.f33273oIX0oI;
        if (vector == null || str == null) {
            return null;
        }
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            org.apache.log4j.oIX0oI oix0oi = (org.apache.log4j.oIX0oI) this.f33273oIX0oI.elementAt(i);
            if (str.equals(oix0oi.getName())) {
                return oix0oi;
            }
        }
        return null;
    }

    public int II0xO0(LoggingEvent loggingEvent) {
        Vector vector = this.f33273oIX0oI;
        if (vector == null) {
            return 0;
        }
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            ((org.apache.log4j.oIX0oI) this.f33273oIX0oI.elementAt(i)).xxIXOIIO(loggingEvent);
        }
        return size;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public Enumeration OOXIXo() {
        Vector vector = this.f33273oIX0oI;
        if (vector == null) {
            return null;
        }
        return vector.elements();
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void Oxx0IOOO(org.apache.log4j.oIX0oI oix0oi) {
        Vector vector;
        if (oix0oi != null && (vector = this.f33273oIX0oI) != null) {
            vector.removeElement(oix0oi);
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void X0o0xo(String str) {
        Vector vector;
        if (str != null && (vector = this.f33273oIX0oI) != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(((org.apache.log4j.oIX0oI) this.f33273oIX0oI.elementAt(i)).getName())) {
                    this.f33273oIX0oI.removeElementAt(i);
                    return;
                }
            }
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void oIX0oI(org.apache.log4j.oIX0oI oix0oi) {
        if (oix0oi == null) {
            return;
        }
        if (this.f33273oIX0oI == null) {
            this.f33273oIX0oI = new Vector(1);
        }
        if (!this.f33273oIX0oI.contains(oix0oi)) {
            this.f33273oIX0oI.addElement(oix0oi);
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public void oO() {
        Vector vector = this.f33273oIX0oI;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((org.apache.log4j.oIX0oI) this.f33273oIX0oI.elementAt(i)).close();
            }
            this.f33273oIX0oI.removeAllElements();
            this.f33273oIX0oI = null;
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public boolean oOoXoXO(org.apache.log4j.oIX0oI oix0oi) {
        Vector vector = this.f33273oIX0oI;
        if (vector == null || oix0oi == null) {
            return false;
        }
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            if (((org.apache.log4j.oIX0oI) this.f33273oIX0oI.elementAt(i)) == oix0oi) {
                return true;
            }
        }
        return false;
    }
}
