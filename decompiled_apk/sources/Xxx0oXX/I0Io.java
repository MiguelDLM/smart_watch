package Xxx0oXX;

import java.util.Hashtable;
import org.apache.log4j.helpers.II0XooXoX;
import org.apache.log4j.helpers.xxIXOIIO;
import org.apache.log4j.spi.oOoXoXO;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f4235I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static II0xO0 f4236II0xO0 = new oIX0oI();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Hashtable f4237oIX0oI = new Hashtable();

    public static /* synthetic */ Class II0xO0(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void oIX0oI(oOoXoXO oooxoxo, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Rendering class: [");
        stringBuffer.append(str2);
        stringBuffer.append("], Rendered class: [");
        stringBuffer.append(str);
        stringBuffer.append("].");
        xxIXOIIO.oIX0oI(stringBuffer.toString());
        Class cls = f4235I0Io;
        if (cls == null) {
            cls = II0xO0("org.apache.log4j.or.ObjectRenderer");
            f4235I0Io = cls;
        }
        II0xO0 iI0xO0 = (II0xO0) org.apache.log4j.helpers.oOoXoXO.XO(str2, cls, null);
        if (iI0xO0 == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not instantiate renderer [");
            stringBuffer2.append(str2);
            stringBuffer2.append("].");
            xxIXOIIO.I0Io(stringBuffer2.toString());
            return;
        }
        try {
            oooxoxo.oOoXoXO(II0XooXoX.XO(str), iI0xO0);
        } catch (ClassNotFoundException e) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not find class [");
            stringBuffer3.append(str);
            stringBuffer3.append("].");
            xxIXOIIO.oxoX(stringBuffer3.toString(), e);
        }
    }

    public void I0Io() {
        this.f4237oIX0oI.clear();
    }

    public void II0XooXoX(Class cls, II0xO0 iI0xO0) {
        this.f4237oIX0oI.put(cls, iI0xO0);
    }

    public II0xO0 Oxx0IOOO() {
        return f4236II0xO0;
    }

    public II0xO0 X0o0xo(Class cls) {
        while (cls != null) {
            II0xO0 iI0xO0 = (II0xO0) this.f4237oIX0oI.get(cls);
            if (iI0xO0 != null) {
                return iI0xO0;
            }
            II0xO0 xxIXOIIO2 = xxIXOIIO(cls);
            if (xxIXOIIO2 != null) {
                return xxIXOIIO2;
            }
            cls = cls.getSuperclass();
        }
        return f4236II0xO0;
    }

    public II0xO0 XO(Object obj) {
        if (obj == null) {
            return null;
        }
        return X0o0xo(obj.getClass());
    }

    public String oxoX(Object obj) {
        if (obj == null) {
            return null;
        }
        return X0o0xo(obj.getClass()).oIX0oI(obj);
    }

    public II0xO0 xxIXOIIO(Class cls) {
        II0xO0 iI0xO0 = (II0xO0) this.f4237oIX0oI.get(cls);
        if (iI0xO0 != null) {
            return iI0xO0;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            II0xO0 xxIXOIIO2 = xxIXOIIO(cls2);
            if (xxIXOIIO2 != null) {
                return xxIXOIIO2;
            }
        }
        return null;
    }
}
