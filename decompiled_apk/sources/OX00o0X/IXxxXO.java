package OX00o0X;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.table.AbstractTableModel;
import org.apache.log4j.OxxIIOOXO;

/* loaded from: classes6.dex */
public class IXxxXO extends AbstractTableModel {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static /* synthetic */ Class f1903IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1904OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public static /* synthetic */ Class f1905Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final DateFormat f1906oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Comparator f1907oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String[] f1908ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final xoIox[] f1909x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static /* synthetic */ Class f1910x0xO0oo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Object f1917oIX0oI = new Object();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final SortedSet f1913II0xO0 = new TreeSet(f1907oOoXoXO);

    /* renamed from: I0Io, reason: collision with root package name */
    public xoIox[] f1911I0Io = f1909x0XOIxOo;

    /* renamed from: oxoX, reason: collision with root package name */
    public final List f1918oxoX = new ArrayList();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f1915X0o0xo = false;

    /* renamed from: XO, reason: collision with root package name */
    public String f1916XO = "";

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public String f1914Oxx0IOOO = "";

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1912II0XooXoX = "";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f1920xxIXOIIO = "";

    /* renamed from: xoIox, reason: collision with root package name */
    public OxxIIOOXO f1919xoIox = OxxIIOOXO.DEBUG;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                synchronized (IXxxXO.this.f1917oIX0oI) {
                    try {
                        if (!IXxxXO.this.f1915X0o0xo) {
                            boolean z = false;
                            boolean z2 = true;
                            for (xoIox xoiox : IXxxXO.this.f1918oxoX) {
                                IXxxXO.this.f1913II0xO0.add(xoiox);
                                if (z2 && xoiox == IXxxXO.this.f1913II0xO0.first()) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z && !IXxxXO.this.Oo(xoiox)) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            }
                            IXxxXO.this.f1918oxoX.clear();
                            if (z) {
                                IXxxXO.this.o00(z2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public /* synthetic */ oIX0oI(IXxxXO iXxxXO, x0xO0oo x0xo0oo) {
            this();
        }
    }

    static {
        Class cls = f1910x0xO0oo;
        if (cls == null) {
            cls = II0XooXoX("org.apache.log4j.chainsaw.MyTableModel");
            f1910x0xO0oo = cls;
        }
        f1904OOXIXo = org.apache.log4j.x0xO0oo.xo0x(cls);
        f1907oOoXoXO = new x0xO0oo();
        f1908ooOOo0oXI = new String[]{"Time", "Priority", "Trace", "Category", "NDC", "Message"};
        f1909x0XOIxOo = new xoIox[0];
        f1906oO = DateFormat.getDateTimeInstance(3, 2);
    }

    public IXxxXO() {
        Thread thread = new Thread(new oIX0oI(this, null));
        thread.setDaemon(true);
        thread.start();
    }

    public static /* synthetic */ Class II0XooXoX(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void IIXOooo(String str) {
        synchronized (this.f1917oIX0oI) {
            this.f1916XO = str.trim();
            o00(false);
        }
    }

    public void IXxxXO(String str) {
        synchronized (this.f1917oIX0oI) {
            this.f1920xxIXOIIO = str.trim();
            o00(false);
        }
    }

    public int OOXIXo() {
        return f1908ooOOo0oXI.length;
    }

    public final boolean Oo(xoIox xoiox) {
        if (!xoiox.X0o0xo().isGreaterOrEqual(this.f1919xoIox) || xoiox.XO().indexOf(this.f1916XO) < 0 || xoiox.oIX0oI().indexOf(this.f1920xxIXOIIO) < 0) {
            return false;
        }
        if (this.f1912II0XooXoX.length() != 0 && (xoiox.oxoX() == null || xoiox.oxoX().indexOf(this.f1912II0XooXoX) < 0)) {
            return false;
        }
        String I0Io2 = xoiox.I0Io();
        if (I0Io2 == null) {
            if (this.f1914Oxx0IOOO.length() != 0) {
                return false;
            }
            return true;
        }
        if (I0Io2.indexOf(this.f1914Oxx0IOOO) < 0) {
            return false;
        }
        return true;
    }

    public void Oxx0IOOO(xoIox xoiox) {
        synchronized (this.f1917oIX0oI) {
            this.f1918oxoX.add(xoiox);
        }
    }

    public void Oxx0xo(String str) {
        synchronized (this.f1917oIX0oI) {
            this.f1914Oxx0IOOO = str.trim();
            o00(false);
        }
    }

    public void OxxIIOOXO(OxxIIOOXO oxxIIOOXO) {
        synchronized (this.f1917oIX0oI) {
            this.f1919xoIox = oxxIIOOXO;
            o00(false);
        }
    }

    public final void o00(boolean z) {
        xoIox xoiox;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int size = this.f1913II0xO0.size();
        for (xoIox xoiox2 : this.f1913II0xO0) {
            if (Oo(xoiox2)) {
                arrayList.add(xoiox2);
            }
        }
        xoIox[] xoioxArr = this.f1911I0Io;
        if (xoioxArr.length == 0) {
            xoiox = null;
        } else {
            xoiox = xoioxArr[0];
        }
        this.f1911I0Io = (xoIox[]) arrayList.toArray(f1909x0XOIxOo);
        if (z && xoiox != null) {
            int indexOf = arrayList.indexOf(xoiox);
            if (indexOf < 1) {
                f1904OOXIXo.XoX("In strange state");
                fireTableDataChanged();
            } else {
                fireTableRowsInserted(0, indexOf - 1);
            }
        } else {
            fireTableDataChanged();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        org.apache.log4j.x0xO0oo x0xo0oo = f1904OOXIXo;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Total time [ms]: ");
        stringBuffer.append(currentTimeMillis2 - currentTimeMillis);
        stringBuffer.append(" in update, size: ");
        stringBuffer.append(size);
        x0xo0oo.xxIXOIIO(stringBuffer.toString());
    }

    public void oI0IIXIo(String str) {
        synchronized (this.f1917oIX0oI) {
            this.f1912II0XooXoX = str.trim();
            o00(false);
        }
    }

    public Object oO(int i, int i2) {
        Boolean bool;
        synchronized (this.f1917oIX0oI) {
            try {
                xoIox xoiox = this.f1911I0Io[i];
                if (i2 == 0) {
                    return f1906oO.format(new Date(xoiox.II0XooXoX()));
                }
                if (i2 == 1) {
                    return xoiox.X0o0xo();
                }
                if (i2 == 2) {
                    if (xoiox.Oxx0IOOO() == null) {
                        bool = Boolean.FALSE;
                    } else {
                        bool = Boolean.TRUE;
                    }
                    return bool;
                }
                if (i2 == 3) {
                    return xoiox.oIX0oI();
                }
                if (i2 == 4) {
                    return xoiox.oxoX();
                }
                return xoiox.I0Io();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String oOoXoXO(int i) {
        return f1908ooOOo0oXI[i];
    }

    public xoIox ooOOo0oXI(int i) {
        xoIox xoiox;
        synchronized (this.f1917oIX0oI) {
            xoiox = this.f1911I0Io[i];
        }
        return xoiox;
    }

    public int x0XOIxOo() {
        int length;
        synchronized (this.f1917oIX0oI) {
            length = this.f1911I0Io.length;
        }
        return length;
    }

    public boolean x0xO0oo() {
        boolean z;
        synchronized (this.f1917oIX0oI) {
            z = this.f1915X0o0xo;
        }
        return z;
    }

    public Class xoIox(int i) {
        if (i == 2) {
            Class cls = f1905Oo;
            if (cls == null) {
                Class II0XooXoX2 = II0XooXoX("java.lang.Boolean");
                f1905Oo = II0XooXoX2;
                return II0XooXoX2;
            }
            return cls;
        }
        Class cls2 = f1903IXxxXO;
        if (cls2 == null) {
            Class II0XooXoX3 = II0XooXoX("java.lang.Object");
            f1903IXxxXO = II0XooXoX3;
            return II0XooXoX3;
        }
        return cls2;
    }

    public void xoXoI() {
        synchronized (this.f1917oIX0oI) {
            this.f1915X0o0xo = !this.f1915X0o0xo;
        }
    }

    public void xxIXOIIO() {
        synchronized (this.f1917oIX0oI) {
            this.f1913II0xO0.clear();
            this.f1911I0Io = new xoIox[0];
            this.f1918oxoX.clear();
            fireTableDataChanged();
        }
    }
}
