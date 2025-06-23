package com.huawei.hms.ads.dynamicloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.huawei.hms.ads.uiengineloader.ad;
import java.io.File;

/* loaded from: classes10.dex */
public final class i extends e {
    public i(Context context, String str, int i) {
        super(context, str, i);
        ((e) this).f17280a.applicationInfo.processName = getBaseContext().getApplicationInfo().processName;
    }

    private void a() {
        ((e) this).f17280a.applicationInfo.processName = getBaseContext().getApplicationInfo().processName;
    }

    @Override // com.huawei.hms.ads.dynamicloader.e, android.content.ContextWrapper, android.content.Context
    public final ApplicationInfo getApplicationInfo() {
        return ((e) this).f17280a.applicationInfo;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final File getFilesDir() {
        return new File(ad.c(((e) this).b));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageCodePath() {
        return ((e) this).b;
    }

    @Override // com.huawei.hms.ads.dynamicloader.e, android.content.ContextWrapper, android.content.Context
    public final String getPackageName() {
        return getApplicationInfo().packageName;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageResourcePath() {
        return ((e) this).b;
    }
}
