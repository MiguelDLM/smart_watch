package androidx.activity;

import OXOo.OOXIXo;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(26)
class EdgeToEdgeApi26 extends EdgeToEdgeBase {
    @DoNotInline
    public void setUp(@OOXIXo SystemBarStyle systemBarStyle, @OOXIXo SystemBarStyle systemBarStyle2, @OOXIXo Window window, @OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(systemBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(systemBarStyle2, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(systemBarStyle.getScrim$activity_release(z));
        window.setNavigationBarColor(systemBarStyle2.getScrim$activity_release(z2));
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, view);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(!z);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(!z2);
    }
}
