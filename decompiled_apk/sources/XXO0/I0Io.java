package XXO0;

import com.hp.hpl.sparta.ParseException;

/* loaded from: classes6.dex */
public class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static String[] f4082oIX0oI = {"_I", "_II", "_III", "_IV", "_V"};

    public static String oIX0oI(String str) {
        String oIX0oI2 = xoIox.oIX0oI(str);
        String II0xO02 = xoIox.II0xO0(str);
        try {
            com.hp.hpl.sparta.Oxx0IOOO Oxx0xo2 = II0xO0.oIX0oI().II0xO0().Oxx0xo("//" + II0XooXoX.f4084II0xO0.oIX0oI() + "[text()='" + oIX0oI2 + "']");
            if (Oxx0xo2 == null) {
                return null;
            }
            return Oxx0xo2.OxxIIOOXO("../" + II0XooXoX.f4085Oxx0IOOO.oIX0oI() + f4082oIX0oI[Integer.parseInt(II0xO02) - 1] + "/text()");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
