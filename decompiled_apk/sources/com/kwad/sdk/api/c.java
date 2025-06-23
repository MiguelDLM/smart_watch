package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class c {
    private static List<Throwable> Kd;
    private static IKsAdSDK amX;

    public static IKsAdSDK AD() {
        return amX;
    }

    public static boolean AE() {
        Boolean bool = (Boolean) f("enableDynamic", new Object[0]);
        if (bool == null || bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public static int AF() {
        Integer num = (Integer) f("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        amX = iKsAdSDK;
    }

    private static void b(Throwable th) {
        try {
            if (Kd == null) {
                Kd = new CopyOnWriteArrayList();
            }
            Kd.add(th);
        } catch (Throwable unused) {
        }
    }

    public static String cf(String str) {
        return (String) f("TRANSFORM_API_HOST", str);
    }

    @Nullable
    public static <T> T f(String str, Object... objArr) {
        try {
            T t = (T) amX.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(Throwable th) {
        try {
            if (amX != null && KsAdSDK.haseInit()) {
                amX.re(th);
            } else {
                b(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static void nq() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (c.Kd == null) {
                            return;
                        }
                        for (Throwable th : c.Kd) {
                            if (c.amX != null && KsAdSDK.haseInit()) {
                                c.amX.re(th);
                            }
                        }
                        c.Kd.clear();
                        c.s(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ List s(List list) {
        Kd = null;
        return null;
    }
}
