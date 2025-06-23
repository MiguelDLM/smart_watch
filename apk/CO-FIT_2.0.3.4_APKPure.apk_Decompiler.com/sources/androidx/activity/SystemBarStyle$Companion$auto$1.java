package androidx.activity;

import Oox.oOoXoXO;
import android.content.res.Resources;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class SystemBarStyle$Companion$auto$1 extends Lambda implements oOoXoXO<Resources, Boolean> {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    public SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    public final Boolean invoke(Resources resources) {
        IIX0o.x0xO0oo(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
