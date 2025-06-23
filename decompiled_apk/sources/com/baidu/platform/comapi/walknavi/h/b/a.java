package com.baidu.platform.comapi.walknavi.h.b;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;

/* loaded from: classes8.dex */
public class a {
    private static Bundle a(Bundle bundle, int i, int i2) {
        return bundle;
    }

    private static Bundle b(Bundle bundle, int i, int i2) {
        bundle.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist, i);
        bundle.putInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime, i2);
        return bundle;
    }

    public static Bundle a(Bundle bundle, int i, int i2, int i3) {
        bundle.putInt("updatetype", i);
        if (i == 1) {
            return a(bundle, i2, i3);
        }
        if (i == 2) {
            return b(bundle, i2, i3);
        }
        return null;
    }
}
