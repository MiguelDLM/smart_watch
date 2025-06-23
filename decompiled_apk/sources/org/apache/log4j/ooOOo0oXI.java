package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes6.dex */
public class ooOOo0oXI implements org.apache.log4j.spi.xxIXOIIO, org.apache.log4j.spi.oOoXoXO {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Level f33481Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Xxx0oXX.I0Io f33482X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f33483XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public org.apache.log4j.spi.II0XooXoX f33484oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public x0xO0oo f33485oxoX;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f33479II0XooXoX = false;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f33486xxIXOIIO = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public Hashtable f33478I0Io = new Hashtable();

    /* renamed from: II0xO0, reason: collision with root package name */
    public Vector f33480II0xO0 = new Vector(1);

    public ooOOo0oXI(x0xO0oo x0xo0oo) {
        this.f33485oxoX = x0xo0oo;
        ooOOo0oXI(Level.ALL);
        this.f33485oxoX.Io(this);
        this.f33482X0o0xo = new Xxx0oXX.I0Io();
        this.f33484oIX0oI = new xxIXOIIO();
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void I0Io(X0o0xo x0o0xo, oIX0oI oix0oi) {
        Vector vector = this.f33480II0xO0;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((org.apache.log4j.spi.Oxx0IOOO) this.f33480II0xO0.elementAt(i)).II0xO0(x0o0xo, oix0oi);
            }
        }
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public Enumeration II0XooXoX() {
        return Oxx0IOOO();
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void II0xO0(org.apache.log4j.spi.Oxx0IOOO oxx0IOOO) {
        if (this.f33480II0xO0.contains(oxx0IOOO)) {
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Ignoring attempt to add an existent listener.");
        } else {
            this.f33480II0xO0.addElement(oxx0IOOO);
        }
    }

    public final void IIXOooo(ProvisionNode provisionNode, x0xO0oo x0xo0oo) {
        int size = provisionNode.size();
        for (int i = 0; i < size; i++) {
            x0xO0oo x0xo0oo2 = (x0xO0oo) provisionNode.elementAt(i);
            if (!x0xo0oo2.f33206I0Io.f33211oIX0oI.startsWith(x0xo0oo.f33211oIX0oI)) {
                x0xo0oo.f33206I0Io = x0xo0oo2.f33206I0Io;
                x0xo0oo2.f33206I0Io = x0xo0oo;
            }
        }
    }

    public void IXxxXO() {
        this.f33478I0Io.clear();
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void OOXIXo() {
        oO().o0(Level.DEBUG);
        this.f33485oxoX.I0oOoX(null);
        ooOOo0oXI(Level.ALL);
        synchronized (this.f33478I0Io) {
            shutdown();
            Enumeration Oxx0IOOO2 = Oxx0IOOO();
            while (Oxx0IOOO2.hasMoreElements()) {
                x0xO0oo x0xo0oo = (x0xO0oo) Oxx0IOOO2.nextElement();
                x0xo0oo.o0(null);
                x0xo0oo.OI0(true);
                x0xo0oo.I0oOoX(null);
            }
        }
        this.f33482X0o0xo.I0Io();
    }

    public void Oo(Class cls, Xxx0oXX.II0xO0 iI0xO0) {
        this.f33482X0o0xo.II0XooXoX(cls, iI0xO0);
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public Enumeration Oxx0IOOO() {
        Vector vector = new Vector(this.f33478I0Io.size());
        Enumeration elements = this.f33478I0Io.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof x0xO0oo) {
                vector.addElement(nextElement);
            }
        }
        return vector.elements();
    }

    public void Oxx0xo(X0o0xo x0o0xo, oIX0oI oix0oi) {
        Vector vector = this.f33480II0xO0;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((org.apache.log4j.spi.Oxx0IOOO) this.f33480II0xO0.elementAt(i)).oIX0oI(x0o0xo, oix0oi);
            }
        }
    }

    public void OxxIIOOXO(String str) {
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("The Hiearchy.setDisableOverride method has been deprecated.");
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public boolean X0o0xo(int i) {
        if (this.f33483XO > i) {
            return true;
        }
        return false;
    }

    @Override // org.apache.log4j.spi.oOoXoXO
    public Xxx0oXX.I0Io XO() {
        return this.f33482X0o0xo;
    }

    public void oI0IIXIo(String str) {
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("The Hiearchy.overrideAsNeeded method has been deprecated.");
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void oIX0oI(X0o0xo x0o0xo) {
        if (!this.f33479II0XooXoX) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No appenders could be found for logger (");
            stringBuffer.append(x0o0xo.xxX());
            stringBuffer.append(").");
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
            org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO("Please initialize the log4j system properly.");
            this.f33479II0XooXoX = true;
        }
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public x0xO0oo oO() {
        return this.f33485oxoX;
    }

    @Override // org.apache.log4j.spi.oOoXoXO
    public void oOoXoXO(Class cls, Xxx0oXX.II0xO0 iI0xO0) {
        this.f33482X0o0xo.II0XooXoX(cls, iI0xO0);
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void ooOOo0oXI(Level level) {
        if (level != null) {
            this.f33483XO = level.level;
            this.f33481Oxx0IOOO = level;
        }
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void oxoX(String str) {
        Level level = Level.toLevel(str, (Level) null);
        if (level != null) {
            ooOOo0oXI(level);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Could not convert [");
        stringBuffer.append(str);
        stringBuffer.append("] to Level.");
        org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer.toString());
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public void shutdown() {
        x0xO0oo oO2 = oO();
        oO2.XO();
        synchronized (this.f33478I0Io) {
            try {
                Enumeration Oxx0IOOO2 = Oxx0IOOO();
                while (Oxx0IOOO2.hasMoreElements()) {
                    ((x0xO0oo) Oxx0IOOO2.nextElement()).XO();
                }
                oO2.oO();
                Enumeration Oxx0IOOO3 = Oxx0IOOO();
                while (Oxx0IOOO3.hasMoreElements()) {
                    ((x0xO0oo) Oxx0IOOO3.nextElement()).oO();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public x0xO0oo x0XOIxOo(String str, org.apache.log4j.spi.II0XooXoX iI0XooXoX) {
        XO xo2 = new XO(str);
        synchronized (this.f33478I0Io) {
            try {
                Object obj = this.f33478I0Io.get(xo2);
                if (obj == null) {
                    x0xO0oo oIX0oI2 = iI0XooXoX.oIX0oI(str);
                    oIX0oI2.Io(this);
                    this.f33478I0Io.put(xo2, oIX0oI2);
                    xoXoI(oIX0oI2);
                    return oIX0oI2;
                }
                if (obj instanceof x0xO0oo) {
                    return (x0xO0oo) obj;
                }
                if (obj instanceof ProvisionNode) {
                    x0xO0oo oIX0oI3 = iI0XooXoX.oIX0oI(str);
                    oIX0oI3.Io(this);
                    this.f33478I0Io.put(xo2, oIX0oI3);
                    IIXOooo((ProvisionNode) obj, oIX0oI3);
                    xoXoI(oIX0oI3);
                    return oIX0oI3;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public x0xO0oo x0xO0oo(String str) {
        Object obj = this.f33478I0Io.get(new XO(str));
        if (obj instanceof x0xO0oo) {
            return (x0xO0oo) obj;
        }
        return null;
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public Level xoIox() {
        return this.f33481Oxx0IOOO;
    }

    public final void xoXoI(x0xO0oo x0xo0oo) {
        String str = x0xo0oo.f33211oIX0oI;
        for (int lastIndexOf = str.lastIndexOf(46, str.length() - 1); lastIndexOf >= 0; lastIndexOf = str.lastIndexOf(46, lastIndexOf - 1)) {
            XO xo2 = new XO(str.substring(0, lastIndexOf));
            Object obj = this.f33478I0Io.get(xo2);
            if (obj == null) {
                this.f33478I0Io.put(xo2, new ProvisionNode(x0xo0oo));
            } else if (obj instanceof X0o0xo) {
                x0xo0oo.f33206I0Io = (X0o0xo) obj;
                return;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(x0xo0oo);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("unexpected object type ");
                stringBuffer.append(obj.getClass());
                stringBuffer.append(" in ht.");
                new IllegalStateException(stringBuffer.toString()).printStackTrace();
            }
        }
        x0xo0oo.f33206I0Io = this.f33485oxoX;
    }

    @Override // org.apache.log4j.spi.xxIXOIIO
    public x0xO0oo xxIXOIIO(String str) {
        return x0XOIxOo(str, this.f33484oIX0oI);
    }
}
