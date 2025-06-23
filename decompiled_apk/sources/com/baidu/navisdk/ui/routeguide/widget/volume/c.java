package com.baidu.navisdk.ui.routeguide.widget.volume;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import com.baidu.navisdk.ui.routeguide.widget.f;

/* loaded from: classes8.dex */
public abstract class c extends f {
    public c(Activity activity, int i) {
        super(activity, i);
    }

    private void b() {
        int i;
        if (com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
            Window window = getWindow();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                i = 0;
            } else {
                i = 754974720;
            }
            window.setStatusBarColor(i);
            if (i2 >= 23) {
                window.getDecorView().setSystemUiVisibility(1280);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 8192);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
            window.addFlags(Integer.MIN_VALUE);
        }
    }

    public abstract void a(int i, int i2, int i3);

    public abstract void a(int i, int i2, int i3, int i4, boolean z, int i5, int i6);

    public abstract void a(boolean z);

    public boolean a() {
        return com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T() || com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q2();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }
}
