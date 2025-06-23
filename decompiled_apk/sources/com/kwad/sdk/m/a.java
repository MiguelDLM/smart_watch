package com.kwad.sdk.m;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.m.c;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();

    public static void a(@NonNull c cVar) {
        final List<c.a> list = cVar.aOs;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.En();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.m.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        if (!TextUtils.isEmpty(str) && (field = s.getField(obj, str)) != null) {
            return field.getClass().getName();
        }
        return "";
    }

    public static void a(Activity activity, @NonNull List<c.a> list) {
        try {
            for (c.a aVar : list) {
                if (aVar != null) {
                    String str = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.aOu)) {
                        str = aVar.aOu;
                    } else if (!TextUtils.isEmpty(aVar.aOv) && activity.getClass().getName().startsWith(aVar.aOu)) {
                        str = e(activity, aVar.aOv);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        int b = y.b("ksadsdk_perf_ranger_v2", str, 0) + 1;
                        y.a("ksadsdk_perf_ranger_v2", str, b);
                        com.kwad.sdk.core.e.c.d(TAG, "act:" + str + " num:" + b);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.e(TAG, "record:" + Log.getStackTraceString(th));
        }
    }
}
