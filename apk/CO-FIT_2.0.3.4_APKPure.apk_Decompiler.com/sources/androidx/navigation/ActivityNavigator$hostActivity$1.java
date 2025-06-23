package androidx.navigation;

import Oox.oOoXoXO;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class ActivityNavigator$hostActivity$1 extends Lambda implements oOoXoXO<Context, Context> {
    public static final ActivityNavigator$hostActivity$1 INSTANCE = new ActivityNavigator$hostActivity$1();

    public ActivityNavigator$hostActivity$1() {
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
