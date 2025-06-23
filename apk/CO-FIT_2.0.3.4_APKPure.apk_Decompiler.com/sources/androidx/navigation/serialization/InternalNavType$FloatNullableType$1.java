package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$FloatNullableType$1 extends NavType<Float> {
    public InternalNavType$FloatNullableType$1() {
        super(true);
    }

    public String getName() {
        return "float_nullable";
    }

    public Float get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        if (obj instanceof Float) {
            return (Float) obj;
        }
        return null;
    }

    public Float parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return NavType.FloatType.parseValue(str);
    }

    public void put(Bundle bundle, String str, Float f) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (f == null) {
            bundle.putSerializable(str, (Serializable) null);
        } else {
            NavType.FloatType.put(bundle, str, f);
        }
    }
}
