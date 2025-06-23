package XI0IXoo;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes.dex */
public final class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f3709oIX0oI;

    public static void II0xO0(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        f3709oIX0oI = context2;
    }

    public static Context oIX0oI() {
        return f3709oIX0oI;
    }
}
