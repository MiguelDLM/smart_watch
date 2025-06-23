package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import com.google.android.exoplayer2.C;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
/* loaded from: classes.dex */
final class EdgeToEdgeApi21 extends EdgeToEdgeBase {
    @Override // androidx.activity.EdgeToEdgeBase, androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(@OXOo.OOXIXo SystemBarStyle statusBarStyle, @OXOo.OOXIXo SystemBarStyle navigationBarStyle, @OXOo.OOXIXo Window window, @OXOo.OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(statusBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(navigationBarStyle, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(67108864);
        window.addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
    }
}
