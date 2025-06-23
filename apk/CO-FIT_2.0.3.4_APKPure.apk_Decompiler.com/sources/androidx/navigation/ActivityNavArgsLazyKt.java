package androidx.navigation;

import android.app.Activity;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

public final class ActivityNavArgsLazyKt {
    @MainThread
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Activity activity) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, "Args");
        return new NavArgsLazy<>(IO.oxoX(NavArgs.class), new ActivityNavArgsLazyKt$navArgs$1(activity));
    }
}
