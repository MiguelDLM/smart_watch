package XXO0;

import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.x0xO0oo;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public com.hp.hpl.sparta.X0o0xo f4092oIX0oI;

    /* loaded from: classes6.dex */
    public static class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final XO f4093oIX0oI = new XO();
    }

    public static XO oIX0oI() {
        return II0xO0.f4093oIX0oI;
    }

    public final void I0Io() {
        try {
            oxoX(x0xO0oo.II0xO0("", xxIXOIIO.oIX0oI("/pinyindb/pinyin_mapping.xml")));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public com.hp.hpl.sparta.X0o0xo II0xO0() {
        return this.f4092oIX0oI;
    }

    public final void oxoX(com.hp.hpl.sparta.X0o0xo x0o0xo) {
        this.f4092oIX0oI = x0o0xo;
    }

    public XO() {
        I0Io();
    }
}
