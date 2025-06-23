package androidx.activity.result;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.xxIXOIIO;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class ActivityResultLauncherKt {
    public static final void launch(@OOXIXo ActivityResultLauncher<Void> activityResultLauncher, @oOoXoXO ActivityOptionsCompat activityOptionsCompat) {
        IIX0o.x0xO0oo(activityResultLauncher, "<this>");
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    @xxIXOIIO(name = "launchUnit")
    public static final void launchUnit(@OOXIXo ActivityResultLauncher<oXIO0o0XI> activityResultLauncher, @oOoXoXO ActivityOptionsCompat activityOptionsCompat) {
        IIX0o.x0xO0oo(activityResultLauncher, "<this>");
        activityResultLauncher.launch(oXIO0o0XI.f19155oIX0oI, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }
}
