package XXO0;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.x0xO0oo;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public com.hp.hpl.sparta.X0o0xo f4090oIX0oI;

    /* renamed from: XXO0.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0063II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final II0xO0 f4091oIX0oI = new II0xO0();
    }

    public static II0xO0 oIX0oI() {
        return C0063II0xO0.f4091oIX0oI;
    }

    public final void I0Io() {
        try {
            oxoX(x0xO0oo.II0xO0("", xxIXOIIO.oIX0oI("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public com.hp.hpl.sparta.X0o0xo II0xO0() {
        return this.f4090oIX0oI;
    }

    public final void oxoX(com.hp.hpl.sparta.X0o0xo x0o0xo) {
        this.f4090oIX0oI = x0o0xo;
    }

    public II0xO0() {
        I0Io();
    }
}
