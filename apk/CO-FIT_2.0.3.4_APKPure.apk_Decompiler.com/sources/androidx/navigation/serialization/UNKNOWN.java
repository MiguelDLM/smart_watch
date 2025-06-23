package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.jvm.internal.IIX0o;

public final class UNKNOWN extends NavType<String> {
    @OOXIXo
    public static final UNKNOWN INSTANCE = new UNKNOWN();

    private UNKNOWN() {
        super(false);
    }

    @oOoXoXO
    public String get(@OOXIXo Bundle bundle, @OOXIXo String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return null;
    }

    @OOXIXo
    public String getName() {
        return "unknown";
    }

    public void put(@OOXIXo Bundle bundle, @OOXIXo String str, @OOXIXo String str2) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(str2, "value");
    }

    @OOXIXo
    public String parseValue(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        return "null";
    }
}
