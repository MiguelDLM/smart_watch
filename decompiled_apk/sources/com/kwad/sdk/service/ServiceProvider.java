package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class ServiceProvider {
    private static List<Throwable> Kd;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aPc;

    @SuppressLint({"StaticFieldLeak"})
    private static Context aPd;
    private static SdkConfig aPe;
    private static boolean aPf;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    /* loaded from: classes11.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    public static void Lv() {
        aPf = true;
    }

    @NonNull
    @Deprecated
    public static Context Lw() {
        return mContext;
    }

    @NonNull
    public static SdkConfig Lx() {
        return aPe;
    }

    private static void b(Throwable th) {
        if (Kd == null) {
            Kd = new CopyOnWriteArrayList();
        }
        Kd.add(th);
    }

    public static void bP(Context context) {
        aPc = context;
        mContext = l.dH(context);
    }

    public static void c(SdkConfig sdkConfig) {
        aPe = sdkConfig;
    }

    public static void f(com.kwad.sdk.f.a<Throwable> aVar) {
        List<Throwable> list = Kd;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        Kd.clear();
        Kd = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return aPe.appId;
    }

    public static String getAppName() {
        return aPe.appName;
    }

    @NonNull
    public static Context getContext() {
        if (aPf) {
            return Lw();
        }
        if (aPd == null) {
            aPd = l.wrapContextIfNeed(mContext);
        }
        return aPd;
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }
}
