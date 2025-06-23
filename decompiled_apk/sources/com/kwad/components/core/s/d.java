package com.kwad.components.core.s;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.s;

/* loaded from: classes11.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i, boolean z) {
        a(activity, 0, true, true);
    }

    private static void b(@NonNull Activity activity, int i, boolean z) {
        int i2;
        Window window = activity.getWindow();
        int i3 = Build.VERSION.SDK_INT;
        if (z && i3 >= 23) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (au.MQ()) {
                a(activity, true);
            } else if (au.MR()) {
                k.b(activity, true);
            }
            i2 = 9472;
        } else {
            i2 = 1280;
        }
        window.getDecorView().setSystemUiVisibility(i2);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean rG() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static void a(@NonNull Activity activity, int i, boolean z, boolean z2) {
        if (rG()) {
            b(activity, i, z);
            if (z2) {
                return;
            }
            activity.findViewById(R.id.content).setPadding(0, com.kwad.sdk.c.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z) {
        try {
            Integer num = (Integer) s.ap("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            num.intValue();
            s.callMethod(activity.getWindow(), "setExtraFlags", num, num);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
