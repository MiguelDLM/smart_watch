package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.an;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes11.dex */
public final class f {
    @Nullable
    public static JSONArray Bg() {
        Context context = ServiceProvider.getContext();
        List<g> aY = aY(context);
        aY.add(aX(context));
        return g.t(aY);
    }

    private static g aX(Context context) {
        int i;
        boolean cE = an.cE(context);
        com.kwad.sdk.core.e.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + cE);
        if (cE) {
            i = g.PERMISSION_GRANTED;
        } else {
            i = g.PERMISSION_DENIED;
        }
        return new g(com.kuaishou.weapon.p0.g.k, i);
    }

    @NonNull
    private static List<g> aY(Context context) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        String[] cD = ak.cD(context);
        if (cD != null) {
            for (String str : cD) {
                int aq = an.aq(context, str);
                if (aq == 0) {
                    i = g.PERMISSION_GRANTED;
                } else if (aq == -1) {
                    i = g.PERMISSION_DENIED;
                } else {
                    i = g.aoF;
                }
                arrayList.add(new g(str, i));
            }
        }
        return arrayList;
    }
}
