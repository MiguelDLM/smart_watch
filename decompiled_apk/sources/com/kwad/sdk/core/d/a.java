package com.kwad.sdk.core.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class a {
    private static volatile a awt;
    public static ThreadLocal<SimpleDateFormat> awu = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.d.a.1
        @Nullable
        private static SimpleDateFormat Eu() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return Eu();
        }
    };

    public static a Ep() {
        if (awt == null) {
            synchronized (a.class) {
                try {
                    if (awt == null) {
                        awt = new a();
                    }
                } finally {
                }
            }
        }
        return awt;
    }

    public static boolean Eq() {
        List<f> de = de(15);
        if (de.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : de) {
            i += fVar.count;
            long j2 = fVar.aBc;
            if (j2 > j) {
                j = j2;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Es()) {
            return false;
        }
        if (j + (Et() * 1000) <= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static List<f> Er() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int Es() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Et() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void Q(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(@NonNull f fVar) {
        long j = fVar.aBc;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = awu.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    public static void bW(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            bX(adTemplate);
        }
    }

    private static void bX(AdTemplate adTemplate) {
        int ea = e.ea(adTemplate);
        int dM = e.dM(adTemplate);
        List Er = Er();
        if (Er != null && Er.size() != 0) {
            Iterator it = Er.iterator();
            while (true) {
                if (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.adStyle == dM && fVar.taskType == ea) {
                        fVar.count++;
                        if (!a(fVar)) {
                            fVar.count = 1;
                            fVar.ay(System.currentTimeMillis());
                        }
                    }
                } else {
                    Er.add(new f(dM, ea, 1, System.currentTimeMillis()));
                    break;
                }
            }
        } else {
            Er = new ArrayList();
            Er.add(new f(dM, ea, 1, System.currentTimeMillis()));
        }
        Q("ksadsdk_local_ad_task_info_adstyle_data", t.O(Er).toString());
        adTemplate.watched = true;
    }

    @NonNull
    private static List<f> de(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> Er = Er();
        if (Er != null && Er.size() != 0) {
            for (f fVar : Er) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void e(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }
}
