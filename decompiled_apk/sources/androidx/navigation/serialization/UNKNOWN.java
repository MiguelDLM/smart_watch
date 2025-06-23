package androidx.navigation.serialization;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import androidx.navigation.NavType;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class UNKNOWN extends NavType<String> {

    @OOXIXo
    public static final UNKNOWN INSTANCE = new UNKNOWN();

    private UNKNOWN() {
        super(false);
    }

    @Override // androidx.navigation.NavType
    @oOoXoXO
    public String get(@OOXIXo Bundle bundle, @OOXIXo String key) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(key, "key");
        return null;
    }

    @Override // androidx.navigation.NavType
    @OOXIXo
    public String getName() {
        return "unknown";
    }

    @Override // androidx.navigation.NavType
    public void put(@OOXIXo Bundle bundle, @OOXIXo String key, @OOXIXo String value) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(value, "value");
    }

    @Override // androidx.navigation.NavType
    @OOXIXo
    public String parseValue(@OOXIXo String value) {
        IIX0o.x0xO0oo(value, "value");
        return "null";
    }
}
