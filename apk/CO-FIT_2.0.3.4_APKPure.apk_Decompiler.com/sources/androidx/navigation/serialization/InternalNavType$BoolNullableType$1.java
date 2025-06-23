package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$BoolNullableType$1 extends NavType<Boolean> {
    public InternalNavType$BoolNullableType$1() {
        super(true);
    }

    public String getName() {
        return "boolean_nullable";
    }

    public Boolean get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public Boolean parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return NavType.BoolType.parseValue(str);
    }

    public void put(Bundle bundle, String str, Boolean bool) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (bool == null) {
            bundle.putSerializable(str, (Serializable) null);
        } else {
            NavType.BoolType.put(bundle, str, bool);
        }
    }
}
