package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$IntNullableType$1 extends NavType<Integer> {
    public InternalNavType$IntNullableType$1() {
        super(true);
    }

    public String getName() {
        return "integer_nullable";
    }

    public Integer get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    public Integer parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return NavType.IntType.parseValue(str);
    }

    public void put(Bundle bundle, String str, Integer num) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        if (num == null) {
            bundle.putSerializable(str, (Serializable) null);
        } else {
            NavType.IntType.put(bundle, str, num);
        }
    }
}
