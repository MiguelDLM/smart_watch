package XXO0;

import com.hp.hpl.sparta.ParseException;

/* loaded from: classes6.dex */
public class Oxx0IOOO {
    public static String oIX0oI(String str, II0XooXoX iI0XooXoX, II0XooXoX iI0XooXoX2) {
        String oIX0oI2 = xoIox.oIX0oI(str);
        String II0xO02 = xoIox.II0xO0(str);
        try {
            com.hp.hpl.sparta.Oxx0IOOO Oxx0xo2 = XO.oIX0oI().II0xO0().Oxx0xo("//" + iI0XooXoX.oIX0oI() + "[text()='" + oIX0oI2 + "']");
            if (Oxx0xo2 == null) {
                return null;
            }
            return Oxx0xo2.OxxIIOOXO("../" + iI0XooXoX2.oIX0oI() + "/text()") + II0xO02;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
