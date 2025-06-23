package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes10.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17362a = "dl_LoadHelper";
    private static final String b = "DynamicLoader";

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) {
        try {
            IObjectWrapper load = iDynamicLoader.load(ah.a(context), str, bundle.getInt("module_version"), ah.a(bundle));
            if (ah.a(load) == null) {
                af.c(f17362a, "Get remote context is null.");
                return null;
            }
            if (ah.a(load) instanceof Context) {
                af.b(f17362a, "Get context for the module:" + str + " success.");
                return (Context) ah.a(load);
            }
            af.c(f17362a, "Incorrect context type.");
            return null;
        } catch (Exception e) {
            af.c(f17362a, "Failed to get remote module context." + e.getClass().getSimpleName());
            return null;
        }
    }

    public static IBinder a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return (IBinder) new com.huawei.hms.ads.dynamicloader.d(str, ClassLoader.getSystemClassLoader()).loadClass("DynamicLoader").getConstructor(null).newInstance(null);
                }
            } catch (ClassNotFoundException e) {
                e = e;
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            } catch (IllegalAccessException e2) {
                e = e2;
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            } catch (InstantiationException e3) {
                e = e3;
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            } catch (NoSuchMethodException e4) {
                e = e4;
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new com.huawei.hms.ads.dynamicloader.j("Failed to instantiate dynamic loader:" + e.getMessage());
            }
        }
        throw new com.huawei.hms.ads.dynamicloader.j("Failed to get dynamicLoader path.");
    }

    public static void a(final int i, final String str, final String[] strArr, String str2) {
        com.huawei.hms.ads.dynamic.b.a(str2).execute(new com.huawei.hms.ads.dynamicloader.k(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.w.1
            @Override // java.lang.Runnable
            public final void run() {
                for (String str3 : strArr) {
                    if (Integer.parseInt(str3) < i) {
                        af.b(w.f17362a, "Delete low version:" + i + " in modulePath.");
                        ad.b(str + File.separator + str3);
                    }
                }
            }
        }));
    }
}
