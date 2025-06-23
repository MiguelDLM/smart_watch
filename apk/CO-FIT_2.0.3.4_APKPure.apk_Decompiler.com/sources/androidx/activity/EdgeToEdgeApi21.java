package androidx.activity;

import OXOo.OOXIXo;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(21)
final class EdgeToEdgeApi21 extends EdgeToEdgeBase {
    @DoNotInline
    public void setUp(@OOXIXo SystemBarStyle systemBarStyle, @OOXIXo SystemBarStyle systemBarStyle2, @OOXIXo Window window, @OOXIXo View view, boolean z, boolean z2) {
        IIX0o.x0xO0oo(systemBarStyle, "statusBarStyle");
        IIX0o.x0xO0oo(systemBarStyle2, "navigationBarStyle");
        IIX0o.x0xO0oo(window, "window");
        IIX0o.x0xO0oo(view, ViewHierarchyConstants.VIEW_KEY);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(67108864);
        window.addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
    }
}
