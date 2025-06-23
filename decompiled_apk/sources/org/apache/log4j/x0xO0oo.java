package org.apache.log4j;

/* loaded from: classes6.dex */
public class x0xO0oo extends X0o0xo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static /* synthetic */ Class f33504OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final String f33505xoIox;

    static {
        Class cls = f33504OOXIXo;
        if (cls == null) {
            cls = oxoX("org.apache.log4j.Logger");
            f33504OOXIXo = cls;
        }
        f33505xoIox = cls.getName();
    }

    public x0xO0oo(String str) {
        super(str);
    }

    public static x0xO0oo I0X0x0oIo() {
        return oO.Oxx0IOOO();
    }

    public static x0xO0oo XX0(String str, org.apache.log4j.spi.II0XooXoX iI0XooXoX) {
        return oO.X0o0xo(str, iI0XooXoX);
    }

    public static /* synthetic */ Class oxoX(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static x0xO0oo xXOx(String str) {
        return oO.oxoX(str);
    }

    public static x0xO0oo xo0x(Class cls) {
        return oO.oxoX(cls.getName());
    }

    public void Xo0(Object obj) {
        if (this.f33209X0o0xo.X0o0xo(5000)) {
            return;
        }
        Level level = Level.TRACE;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33505xoIox, level, obj, null);
        }
    }

    public void XoI0Ixx0(Object obj, Throwable th) {
        if (this.f33209X0o0xo.X0o0xo(5000)) {
            return;
        }
        Level level = Level.TRACE;
        if (level.isGreaterOrEqual(o00())) {
            Oxx0xo(f33505xoIox, level, obj, th);
        }
    }

    public boolean oX() {
        if (this.f33209X0o0xo.X0o0xo(5000)) {
            return false;
        }
        return Level.TRACE.isGreaterOrEqual(o00());
    }
}
