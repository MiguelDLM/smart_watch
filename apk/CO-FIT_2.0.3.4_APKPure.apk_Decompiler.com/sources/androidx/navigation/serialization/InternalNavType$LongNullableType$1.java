package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$LongNullableType$1 extends NavType<Long> {
    public InternalNavType$LongNullableType$1() {
        super(true);
    }

    public String getName() {
        return "long_nullable";
    }

    public Long get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public Long parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return NavType.LongType.parseValue(str);
    }

    public void put(Bundle bundle, String str, Long l) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (l == null) {
            bundle.putSerializable(str, (Serializable) null);
        } else {
            NavType.LongType.put(bundle, str, l);
        }
    }
}
