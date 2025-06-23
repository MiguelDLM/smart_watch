package com.github.appintro;

import android.view.View;

/* loaded from: classes9.dex */
public final class AppIntroBaseKt {
    private static final boolean isVisible(View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisible(View view, boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        view.setVisibility(i);
    }
}
