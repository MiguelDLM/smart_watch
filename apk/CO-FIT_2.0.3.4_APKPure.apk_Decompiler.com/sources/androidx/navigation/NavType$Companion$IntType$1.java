package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.text.II0xO0;
import kotlin.text.OxI;

public final class NavType$Companion$IntType$1 extends NavType<Integer> {
    public NavType$Companion$IntType$1() {
        super(false);
    }

    public String getName() {
        return TypedValues.Custom.S_INT;
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Number) obj).intValue());
    }

    public Integer get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Int");
        return (Integer) obj;
    }

    public Integer parseValue(String str) {
        int i;
        IIX0o.x0xO0oo(str, "value");
        if (OxI.IOOoXo0Ix(str, HexStringBuilder.DEFAULT_PREFIX, false, 2, (Object) null)) {
            String substring = str.substring(2);
            IIX0o.oO(substring, "substring(...)");
            i = Integer.parseInt(substring, II0xO0.oIX0oI(16));
        } else {
            i = Integer.parseInt(str);
        }
        return Integer.valueOf(i);
    }

    public void put(Bundle bundle, String str, int i) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putInt(str, i);
    }
}
