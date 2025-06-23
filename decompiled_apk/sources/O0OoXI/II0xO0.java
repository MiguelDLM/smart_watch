package O0OoXI;

import IIXOxIxOo.I0Io;
import android.content.Context;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static volatile II0xO0 f1392oIX0oI;

    public II0xO0(Context context) {
        I0Io.xoXoI(context).oOoXoXO(new oIoxI0xx.oIX0oI());
    }

    public static II0xO0 II0xO0(Context context) {
        if (f1392oIX0oI == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f1392oIX0oI == null) {
                        f1392oIX0oI = new II0xO0(context);
                    }
                } finally {
                }
            }
        }
        return f1392oIX0oI;
    }

    public static II0xO0 oIX0oI() {
        return f1392oIX0oI;
    }
}
