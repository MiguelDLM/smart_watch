package com.kwad.sdk.n;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.s;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public class e {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean Kc;
    private Resources aUk;
    private Resources aUl;
    private h aUm;
    private boolean aUn;
    private ClassLoader aUo;

    /* loaded from: classes11.dex */
    public static class a {
        private static final e aUp = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e OH() {
        return a.aUp;
    }

    private boolean OI() {
        Context Lw;
        Object a2;
        try {
            Lw = ServiceProvider.Lw();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!l.dG(Lw)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Object invoke = cls.getDeclaredMethod("get", null).invoke(null, null);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a2 = s.a(field, invoke)) != null) {
                for (Field field2 : a2.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        Resources resources = (Resources) field2.get(a2);
                        Resources resources2 = Lw.getResources();
                        h hVar = new h(resources, resources2);
                        s.a(field2, a2, hVar);
                        this.aUk = resources2;
                        this.aUl = resources;
                        this.aUm = hVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean zw() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zw();
    }

    private static boolean zx() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zx();
    }

    public final boolean Nm() {
        return this.Kc.get();
    }

    public final ClassLoader getClassLoader() {
        return this.aUo;
    }

    public final Resources getResources() {
        return this.aUm;
    }

    public final void init() {
        if (this.Kc.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yV()) {
                if (zw() && OI()) {
                    this.aUo = getClass().getClassLoader();
                    i.cj(zx());
                    com.kwad.sdk.core.e.c.d("KSDY/KSPlugin", toString());
                    this.aUn = true;
                } else {
                    this.aUn = false;
                }
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.Kc.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.aUk + ", mResResources=" + this.aUl + ", mPluginResources=" + this.aUm + ", mEnable=" + this.aUn + '}';
    }

    private e() {
        this.Kc = new AtomicBoolean(false);
    }
}
