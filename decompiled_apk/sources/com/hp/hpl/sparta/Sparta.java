package com.hp.hpl.sparta;

import java.util.Hashtable;

/* loaded from: classes10.dex */
public class Sparta {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static X0o0xo f17160oIX0oI = new oIX0oI();

    /* renamed from: II0xO0, reason: collision with root package name */
    public static oxoX f17159II0xO0 = new II0xO0();

    /* loaded from: classes10.dex */
    public static class HashtableCache extends Hashtable implements I0Io {
        private HashtableCache() {
        }

        public /* synthetic */ HashtableCache(oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public interface I0Io {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    /* loaded from: classes10.dex */
    public static class II0xO0 implements oxoX {
        @Override // com.hp.hpl.sparta.Sparta.oxoX
        public I0Io create() {
            return new HashtableCache(null);
        }
    }

    /* loaded from: classes10.dex */
    public interface X0o0xo {
        String oIX0oI(String str);
    }

    /* loaded from: classes10.dex */
    public static class oIX0oI implements X0o0xo {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Hashtable f17161oIX0oI = new Hashtable();

        @Override // com.hp.hpl.sparta.Sparta.X0o0xo
        public String oIX0oI(String str) {
            String str2 = (String) this.f17161oIX0oI.get(str);
            if (str2 == null) {
                this.f17161oIX0oI.put(str, str);
                return str;
            }
            return str2;
        }
    }

    /* loaded from: classes10.dex */
    public interface oxoX {
        I0Io create();
    }

    public static void I0Io(oxoX oxox) {
        f17159II0xO0 = oxox;
    }

    public static I0Io II0xO0() {
        return f17159II0xO0.create();
    }

    public static String oIX0oI(String str) {
        return f17160oIX0oI.oIX0oI(str);
    }

    public static void oxoX(X0o0xo x0o0xo) {
        f17160oIX0oI = x0o0xo;
    }
}
