package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes11.dex */
final class s {
    public static boolean a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(t.getFileMD5(file).toLowerCase());
    }

    public static boolean k(File file) {
        if (file != null && file.exists() && file.length() > 0 && file.getName().endsWith(com.huawei.hms.ads.dynamicloader.b.b)) {
            return true;
        }
        return false;
    }
}
