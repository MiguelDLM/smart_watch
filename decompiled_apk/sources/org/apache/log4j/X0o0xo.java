package org.apache.log4j;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class X0o0xo implements org.apache.log4j.spi.oIX0oI {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final String f33204II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static /* synthetic */ Class f33205xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public volatile X0o0xo f33206I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public volatile Level f33207II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f33208Oxx0IOOO = true;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public org.apache.log4j.spi.xxIXOIIO f33209X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public org.apache.log4j.helpers.oIX0oI f33210XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f33211oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ResourceBundle f33212oxoX;

    static {
        Class cls = f33205xxIXOIIO;
        if (cls == null) {
            cls = oxoX("org.apache.log4j.Category");
            f33205xxIXOIIO = cls;
        }
        f33204II0XooXoX = cls.getName();
    }

    public X0o0xo(String str) {
        this.f33211oIX0oI = str;
    }

    public static Enumeration IIXOooo() {
        return oO.II0xO0();
    }

    public static X0o0xo O0xOxO(Class cls) {
        return oO.I0Io(cls);
    }

    public static X0o0xo X0IIOO(String str) {
        return oO.oxoX(str);
    }

    public static /* synthetic */ Class oxoX(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void oxxXoxO() {
        oO.xoIox();
    }

    public static x0xO0oo x0xO0oo(String str) {
        return oO.oIX0oI(str);
    }

    public static final X0o0xo xI() {
        return oO.Oxx0IOOO();
    }

    public static org.apache.log4j.spi.xxIXOIIO xoXoI() {
        return oO.XO();
    }

    public void I0Io(LoggingEvent loggingEvent) {
        int i = 0;
        X0o0xo x0o0xo = this;
        while (true) {
            if (x0o0xo == null) {
                break;
            }
            synchronized (x0o0xo) {
                try {
                    org.apache.log4j.helpers.oIX0oI oix0oi = x0o0xo.f33210XO;
                    if (oix0oi != null) {
                        i += oix0oi.II0xO0(loggingEvent);
                    }
                    if (!x0o0xo.f33208Oxx0IOOO) {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            x0o0xo = x0o0xo.f33206I0Io;
        }
        if (i == 0) {
            this.f33209X0o0xo.oIX0oI(this);
        }
    }

    public void I0oOoX(ResourceBundle resourceBundle) {
        this.f33212oxoX = resourceBundle;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized oIX0oI II0XooXoX(String str) {
        org.apache.log4j.helpers.oIX0oI oix0oi = this.f33210XO;
        if (oix0oi != null && str != null) {
            return oix0oi.II0XooXoX(str);
        }
        return null;
    }

    public void II0xO0(boolean z, String str) {
        if (!z) {
            ooOOo0oXI(str);
        }
    }

    public ResourceBundle IIX0o() {
        for (X0o0xo x0o0xo = this; x0o0xo != null; x0o0xo = x0o0xo.f33206I0Io) {
            ResourceBundle resourceBundle = x0o0xo.f33212oxoX;
            if (resourceBundle != null) {
                return resourceBundle;
            }
        }
        return null;
    }

    public void IO(OxxIIOOXO oxxIIOOXO, String str, Object[] objArr, Throwable th) {
        if (!this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level) && oxxIIOOXO.isGreaterOrEqual(o00())) {
            String ooXIXxIX2 = ooXIXxIX(str);
            if (ooXIXxIX2 != null) {
                str = MessageFormat.format(ooXIXxIX2, objArr);
            }
            Oxx0xo(f33204II0XooXoX, oxxIIOOXO, str, th);
        }
    }

    public void IXxxXO(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(50000)) {
            return;
        }
        Level level = Level.FATAL;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, th);
        }
    }

    public final void Io(org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        this.f33209X0o0xo = xxixoiio;
    }

    public boolean IoOoX() {
        if (this.f33209X0o0xo.X0o0xo(10000)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(o00());
    }

    public void OI0(boolean z) {
        this.f33208Oxx0IOOO = z;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized Enumeration OOXIXo() {
        org.apache.log4j.helpers.oIX0oI oix0oi = this.f33210XO;
        if (oix0oi == null) {
            return org.apache.log4j.helpers.xoIox.oIX0oI();
        }
        return oix0oi.OOXIXo();
    }

    public void Oo(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(50000)) {
            return;
        }
        Level level = Level.FATAL;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, null);
        }
    }

    public org.apache.log4j.spi.xxIXOIIO OxI() {
        return this.f33209X0o0xo;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized void Oxx0IOOO(oIX0oI oix0oi) {
        if (oix0oi != null) {
            org.apache.log4j.helpers.oIX0oI oix0oi2 = this.f33210XO;
            if (oix0oi2 != null) {
                oix0oi2.Oxx0IOOO(oix0oi);
            }
        }
    }

    public void Oxx0xo(String str, OxxIIOOXO oxxIIOOXO, Object obj, Throwable th) {
        I0Io(new LoggingEvent(str, this, oxxIIOOXO, obj, th));
    }

    public OxxIIOOXO OxxIIOOXO() {
        for (X0o0xo x0o0xo = this; x0o0xo != null; x0o0xo = x0o0xo.f33206I0Io) {
            if (x0o0xo.f33207II0xO0 != null) {
                return x0o0xo.f33207II0xO0;
            }
        }
        return null;
    }

    public void X00IoxXI(OxxIIOOXO oxxIIOOXO, String str, Throwable th) {
        if (!this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level) && oxxIIOOXO.isGreaterOrEqual(o00())) {
            String ooXIXxIX2 = ooXIXxIX(str);
            if (ooXIXxIX2 != null) {
                str = ooXIXxIX2;
            }
            Oxx0xo(f33204II0XooXoX, oxxIIOOXO, str, th);
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized void X0o0xo(String str) {
        if (str != null) {
            org.apache.log4j.helpers.oIX0oI oix0oi = this.f33210XO;
            if (oix0oi != null) {
                oix0oi.X0o0xo(str);
            }
        }
    }

    public final Level XI0IXoo() {
        return this.f33207II0xO0;
    }

    public org.apache.log4j.spi.xxIXOIIO XIxXXX0x0() {
        return this.f33209X0o0xo;
    }

    public synchronized void XO() {
        Enumeration OOXIXo2 = OOXIXo();
        if (OOXIXo2 != null) {
            while (OOXIXo2.hasMoreElements()) {
                oIX0oI oix0oi = (oIX0oI) OOXIXo2.nextElement();
                if (oix0oi instanceof org.apache.log4j.spi.oIX0oI) {
                    oix0oi.close();
                }
            }
        }
    }

    public void XOxIOxOx(OxxIIOOXO oxxIIOOXO, Object obj, Throwable th) {
        if (!this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level) && oxxIIOOXO.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, oxxIIOOXO, obj, th);
        }
    }

    public void XX(OxxIIOOXO oxxIIOOXO) {
        this.f33207II0xO0 = (Level) oxxIIOOXO;
    }

    public void XoX(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(30000)) {
            return;
        }
        Level level = Level.WARN;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, null);
        }
    }

    public boolean Xx000oIo() {
        if (this.f33209X0o0xo.X0o0xo(20000)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(o00());
    }

    public final X0o0xo XxX0x0xxx() {
        return this.f33206I0Io;
    }

    public void o0(Level level) {
        this.f33207II0xO0 = level;
    }

    public Level o00() {
        for (X0o0xo x0o0xo = this; x0o0xo != null; x0o0xo = x0o0xo.f33206I0Io) {
            if (x0o0xo.f33207II0xO0 != null) {
                return x0o0xo.f33207II0xO0;
            }
        }
        return null;
    }

    public boolean oI0IIXIo() {
        return this.f33208Oxx0IOOO;
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized void oIX0oI(oIX0oI oix0oi) {
        try {
            if (this.f33210XO == null) {
                this.f33210XO = new org.apache.log4j.helpers.oIX0oI();
            }
            this.f33210XO.oIX0oI(oix0oi);
            this.f33209X0o0xo.I0Io(this, oix0oi);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public synchronized void oO() {
        org.apache.log4j.helpers.oIX0oI oix0oi = this.f33210XO;
        if (oix0oi != null) {
            oix0oi.oO();
            this.f33210XO = null;
        }
    }

    public boolean oOXoIIIo(OxxIIOOXO oxxIIOOXO) {
        if (this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level)) {
            return false;
        }
        return oxxIIOOXO.isGreaterOrEqual(o00());
    }

    @Override // org.apache.log4j.spi.oIX0oI
    public boolean oOoXoXO(oIX0oI oix0oi) {
        org.apache.log4j.helpers.oIX0oI oix0oi2;
        if (oix0oi != null && (oix0oi2 = this.f33210XO) != null) {
            return oix0oi2.oOoXoXO(oix0oi);
        }
        return false;
    }

    public void oo(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(20000)) {
            return;
        }
        Level level = Level.INFO;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, th);
        }
    }

    public void oo0xXOI0I(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(20000)) {
            return;
        }
        Level level = Level.INFO;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, null);
        }
    }

    public void ooOOo0oXI(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(40000)) {
            return;
        }
        Level level = Level.ERROR;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, null);
        }
    }

    public String ooXIXxIX(String str) {
        ResourceBundle IIX0o2 = IIX0o();
        if (IIX0o2 == null) {
            return null;
        }
        try {
            return IIX0o2.getString(str);
        } catch (MissingResourceException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No resource is associated with key \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            ooOOo0oXI(stringBuffer.toString());
            return null;
        }
    }

    public void oxXx0IX(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(30000)) {
            return;
        }
        Level level = Level.WARN;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, th);
        }
    }

    public void x0XOIxOo(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(40000)) {
            return;
        }
        Level level = Level.ERROR;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, th);
        }
    }

    public void x0o(OxxIIOOXO oxxIIOOXO, Object obj) {
        if (!this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level) && oxxIIOOXO.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, oxxIIOOXO, obj, null);
        }
    }

    public void xII(String str, OxxIIOOXO oxxIIOOXO, Object obj, Throwable th) {
        if (!this.f33209X0o0xo.X0o0xo(oxxIIOOXO.level) && oxxIIOOXO.isGreaterOrEqual(o00())) {
            Oxx0xo(str, oxxIIOOXO, obj, th);
        }
    }

    public final Level xXxxox0I() {
        return this.f33207II0xO0;
    }

    public void xoIox(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(10000)) {
            return;
        }
        Level level = Level.DEBUG;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, th);
        }
    }

    public void xxIXOIIO(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(10000)) {
            return;
        }
        Level level = Level.DEBUG;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33204II0XooXoX, level, obj, null);
        }
    }

    public final String xxX() {
        return this.f33211oIX0oI;
    }
}
