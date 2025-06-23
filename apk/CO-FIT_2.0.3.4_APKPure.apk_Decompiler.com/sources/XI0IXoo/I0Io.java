package XI0IXoo;

import android.annotation.SuppressLint;
import android.content.Context;

public final class I0Io {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: oIX0oI  reason: collision with root package name */
    public static Context f232oIX0oI;

    public static void II0xO0(Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        f232oIX0oI = context2;
    }

    public static Context oIX0oI() {
        return f232oIX0oI;
    }
}
