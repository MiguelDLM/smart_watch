package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class l {
    private final String anU;
    private final String anV;
    private final String anW;
    private Resources anX;
    private ClassLoader anY;
    private IKsAdSDK anZ;

    private l(String str, String str2, String str3) {
        this.anU = str;
        this.anV = str2;
        this.anW = str3;
    }

    private void AP() {
        if (!TextUtils.isEmpty(this.anU)) {
            File file = new File(this.anU);
            if (file.isFile() && file.exists()) {
                return;
            } else {
                throw new RuntimeException("mApk not a file");
            }
        }
        throw new RuntimeException("mApk is null");
    }

    public static synchronized l a(Context context, ClassLoader classLoader, String str) {
        l b;
        synchronized (l.class) {
            try {
                b = b(context, classLoader, i.u(context, str), i.v(context, str), i.w(context, str));
            } catch (Throwable th) {
                com.kwad.sdk.api.c.m(th);
                return null;
            }
        }
        return b;
    }

    public static l b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    if (Build.VERSION.SDK_INT >= 34 && context != null && context.getApplicationInfo().targetSdkVersion >= 34) {
                        file.setReadOnly();
                    }
                } catch (Throwable unused) {
                }
                l lVar = new l(str, str2, str3);
                lVar.a(context, classLoader);
                return lVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    public final Resources AN() {
        return this.anX;
    }

    public final IKsAdSDK AO() {
        return this.anZ;
    }

    public final ClassLoader getClassLoader() {
        return this.anY;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.anU + "', mDexDir='" + this.anV + "', mNativeLibDir='" + this.anW + "', mResource=" + this.anX + ", mClassLoader=" + this.anY + ", mKsSdk=" + this.anZ + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        AP();
        Resources a2 = r.a(context, context.getResources(), this.anU);
        ClassLoader a3 = f.a(context, classLoader, this.anU, this.anV, this.anW);
        IKsAdSDK a4 = Loader.a(a3);
        this.anX = a2;
        this.anY = a3;
        this.anZ = a4;
        int sDKType = a4.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }
}
