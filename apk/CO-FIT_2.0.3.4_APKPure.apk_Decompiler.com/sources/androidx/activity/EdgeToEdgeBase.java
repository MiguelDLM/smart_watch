package androidx.activity;

import OXOo.OOXIXo;
import android.view.View;
import android.view.Window;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.jvm.internal.IIX0o;

class EdgeToEdgeBase implements EdgeToEdgeImpl {
    public void adjustLayoutInDisplayCutoutMode(@OOXIXo Window window) {
        IIX0o.x0xO0oo(window, "window");
    }

    public void setUp(@OOXIXo SystemBarStyle systemBarStyle, @OOXIXo SystemBarStyle systemBarStyle2, @OOXIXo Window window, @OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(systemBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(systemBarStyle2, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
    }
}
