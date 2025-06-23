package androidx.navigation;

import android.os.Bundle;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.II0xO0;
import kotlin.text.OxI;

public final class NavType$Companion$LongType$1 extends NavType<Long> {
    public NavType$Companion$LongType$1() {
        super(false);
    }

    public String getName() {
        return "long";
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Number) obj).longValue());
    }

    public Long get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Long");
        return (Long) obj;
    }

    public Long parseValue(String str) {
        String str2;
        long j;
        IIX0o.x0xO0oo(str, "value");
        if (OxI.XO0o(str, "L", false, 2, (Object) null)) {
            str2 = str.substring(0, str.length() - 1);
            IIX0o.oO(str2, "substring(...)");
        } else {
            str2 = str;
        }
        if (OxI.IOOoXo0Ix(str, HexStringBuilder.DEFAULT_PREFIX, false, 2, (Object) null)) {
            String substring = str2.substring(2);
            IIX0o.oO(substring, "substring(...)");
            j = Long.parseLong(substring, II0xO0.oIX0oI(16));
        } else {
            j = Long.parseLong(str2);
        }
        return Long.valueOf(j);
    }

    public void put(Bundle bundle, String str, long j) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putLong(str, j);
    }
}
