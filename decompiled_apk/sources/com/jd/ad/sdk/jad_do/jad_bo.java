package com.jd.ad.sdk.jad_do;

import android.app.Application;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes10.dex */
public class jad_bo {
    public static Application jad_an;

    @Nullable
    public static Application jad_an() {
        Application application = jad_an;
        if (application != null) {
            return application;
        }
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Exception e) {
            Logger.w("get application error: ", e.getMessage());
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", null).invoke(null, null);
            } catch (Exception e2) {
                Logger.w("get application error: ", e2.getMessage());
                return null;
            }
        }
    }
}
