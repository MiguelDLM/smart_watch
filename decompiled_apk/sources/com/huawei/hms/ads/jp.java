package com.huawei.hms.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes10.dex */
public class jp {
    private static final String Code = "ShowTrackerUtil";

    public static String Code(Bundle bundle) {
        String optString = com.huawei.openalliance.ad.utils.ay.V(bundle).optString(com.huawei.openalliance.ad.constant.bb.an, "");
        if (!com.huawei.openalliance.ad.utils.ay.L(optString)) {
            optString = null;
        }
        fb.V(Code, "decouple bundleCreativeSize: %s", optString);
        return optString;
    }

    public static Rect V(View view) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        fb.Code(Code, "viewRect: %s", rect.toString());
        return rect;
    }

    public static String Code(View view) {
        if (view == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int width = view.getWidth();
        int height = view.getHeight();
        sb.append(width);
        sb.append("*");
        sb.append(height);
        String sb2 = sb.toString();
        fb.V(Code, "decouple adViewCreativeSize: %s", sb2);
        return sb2;
    }

    public static String V(Bundle bundle) {
        String optString = com.huawei.openalliance.ad.utils.ay.V(bundle).optString(com.huawei.openalliance.ad.constant.bb.aL, "");
        if (!com.huawei.openalliance.ad.utils.ay.D(optString)) {
            optString = null;
        }
        fb.Code(Code, "slotPosition: %s", optString);
        return optString;
    }
}
