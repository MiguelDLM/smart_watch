package androidx.navigation;

import Oox.oOoXoXO;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class NavController$activity$1 extends Lambda implements oOoXoXO<Context, Context> {
    public static final NavController$activity$1 INSTANCE = new NavController$activity$1();

    public NavController$activity$1() {
        super(1);
    }

    public final Context invoke(Context context) {
        IIX0o.x0xO0oo(context, "it");
        if (context instanceof ContextWrapper) {
            return ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
