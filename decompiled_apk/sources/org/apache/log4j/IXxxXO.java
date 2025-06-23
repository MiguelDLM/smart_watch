package org.apache.log4j;

import java.util.Hashtable;

/* loaded from: classes6.dex */
public class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final IXxxXO f33179I0Io = new IXxxXO();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f33180oxoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Object f33181II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f33182oIX0oI;

    public IXxxXO() {
        boolean X0o0xo2 = org.apache.log4j.helpers.II0XooXoX.X0o0xo();
        this.f33182oIX0oI = X0o0xo2;
        if (!X0o0xo2) {
            this.f33181II0xO0 = new org.apache.log4j.helpers.Oxx0xo();
        }
    }

    public static Hashtable I0Io() {
        return f33179I0Io.oxoX();
    }

    public static void Oxx0IOOO(String str) {
        f33179I0Io.II0XooXoX(str);
    }

    public static void X0o0xo(String str, Object obj) {
        f33179I0Io.XO(str, obj);
    }

    public static Object oIX0oI(String str) {
        return f33179I0Io.II0xO0(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void II0XooXoX(String str) {
        Hashtable hashtable;
        if (!this.f33182oIX0oI && (hashtable = (Hashtable) ((org.apache.log4j.helpers.Oxx0xo) this.f33181II0xO0).get()) != null) {
            hashtable.remove(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object II0xO0(String str) {
        Hashtable hashtable;
        if (this.f33182oIX0oI || (hashtable = (Hashtable) ((org.apache.log4j.helpers.Oxx0xo) this.f33181II0xO0).get()) == null || str == null) {
            return null;
        }
        return hashtable.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void XO(String str, Object obj) {
        if (this.f33182oIX0oI) {
            return;
        }
        Hashtable hashtable = (Hashtable) ((org.apache.log4j.helpers.Oxx0xo) this.f33181II0xO0).get();
        if (hashtable == null) {
            hashtable = new Hashtable(7);
            ((org.apache.log4j.helpers.Oxx0xo) this.f33181II0xO0).set(hashtable);
        }
        hashtable.put(str, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Hashtable oxoX() {
        if (this.f33182oIX0oI) {
            return null;
        }
        return (Hashtable) ((org.apache.log4j.helpers.Oxx0xo) this.f33181II0xO0).get();
    }
}
