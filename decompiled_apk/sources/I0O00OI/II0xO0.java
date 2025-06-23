package I0O00OI;

import XO0.Oxx0IOOO;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
public class II0xO0 implements I0Io {
    @Override // I0O00OI.I0Io
    public void oIX0oI(Oxx0IOOO oxx0IOOO, Object obj) {
        if (oxx0IOOO != null && oxx0IOOO.f3855oIX0oI.get() != null) {
            try {
                oxx0IOOO.f3854II0xO0.invoke(oxx0IOOO.f3855oIX0oI.get(), obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
