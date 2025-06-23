package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$DoubleType$1 extends NavType<Double> {
    public InternalNavType$DoubleType$1() {
        super(false);
    }

    public String getName() {
        return "double";
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Number) obj).doubleValue());
    }

    public Double get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Double");
        return (Double) obj;
    }

    public Double parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return Double.valueOf(Double.parseDouble(str));
    }

    public void put(Bundle bundle, String str, double d) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putDouble(str, d);
    }
}
