package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> arz = new ConcurrentHashMap();
    private static SharedPreferences arA = null;

    private static SharedPreferences Cb() {
        if (arA == null) {
            arA = bg.gY("ksadsdk_config");
        }
        return arA;
    }

    public static <T> void a(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> ds = ds(key);
        if (ds == null) {
            ds = new CopyOnWriteArraySet<>();
            arz.put(key, ds);
        }
        ds.add(bVar);
    }

    @WorkerThread
    public static synchronized void bd(Context context) {
        synchronized (b.class) {
            try {
                SharedPreferences Cb = Cb();
                if (Cb != null) {
                    SharedPreferences.Editor edit = Cb.edit();
                    a(edit);
                    edit.commit();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @WorkerThread
    public static synchronized void be(Context context) {
        synchronized (b.class) {
            SharedPreferences Cb = Cb();
            if (Cb != null) {
                a(Cb);
            }
        }
    }

    @Nullable
    private static Set<com.kwad.sdk.core.config.item.b> ds(String str) {
        if (!TextUtils.isEmpty(str)) {
            return arz.get(str);
        }
        return null;
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : arz.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = arz.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.k(jSONObject);
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = arz.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = arz.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.b(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = arz.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = arz.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences Cb;
        if (bVar == null || (Cb = Cb()) == null) {
            return;
        }
        try {
            bVar.a(Cb);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }
}
