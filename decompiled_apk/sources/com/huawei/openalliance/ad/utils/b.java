package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class b {
    private static final String Code = "ActivityUtils";
    private static final int V = 5;

    public static String Code(Context context) {
        Activity V2 = V(context);
        if (V2 != null) {
            fb.Code(Code, "ana_tag  getActivityLocalClassName LocalClassName = %s", V2.getLocalClassName());
            return V2.getLocalClassName();
        }
        fb.Z(Code, "ana_tag  getActivityLocalClassName LocalClassName is null");
        return "";
    }

    private static Activity V(Context context) {
        if (context == null) {
            fb.Z(Code, "ana_tag getActivity context is null, return");
            return null;
        }
        int i = 0;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            i++;
            if (i > 5) {
                fb.Z(Code, "ana_tag getActivity loop too much times, return");
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String Code(Object obj) {
        String str;
        if (obj == null) {
            str = "ana_tag getActivityName obj is null, return";
        } else {
            if (obj instanceof View) {
                return Code(((View) obj).getContext());
            }
            str = "ana_tag  getActivityName activityname is not view";
        }
        fb.Z(Code, str);
        return null;
    }
}
