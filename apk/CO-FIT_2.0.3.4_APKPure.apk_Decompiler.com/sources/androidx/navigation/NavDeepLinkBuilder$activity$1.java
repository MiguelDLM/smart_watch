package androidx.navigation;

import Oox.oOoXoXO;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLinkBuilder$activity$1 extends Lambda implements oOoXoXO<Context, Context> {
    public static final NavDeepLinkBuilder$activity$1 INSTANCE = new NavDeepLinkBuilder$activity$1();

    public NavDeepLinkBuilder$activity$1() {
        super(1);
    }

    public final Context invoke(Context context) {
        IIX0o.x0xO0oo(context, "it");
        ContextWrapper contextWrapper = context instanceof ContextWrapper ? (ContextWrapper) context : null;
        if (contextWrapper != null) {
            return contextWrapper.getBaseContext();
        }
        return null;
    }
}
