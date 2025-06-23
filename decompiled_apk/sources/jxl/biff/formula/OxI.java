package jxl.biff.formula;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/* loaded from: classes6.dex */
public class OxI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27713I0Io = XxIIOXIXx.X0o0xo.Oxx0IOOO(OxI.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public HashMap f27714II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public HashMap f27715oIX0oI;

    public OxI(Locale locale) {
        String str;
        ResourceBundle bundle = ResourceBundle.getBundle("functions", locale);
        o00[] oxoX2 = o00.oxoX();
        this.f27715oIX0oI = new HashMap(oxoX2.length);
        this.f27714II0xO0 = new HashMap(oxoX2.length);
        for (o00 o00Var : oxoX2) {
            String Oxx0IOOO2 = o00Var.Oxx0IOOO();
            if (Oxx0IOOO2.length() != 0) {
                str = bundle.getString(Oxx0IOOO2);
            } else {
                str = null;
            }
            if (str != null) {
                this.f27715oIX0oI.put(o00Var, str);
                this.f27714II0xO0.put(str, o00Var);
            }
        }
    }

    public String II0xO0(o00 o00Var) {
        return (String) this.f27715oIX0oI.get(o00Var);
    }

    public o00 oIX0oI(String str) {
        return (o00) this.f27714II0xO0.get(str);
    }
}
