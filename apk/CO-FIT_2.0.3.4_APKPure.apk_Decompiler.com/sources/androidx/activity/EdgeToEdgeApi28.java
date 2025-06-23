package androidx.activity;

import OXOo.OOXIXo;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.IIX0o;

@RequiresApi(28)
class EdgeToEdgeApi28 extends EdgeToEdgeApi26 {
    @DoNotInline
    public void adjustLayoutInDisplayCutoutMode(@OOXIXo Window window) {
        IIX0o.x0xO0oo(window, "window");
        window.getAttributes().layoutInDisplayCutoutMode = 1;
    }
}
