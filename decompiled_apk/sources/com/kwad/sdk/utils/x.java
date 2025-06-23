package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes11.dex */
public final class x {
    private static AtomicInteger aQj = new AtomicInteger(0);
    private static volatile boolean aQk = false;
    private static volatile boolean aQl;

    private static int Ma() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.e.c.w("Ks_UnionHelper", "sdkConfigProvider == null");
            return 0;
        }
        int zt = hVar.zt();
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "config mode:" + zt);
        return zt;
    }

    private static void Mb() {
        if (aQk) {
            return;
        }
        aQj.set(Me());
        aQl = bg.m("kssdk_kv_mode", "downgrade", false);
        aQk = true;
    }

    public static void Mc() {
        if (Mf() || Ma() == 0) {
            return;
        }
        g.execute(new az() { // from class: com.kwad.sdk.utils.x.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.utils.b.a Md = x.Md();
                if (Md != null) {
                    x.c(Md);
                    com.kwad.sdk.utils.b.b bVar = (com.kwad.sdk.utils.b.b) ServiceProvider.get(com.kwad.sdk.utils.b.b.class);
                    if (bVar != null) {
                        bVar.a(Md);
                    }
                }
            }
        });
    }

    @WorkerThread
    public static com.kwad.sdk.utils.b.a Md() {
        Map<String, ?> all;
        com.kwad.sdk.utils.b.a aVar = new com.kwad.sdk.utils.b.a();
        SharedPreferences gY = bg.gY("ksadsdk_kv_perf");
        if (gY == null) {
            return null;
        }
        try {
            all = gY.getAll();
        } catch (Throwable unused) {
        }
        if (all == null) {
            return null;
        }
        Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Integer) it.next().getValue()).intValue();
        }
        aVar.aTq = i;
        SharedPreferences.Editor edit = gY.edit();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            edit.putInt(it2.next().getKey(), 0);
        }
        edit.apply();
        d(aVar);
        e(aVar);
        return aVar;
    }

    private static int Me() {
        int b = bg.b("kssdk_kv_mode", "mode", 0);
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "local mode:" + b);
        return b;
    }

    public static boolean Mf() {
        Mb();
        if (aQj.get() == 0) {
            return true;
        }
        return false;
    }

    private static boolean Mg() {
        if (Build.VERSION.SDK_INT > 23) {
            return true;
        }
        return false;
    }

    private static int Mh() {
        int i;
        Mb();
        if (!aQl && Mg()) {
            i = Ma();
        } else {
            i = 0;
        }
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "targetMode:" + i);
        return i;
    }

    public static void Mi() {
        boolean z;
        Mb();
        int i = aQj.get();
        int Mh = Mh();
        if (i != Mh) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "needTransfer:" + z);
        if (z) {
            transfer(Mh);
        }
    }

    private static void Mj() {
        g.execute(new az() { // from class: com.kwad.sdk.utils.x.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                Context context;
                try {
                    context = y.getContext();
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
                if (context == null) {
                    return;
                }
                Iterator<String> it = i.a.alC.iterator();
                while (it.hasNext()) {
                    x.R(context, it.next());
                }
                x.dZ(0);
                x.aQj.set(0);
            }
        });
    }

    private static void Mk() {
        com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "transferToKv");
        g.execute(new az() { // from class: com.kwad.sdk.utils.x.5
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                try {
                    Context context = y.getContext();
                    if (context != null) {
                        Iterator<String> it = i.a.alC.iterator();
                        while (it.hasNext()) {
                            x.Q(context, it.next());
                        }
                        x.dZ(1);
                        x.aQj.set(1);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.c.e("Ks_UnionHelper", Log.getStackTraceString(e));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q(Context context, String str) {
        SharedPreferences gY;
        com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
        if ("ksadsdk_splash_preload_id_list".equals(str) && (gY = bg.gY(str)) == null) {
            SharedPreferences.Editor edit = gY.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (!av.contains("sp_to_kv_transfer_flag")) {
            SharedPreferences gY2 = bg.gY(str);
            if (gY2 == null) {
                av.putBoolean("sp_to_kv_transfer_flag", true);
                return;
            }
            av.putAll(gY2.getAll());
            av.putBoolean("sp_to_kv_transfer_flag", true);
            bg.aw(str, "kv_to_sp_transfer_flag");
            a(str, av);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R(Context context, String str) {
        SharedPreferences gY = bg.gY(str);
        if (gY == null) {
            return;
        }
        if ("ksadsdk_splash_preload_id_list".equals(str)) {
            SharedPreferences.Editor edit = gY.edit();
            if (edit != null) {
                edit.remove("kv_to_sp_transfer_flag").remove("sp_to_kv_transfer_flag").apply();
                return;
            }
            return;
        }
        if (!gY.contains("kv_to_sp_transfer_flag")) {
            com.kwad.sdk.utils.a.c av = com.kwad.sdk.utils.a.e.av(context, str);
            Map<String, Object> all = av.getAll();
            if (all.isEmpty()) {
                bg.l(str, "kv_to_sp_transfer_flag", true);
                return;
            }
            bg.a(str, all);
            bg.l(str, "kv_to_sp_transfer_flag", true);
            av.remove("sp_to_kv_transfer_flag");
            av.release();
        }
    }

    private static void a(String str, com.kwad.sdk.utils.a.c cVar) {
        if (!i.a.alD.contains(str)) {
            cVar.release();
        }
    }

    @WorkerThread
    public static void ar(final String str, final String str2) {
        g.execute(new az() { // from class: com.kwad.sdk.utils.x.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                int b = bg.b("ksadsdk_kv_perf", str, 0);
                if (TextUtils.isEmpty(str2)) {
                    bg.aw("ksadsdk_kv_perf", str);
                } else {
                    bg.a("ksadsdk_kv_perf", str, b + 1);
                }
            }
        });
    }

    public static void as(final String str, final String str2) {
        g.execute(new az() { // from class: com.kwad.sdk.utils.x.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                SharedPreferences gY = bg.gY("ksadsdk_kv_perf");
                if (gY != null && gY.contains(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        bg.a("ksadsdk_kv_perf_failed", str, bg.b("ksadsdk_kv_perf_failed", str, 0) + 1);
                    } else {
                        bg.a("ksadsdk_kv_perf_success", str, bg.b("ksadsdk_kv_perf_success", str, 0) + 1);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(@NonNull com.kwad.sdk.utils.b.a aVar) {
        if (aVar.aTr / (r0 + aVar.aTs) > 0.10000000149011612d) {
            aQl = true;
            com.kwad.sdk.core.e.c.d("Ks_UnionHelper", "need downgrade");
            bg.l("kssdk_kv_mode", "downgrade", true);
        }
        if (aQl) {
            Mi();
        }
    }

    private static void d(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gY = bg.gY("ksadsdk_kv_perf_failed");
        int i = 0;
        if (gY != null) {
            Map<String, ?> all = gY.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    i += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.aTr = i;
            SharedPreferences.Editor edit = gY.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aTr = 0;
    }

    public static void dZ(int i) {
        bg.a("kssdk_kv_mode", "mode", i);
    }

    private static void e(com.kwad.sdk.utils.b.a aVar) {
        SharedPreferences gY = bg.gY("ksadsdk_kv_perf_success");
        int i = 0;
        if (gY != null) {
            Map<String, ?> all = gY.getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    i += ((Integer) it.next().getValue()).intValue();
                }
            }
            aVar.aTs = i;
            SharedPreferences.Editor edit = gY.edit();
            edit.clear();
            edit.apply();
            return;
        }
        aVar.aTs = 0;
    }

    private static void transfer(int i) {
        if (i == 0) {
            Mj();
        } else if (i == 1) {
            Mk();
        }
    }
}
