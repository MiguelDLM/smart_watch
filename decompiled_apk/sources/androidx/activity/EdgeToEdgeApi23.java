package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(23)
/* loaded from: classes.dex */
final class EdgeToEdgeApi23 extends EdgeToEdgeBase {
    @Override // androidx.activity.EdgeToEdgeBase, androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(@OXOo.OOXIXo SystemBarStyle statusBarStyle, @OXOo.OOXIXo SystemBarStyle navigationBarStyle, @OXOo.OOXIXo Window window, @OXOo.OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(navigationBarStyle, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrim$activity_release(z));
        window.setNavigationBarColor(navigationBarStyle.getDarkScrim$activity_release());
        new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(!z);
    }
}
