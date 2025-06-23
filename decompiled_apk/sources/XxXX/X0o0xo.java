package XxXX;

import android.content.Context;
import java.io.File;

/* loaded from: classes13.dex */
public final class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static Context f4223oIX0oI;

    public static final String I0Io() {
        if (oIX0oI() == null) {
            return "";
        }
        return oIX0oI().getPackageName();
    }

    public static final void II0xO0(Context context) {
        f4223oIX0oI = context;
    }

    public static final File X0o0xo() {
        if (oIX0oI() == null) {
            return null;
        }
        return oIX0oI().getExternalFilesDir(null);
    }

    public static final Context oIX0oI() {
        Context context = f4223oIX0oI;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final File oxoX() {
        if (oIX0oI() == null) {
            return null;
        }
        return oIX0oI().getFilesDir();
    }
}
