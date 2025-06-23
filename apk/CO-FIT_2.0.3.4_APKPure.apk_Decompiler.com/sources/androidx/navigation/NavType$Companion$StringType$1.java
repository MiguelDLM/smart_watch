package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$StringType$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1212:1\n1#2:1213\n*E\n"})
public final class NavType$Companion$StringType$1 extends NavType<String> {
    public NavType$Companion$StringType$1() {
        super(true);
    }

    public String getName() {
        return TypedValues.Custom.S_STRING;
    }

    public String get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (String) bundle.get(str);
    }

    public String parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        if (IIX0o.Oxx0IOOO(str, "null")) {
            return null;
        }
        return str;
    }

    public void put(Bundle bundle, String str, String str2) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putString(str, str2);
    }

    public String serializeAsValue(String str) {
        String encode = str != null ? Uri.encode(str) : null;
        return encode == null ? "null" : encode;
    }
}
