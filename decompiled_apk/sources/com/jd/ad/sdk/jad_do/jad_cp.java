package com.jd.ad.sdk.jad_do;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes10.dex */
public class jad_cp {
    public static boolean jad_an(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }
}
