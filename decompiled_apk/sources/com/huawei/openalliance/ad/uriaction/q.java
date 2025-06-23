package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jj;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class q {
    private static final String Code = "q";

    public static p Code(Context context, AdContentData adContentData, Map<String, String> map) {
        if (context == null || adContentData == null || map == null) {
            return new k();
        }
        List<p> Code2 = Code(context, adContentData, map, adContentData.q());
        if (Code2 == null || Code2.size() <= 0) {
            return new k();
        }
        p pVar = null;
        for (p pVar2 : Code2) {
            if (pVar != null) {
                pVar.Code(pVar2);
            }
            pVar = pVar2;
        }
        return Code2.get(0);
    }

    private static List<p> Code(Context context, AdContentData adContentData, Map<String, String> map, List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Object obj = null;
        for (Integer num : list) {
            switch (num.intValue()) {
                case 0:
                    obj = new k();
                    break;
                case 1:
                    obj = new j(context, adContentData, false, map);
                    break;
                case 2:
                    obj = new i(context, adContentData, map);
                    break;
                case 3:
                    obj = new a(context, adContentData);
                    break;
                case 4:
                    obj = new j(context, adContentData, true, map);
                    break;
                case 5:
                    obj = new m(context, adContentData);
                    break;
                case 6:
                    obj = new c(context, adContentData);
                    break;
                case 7:
                    obj = new b(context, adContentData);
                    break;
                case 8:
                    obj = new l(context, adContentData);
                    break;
                case 9:
                    obj = new o(context, adContentData);
                    break;
                case 10:
                default:
                    fb.I(Code, "unsupport action:" + num);
                    obj = null;
                    break;
                case 11:
                    obj = new g(context, adContentData);
                    break;
                case 12:
                    obj = new e(context, adContentData);
                    break;
                case 13:
                    if (jj.Code(context)) {
                        obj = new n(context, adContentData);
                        break;
                    }
                    break;
                case 14:
                    obj = new f(context, adContentData, true, map);
                    break;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
