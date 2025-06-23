package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.IIX0o;

public final class NavType$Companion$BoolType$1 extends NavType<Boolean> {
    public NavType$Companion$BoolType$1() {
        super(false);
    }

    public String getName() {
        return TypedValues.Custom.S_BOOLEAN;
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Boolean) obj).booleanValue());
    }

    public Boolean get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (Boolean) bundle.get(str);
    }

    public Boolean parseValue(String str) {
        boolean z;
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "true")) {
            z = true;
        } else if (IIX0o.Oxx0IOOO(str, "false")) {
            z = false;
        } else {
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }
        return Boolean.valueOf(z);
    }

    public void put(Bundle bundle, String str, boolean z) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putBoolean(str, z);
    }
}
