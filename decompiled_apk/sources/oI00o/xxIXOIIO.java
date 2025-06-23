package oI00o;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/* loaded from: classes6.dex */
public class xxIXOIIO {
    public static void II0xO0(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        Window window = activity.getWindow();
        if (i > 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getVisibility() | 1280);
            return;
        }
        window.addFlags(67108864);
    }

    public static int oIX0oI(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
