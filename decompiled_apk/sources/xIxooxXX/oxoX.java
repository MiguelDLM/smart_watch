package xIxooxXX;

import java.util.HashMap;

/* loaded from: classes13.dex */
public class oxoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f34446I0Io = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final /* synthetic */ boolean f34447X0o0xo = true;

    /* renamed from: oxoX, reason: collision with root package name */
    public static oxoX f34448oxoX;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap<String, oIX0oI> f34450oIX0oI = new HashMap<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f34449II0xO0 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* loaded from: classes13.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public String f34451I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public I0Io f34452II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public o0Oo.II0xO0 f34453oIX0oI;
    }

    public static int I0Io() {
        int i = f34446I0Io + 1;
        f34446I0Io = i;
        return i;
    }

    public static oxoX II0xO0() {
        if (f34448oxoX == null) {
            f34448oxoX = new oxoX();
        }
        return f34448oxoX;
    }

    public String oIX0oI(oIX0oI oix0oi) {
        int I0Io2 = I0Io();
        try {
            this.f34450oIX0oI.put("" + I0Io2, oix0oi);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + I0Io2;
    }

    public String oxoX() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }
}
