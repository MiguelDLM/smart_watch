package xOIO;

import IIXOxIxOo.I0Io;
import android.content.Context;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static volatile II0xO0 f34454oIX0oI;

    public II0xO0(Context context) {
        I0Io.xoXoI(context).oOoXoXO(new oIxxIo.oIX0oI());
    }

    public static II0xO0 II0xO0(Context context) {
        if (f34454oIX0oI == null) {
            synchronized (II0xO0.class) {
                try {
                    if (f34454oIX0oI == null) {
                        f34454oIX0oI = new II0xO0(context);
                    }
                } finally {
                }
            }
        }
        return f34454oIX0oI;
    }

    public static II0xO0 oIX0oI() {
        return f34454oIX0oI;
    }
}
