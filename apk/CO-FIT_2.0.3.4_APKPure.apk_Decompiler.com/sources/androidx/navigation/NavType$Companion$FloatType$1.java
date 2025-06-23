package androidx.navigation;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.IIX0o;

public final class NavType$Companion$FloatType$1 extends NavType<Float> {
    public NavType$Companion$FloatType$1() {
        super(false);
    }

    public String getName() {
        return TypedValues.Custom.S_FLOAT;
    }

    public /* bridge */ /* synthetic */ void put(Bundle bundle, String str, Object obj) {
        put(bundle, str, ((Number) obj).floatValue());
    }

    public Float get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        IIX0o.x0XOIxOo(obj, "null cannot be cast to non-null type kotlin.Float");
        return (Float) obj;
    }

    public Float parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return Float.valueOf(Float.parseFloat(str));
    }

    public void put(Bundle bundle, String str, float f) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putFloat(str, f);
    }
}
