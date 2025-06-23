package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class d {
    private static final String Code = "BtnUriActionFactory";

    public static p Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (context == null || adContentData == null || map == null) {
            return new k();
        }
        List<p> V = V(context, adContentData, map, list);
        if (V == null || V.size() <= 0) {
            return new k();
        }
        p pVar = null;
        for (p pVar2 : V) {
            if (pVar != null) {
                pVar.Code(pVar2);
            }
            pVar = pVar2;
        }
        return V.get(0);
    }

    private static List<p> V(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        p kVar;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Integer num : list) {
            int intValue = num.intValue();
            if (intValue == 0) {
                kVar = new k();
            } else if (intValue != 14) {
                fb.I(Code, "unsupport action:" + num);
                kVar = null;
            } else {
                kVar = new f(context, adContentData, true, map);
            }
            if (kVar != null) {
                arrayList.add(kVar);
            }
        }
        return arrayList;
    }
}
