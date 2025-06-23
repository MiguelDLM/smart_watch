package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes10.dex */
public final class ak implements am {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17340a = "dl_PreferDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.am
    public final u a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        try {
            if (s.a(context, string).d > 0) {
                af.b(f17340a, "Choose the decompressedModuleVersion");
                return new s();
            }
            if (t.a(context, string) > 0) {
                af.b(f17340a, "Choose the HMSLoadStrategy");
                return new t();
            }
            af.c(f17340a, "No available module version.");
            return null;
        } catch (com.huawei.hms.ads.dynamicloader.j e) {
            throw e;
        } catch (Exception e2) {
            af.c(f17340a, "getLoadingStrategy other exception." + e2.getClass().getSimpleName());
            return null;
        }
    }
}
