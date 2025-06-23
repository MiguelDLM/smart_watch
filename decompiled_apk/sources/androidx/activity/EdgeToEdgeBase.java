package androidx.activity;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
class EdgeToEdgeBase implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void adjustLayoutInDisplayCutoutMode(@OXOo.OOXIXo Window window) {
        IIX0o.x0xO0oo(window, "window");
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(@OXOo.OOXIXo SystemBarStyle statusBarStyle, @OXOo.OOXIXo SystemBarStyle navigationBarStyle, @OXOo.OOXIXo Window window, @OXOo.OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(navigationBarStyle, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, "view");
    }
}
