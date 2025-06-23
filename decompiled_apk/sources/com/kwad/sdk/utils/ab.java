package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes11.dex */
public final class ab {
    @WorkerThread
    public static String a(Context context, String str, ac.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String am = ac.am(context, ac.a(str, aVar));
        String cK = aw.cK(context);
        if (!TextUtils.isEmpty(cK)) {
            am = am.replace("__MAC__", cK).replace("__MAC2__", ae.bx(cK)).replace("__MAC3__", ae.bx(cK.replace(":", "")));
        }
        String cI = aw.cI(context);
        if (!TextUtils.isEmpty(cI)) {
            am = am.replace("__IMEI__", cI).replace("__IMEI2__", ae.bx(cI)).replace("__IMEI3__", ae.gH(cI));
        }
        String oaid = aw.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            am = am.replace("__OAID__", oaid).replace("__OAID2__", ae.bx(oaid));
        }
        String cJ = aw.cJ(context);
        if (!TextUtils.isEmpty(cJ)) {
            am = am.replace("__ANDROIDID2__", ae.bx(cJ)).replace("__ANDROIDID3__", ae.gH(cJ)).replace("__ANDROIDID__", cJ);
        }
        return ac.c(context, am, z);
    }

    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(aw.cK(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(aw.cI(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(aw.getOaid())) {
            if (str2.contains("__OAID__")) {
                arrayList.add("__OAID__");
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(aw.cJ(context))) {
            if (str2.contains("__ANDROIDID__")) {
                arrayList.add("__ANDROIDID__");
            }
            if (str2.contains("__ANDROIDID2__")) {
                arrayList.add("__ANDROIDID2__");
            }
            if (str2.contains("__ANDROIDID3__")) {
                arrayList.add("__ANDROIDID3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "ANDROID", str, str2, (String) it4.next());
                }
                arrayList.clear();
            }
        }
    }
}
