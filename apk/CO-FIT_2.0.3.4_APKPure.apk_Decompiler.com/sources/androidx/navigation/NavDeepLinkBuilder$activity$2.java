package androidx.navigation;

import Oox.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavDeepLinkBuilder$activity$2 extends Lambda implements oOoXoXO<Context, Activity> {
    public static final NavDeepLinkBuilder$activity$2 INSTANCE = new NavDeepLinkBuilder$activity$2();

    public NavDeepLinkBuilder$activity$2() {
        super(1);
    }

    public final Activity invoke(Context context) {
        IIX0o.x0xO0oo(context, "it");
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }
}
