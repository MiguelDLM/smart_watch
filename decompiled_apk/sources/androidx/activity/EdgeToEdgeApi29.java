package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(29)
/* loaded from: classes.dex */
class EdgeToEdgeApi29 extends EdgeToEdgeApi28 {
    @Override // androidx.activity.EdgeToEdgeApi26, androidx.activity.EdgeToEdgeBase, androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(@OXOo.OOXIXo SystemBarStyle statusBarStyle, @OXOo.OOXIXo SystemBarStyle navigationBarStyle, @OXOo.OOXIXo Window window, @OXOo.OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(navigationBarStyle, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, "view");
        boolean z3 = false;
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrimWithEnforcedContrast$activity_release(z));
        window.setNavigationBarColor(navigationBarStyle.getScrimWithEnforcedContrast$activity_release(z2));
        window.setStatusBarContrastEnforced(false);
        if (navigationBarStyle.getNightMode$activity_release() == 0) {
            z3 = true;
        }
        window.setNavigationBarContrastEnforced(z3);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(!z);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(true ^ z2);
    }
}
