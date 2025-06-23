package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;
import com.realsil.sdk.dfu.image.constants.SubBinId;

/* loaded from: classes11.dex */
public final class aj {
    public static boolean ML() {
        return isOrientationPortrait();
    }

    public static void b(Context context, boolean z) {
        try {
            Activity dB = com.kwad.sdk.n.l.dB(context);
            if (dB == null) {
                return;
            }
            if (z) {
                dB.getWindow().getDecorView().setSystemUiVisibility(SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE);
            } else {
                dB.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cA(Context context) {
        Activity dB = com.kwad.sdk.n.l.dB(context);
        if (dB != null) {
            dB.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cB(Context context) {
        Activity dB = com.kwad.sdk.n.l.dB(context);
        if (dB != null) {
            dB.setRequestedOrientation(1);
        }
    }

    public static boolean cy(Context context) {
        Activity dB = com.kwad.sdk.n.l.dB(context);
        boolean z = false;
        if (dB != null) {
            Window window = dB.getWindow();
            if ((window.getAttributes().flags & 1024) == 1024) {
                z = true;
            }
            window.setFlags(1024, 1024);
        }
        return z;
    }

    public static void cz(Context context) {
        Activity dB = com.kwad.sdk.n.l.dB(context);
        if (dB != null) {
            dB.getWindow().clearFlags(1024);
        }
    }

    public static boolean isOrientationPortrait() {
        if (ServiceProvider.Lw().getApplicationContext().getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }
}
