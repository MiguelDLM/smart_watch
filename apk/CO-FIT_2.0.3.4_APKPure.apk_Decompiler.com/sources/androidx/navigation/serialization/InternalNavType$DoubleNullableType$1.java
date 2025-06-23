package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$DoubleNullableType$1 extends NavType<Double> {
    public InternalNavType$DoubleNullableType$1() {
        super(true);
    }

    public String getName() {
        return "double_nullable";
    }

    public Double get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        return null;
    }

    public Double parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return InternalNavType.INSTANCE.getDoubleType().parseValue(str);
    }

    public void put(Bundle bundle, String str, Double d) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (d == null) {
            bundle.putSerializable(str, (Serializable) null);
        } else {
            InternalNavType.INSTANCE.getDoubleType().put(bundle, str, d);
        }
    }
}
