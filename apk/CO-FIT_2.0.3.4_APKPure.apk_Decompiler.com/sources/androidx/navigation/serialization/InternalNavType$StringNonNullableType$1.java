package androidx.navigation.serialization;

import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.jvm.internal.IIX0o;

public final class InternalNavType$StringNonNullableType$1 extends NavType<String> {
    public InternalNavType$StringNonNullableType$1() {
        super(false);
    }

    public String getName() {
        return "string_non_nullable";
    }

    public String parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return str;
    }

    public String get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        String string = bundle.getString(str);
        return string == null ? "null" : string;
    }

    public void put(Bundle bundle, String str, String str2) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(str2, "value");
        bundle.putString(str, str2);
    }

    public String serializeAsValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        String encode = Uri.encode(str);
        IIX0o.oO(encode, "encode(value)");
        return encode;
    }
}
